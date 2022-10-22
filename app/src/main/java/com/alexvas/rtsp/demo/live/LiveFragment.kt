package com.alexvas.rtsp.demo.live

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.HandlerThread
import android.provider.MediaStore
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.alexvas.rtsp.demo.R
import com.alexvas.rtsp.demo.SettingsActivity
import com.alexvas.rtsp.demo.databinding.FragmentLiveBinding
import com.alexvas.rtsp.widget.RtspSurfaceView
import net.petrocik.onvif.*
import java.io.File
import java.io.File.separator
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.concurrent.atomic.AtomicBoolean


@SuppressLint("LogNotTimber")
class LiveFragment : Fragment() {

    private var profileToken = "MainStreamProfileToken"
    private lateinit var defaultPTZSpeed: PTZSpeed
    private var presets = mutableListOf<String>()
    private var connected = false

    private lateinit var binding: FragmentLiveBinding

    private val rtspStatusListener = object: RtspSurfaceView.RtspStatusListener {
        override fun onRtspStatusConnecting() {
            connected = false

            binding.pbLoading.visibility = View.VISIBLE
            binding.vShutter.visibility = View.VISIBLE
            enableActions(false)
            enablePresets(false)
        }

        override fun onRtspStatusConnected() {
        }

        override fun onRtspStatusDisconnected() {
            connected = false

            binding.pbLoading.visibility = View.GONE
            binding.vShutter.visibility = View.VISIBLE
            enableActions(false)
            enablePresets(false)
        }

        override fun onRtspStatusFailedUnauthorized() {
            if (context == null) return
            binding.pbLoading.visibility = View.GONE
            Toast.makeText(context, "Authentication Failure" , Toast.LENGTH_LONG).show()
        }

        override fun onRtspStatusFailed(message: String?) {
            if (context == null) return
            binding.pbLoading.visibility = View.GONE
            Toast.makeText(context, message , Toast.LENGTH_LONG).show()
        }

        override fun onRtspFirstFrameRendered() {
            connected = true

            binding.vShutter.visibility = View.GONE
            binding.pbLoading.visibility = View.GONE
            enableActions(true)
            enablePresets(true)

            resize(1080, 1980)

        }
    }

    private fun enablePresets(enabled: Boolean){
        if (!enabled || connected && !presets.isNullOrEmpty()) {
            enable(binding.preset1, enabled)
            enable(binding.preset2, enabled)
            enable(binding.preset3, enabled)
            enable(binding.preset4, enabled)
            enable(binding.preset5, enabled)
        }
    }

    private fun enableActions(enabled: Boolean) {
        enable(binding.snapShotButton, enabled)
        enable(binding.tvStatus, enabled)
    }

    private fun enable(imageButton: ImageButton, enabled: Boolean) {
        if (context == null)
            return

        imageButton.isEnabled = enabled
        val statusColor = if (imageButton.isEnabled) R.color.colorPrimary else R.color.colorPrimaryDisabled
        imageButton.imageTintList = ResourcesCompat.getColorStateList(resources, statusColor, null)
    }

    private fun enable(textButton: Button, enabled: Boolean) {
        if (context == null)
            return

        textButton.isEnabled = enabled
        val statusColor = if (textButton.isEnabled) R.color.colorPrimary else R.color.colorPrimaryDisabled
        textButton.backgroundTintList = ResourcesCompat.getColorStateList(resources, statusColor, null)
    }

    private fun enable(textView: TextView, enabled: Boolean) {
        if (context == null)
            return

        textView.isEnabled = enabled
        val statusColor = if (textView.isEnabled) R.color.colorPrimary else R.color.colorPrimaryDisabled
        textView.setTextColor(ResourcesCompat.getColor(resources, statusColor, null))
    }

    private fun getSnapshot(): Bitmap? {
        if (DEBUG) Log.v(TAG, "getSnapshot()")
        val surfaceBitmap = Bitmap.createBitmap(1920, 1080, Bitmap.Config.ARGB_8888)
        val lock = Object()
        val success = AtomicBoolean(false)
        val thread = HandlerThread("PixelCopyHelper")
        thread.start()
        val sHandler = Handler(thread.looper)
        val listener = PixelCopy.OnPixelCopyFinishedListener { copyResult ->
            success.set(copyResult == PixelCopy.SUCCESS)
            synchronized (lock) {
                lock.notify()
            }
        }
        synchronized (lock) {
            PixelCopy.request(binding.svVideo.holder.surface, surfaceBitmap, listener, sHandler)
            lock.wait()
        }
        thread.quitSafely()
        return if (success.get()) surfaceBitmap else null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        if (DEBUG) Log.v(TAG, "onCreateView()")

        binding = FragmentLiveBinding.inflate(inflater, container, false)

        binding.svVideo.setStatusListener(rtspStatusListener)

        binding.settingsButton.setOnClickListener {
            val myIntent = Intent(context, SettingsActivity::class.java)
            startActivity(myIntent)
        }

        binding.snapShotButton.setOnClickListener {
            val bitmap = getSnapshot()

            if (bitmap != null) {
                saveImage(bitmap, context!!)
                Toast.makeText(requireContext(), "Snapshot succeeded", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(), "Snapshot failed", Toast.LENGTH_LONG).show()
            }
        }

        binding.preset1.setOnClickListener {
            gotoPreset(1)
        }

        binding.preset2.setOnClickListener {
            gotoPreset(2)
        }

        binding.preset3.setOnClickListener {
            gotoPreset(3)
        }

        binding.preset4.setOnClickListener {
            gotoPreset(4)
        }

        binding.preset5.setOnClickListener {
            gotoPreset(5)
        }

        return binding.root
    }

    override fun onResume() {
        if (DEBUG) Log.v(TAG, "onResume()")
        super.onResume()

        val sharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

        val onvif = sharedPreferences.getString("onvif", "")
        if (onvif == null || onvif.equals("")) {
            binding.presetPanel.visibility = View.GONE
        } else {
            binding.presetPanel.visibility = View.VISIBLE
//            getConfiguration(onvif)
            getPtzConfiguration(onvif)
        }
        val url = sharedPreferences.getString("url", "")
        val username = sharedPreferences.getString("username", "")
        val password = sharedPreferences.getString("password", "")

        if (url.equals("")) {
            val myIntent = Intent(context, SettingsActivity::class.java)
            startActivity(myIntent)
            return
        }

        var uri = Uri.parse(url)
        binding.svVideo.init(uri, username, password, "rtsp-client-android")
        binding.svVideo.start(true, true)
    }

    override fun onPause() {
        val started = binding.svVideo.isStarted()
        if (DEBUG) Log.v(TAG, "onPause(), started:$started")
        super.onPause()

        binding.presetPanel.visibility = View.GONE

        enablePresets(false)
        enableActions(false)

        if (started) {
            binding.svVideo.stop()
        }
    }

    companion object {
        private val TAG: String = LiveFragment::class.java.simpleName
        private const val DEBUG = true
        private const val SNAPSHOT_FOLDER_NAME = "IPCamera"
    }

    private fun getPtzConfiguration(onvif: String) {
        var ptzBinding = PTZBinding( object: IServiceEvents {
            override fun Starting() {}
            override fun Completed(result: OperationResult<*>?) {
                var res = result!!.Result
                when (res) {
                    is GetConfigurationsResponse -> {
                        defaultPTZSpeed = res[0].DefaultPTZSpeed
                        this@LiveFragment.getPresets(onvif)
                    }
                }
            }}, onvif )

        ptzBinding.GetConfigurationsAsync()

    }

//    private fun getConfiguration(onvif: String) {
//
//        var mediaBinding = MediaBinding( object: IServiceEvents {
//            override fun Starting() {}
//            override fun Completed(result: OperationResult<*>?) {
//                var res = result!!.Result
//                when (res) {
//                    is Profile -> {
//                        var videoResolution = res.VideoEncoderConfiguration.Resolution
//                    }
//                }
//            }}, onvif )
//
//        mediaBinding.GetProfileAsync(profileToken)
//
//    }

    private fun resize(height: Int, width: Int) {
        var decorView = this@LiveFragment.activity?.window?.decorView

        val resource = context!!.resources.getIdentifier(
            "status_bar_height",
            "dimen",
            "android"
        )

        var statusBarHeight = 0;
        if (resource > 0) {
            statusBarHeight = context!!.resources.getDimensionPixelSize(resource)
        }

        var videoRatio =  height.toDouble() / width.toDouble()
        if (decorView?.height == null || decorView.width == null)
            return

        var layoutParams = binding.svVideo.layoutParams;

        var viewRatio =  Math.min(decorView.height.toDouble() - statusBarHeight, decorView.width.toDouble()) / Math.max(decorView.height.toDouble() - statusBarHeight, decorView.width.toDouble())
        layoutParams.height = if (videoRatio > viewRatio)
                (decorView.width * viewRatio).toInt()
        else
            (decorView.width * videoRatio).toInt()

        binding.svVideo.layoutParams = layoutParams;
    }

    private fun getPresets(onvif: String) {
        var ptzBinding = PTZBinding( object: IServiceEvents {
            override fun Starting() {}
            override fun Completed(result: OperationResult<*>?) {
                var res = result!!.Result
                when (res) {
                    is GetPresetsResponse -> {
                        presets.clear()
                        for (i in 0..4) {
                            presets.add(res[i].token)
                        }
                        enablePresets(true)
                    }
                }
            }}, onvif )

        ptzBinding.GetPresetsAsync(profileToken)
    }

    private fun gotoPreset(preset: Int) {
        val sharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

        val onvif = sharedPreferences.getString("onvif", "");
        if (onvif.equals(""))
            return;

        var ptzBinding = PTZBinding(object: IServiceEvents {
            override fun Starting() {}
            override fun Completed(result: OperationResult<*>?) {}}, onvif )
        ptzBinding.GotoPresetAsync(profileToken, presets[preset-1], defaultPTZSpeed)

    }

    /// @param folderName can be your app's name
    private fun saveImage(bitmap: Bitmap, context: Context) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            val values = contentValues()
            values.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/" + SNAPSHOT_FOLDER_NAME)
            values.put(MediaStore.Images.Media.IS_PENDING, true)
            // RELATIVE_PATH and IS_PENDING are introduced in API 29.

            val uri: Uri? = context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
            if (uri != null) {
                saveImageToStream(bitmap, context.contentResolver.openOutputStream(uri))
                values.put(MediaStore.Images.Media.IS_PENDING, false)
                context.contentResolver.update(uri, values, null, null)
            }
        } else {
            val directory = File(Environment.getExternalStorageDirectory().toString() + separator + SNAPSHOT_FOLDER_NAME)
            // getExternalStorageDirectory is deprecated in API 29

            if (!directory.exists()) {
                directory.mkdirs()
            }
            val fileName = System.currentTimeMillis().toString() + ".png"
            val file = File(directory, fileName)
            saveImageToStream(bitmap, FileOutputStream(file))
            if (file.absolutePath != null) {
                val values = contentValues()
                values.put(MediaStore.Images.Media.DATA, file.absolutePath)
                // .DATA is deprecated in API 29
                context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
            }
        }
    }

    private fun contentValues() : ContentValues {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/png")
        values.put(MediaStore.Images.Media.DATE_ADDED, System.currentTimeMillis() / 1000);
        values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
        return values
    }

    private fun saveImageToStream(bitmap: Bitmap, outputStream: OutputStream?) {
        if (outputStream != null) {
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
                outputStream.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
