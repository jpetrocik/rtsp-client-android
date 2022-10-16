package com.alexvas.rtsp.demo.live

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.view.LayoutInflater
import android.view.PixelCopy
import android.view.View
import android.view.ViewGroup
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
import java.util.concurrent.atomic.AtomicBoolean


@SuppressLint("LogNotTimber")
class LiveFragment : Fragment() {

    private var profileToken = "MainStreamProfileToken";
    private lateinit var defaultPTZSpeed: PTZSpeed;
    private var presets = mutableListOf<String>();

    private lateinit var binding: FragmentLiveBinding

    private val rtspStatusListener = object: RtspSurfaceView.RtspStatusListener {
        override fun onRtspStatusConnecting() {
            binding.pbLoading.visibility = View.VISIBLE
            binding.vShutter.visibility = View.VISIBLE
            enable(binding.muteButton, false)
            enable(binding.snapShotButton, false)
            enable(binding.tvStatus, false)
            enable(binding.preset1, false);
            enable(binding.preset2, false);
            enable(binding.preset3, false);
            enable(binding.preset4, false);
            enable(binding.preset5, false);
        }

        override fun onRtspStatusConnected() {
        }

        override fun onRtspStatusDisconnected() {
            binding.pbLoading.visibility = View.GONE
            binding.vShutter.visibility = View.VISIBLE
            enable(binding.muteButton, false)
            enable(binding.snapShotButton, false)
            enable(binding.tvStatus, false)
            enable(binding.preset1, false);
            enable(binding.preset2, false);
            enable(binding.preset3, false);
            enable(binding.preset4, false);
            enable(binding.preset5, false);
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
            binding.vShutter.visibility = View.GONE
            binding.pbLoading.visibility = View.GONE
            enable(binding.muteButton, true)
            enable(binding.snapShotButton, true)
            enable(binding.tvStatus, true)
        }
    }

    private fun enable(imageButton: ImageButton, enabled: Boolean) {
        if (context == null)
            return;

        imageButton.isEnabled = enabled
        val statusColor = if (imageButton.isEnabled) R.color.colorEnabled else R.color.colorDisabled
        imageButton.imageTintList = ResourcesCompat.getColorStateList(resources, statusColor, null)
    }

    private fun enable(textView: TextView, enabled: Boolean) {
        if (context == null)
            return;

        textView.isEnabled = enabled
        val statusColor = if (textView.isEnabled) R.color.colorEnabled else R.color.colorDisabled
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

        binding.muteButton.setOnClickListener {
            if (it is ImageButton) {
                binding.svVideo.muteAudio = !binding.svVideo.muteAudio;
                val statusColor = if (binding.svVideo.muteAudio) R.color.colorDisabled else R.color.colorEnabled
                it.imageTintList = ResourcesCompat.getColorStateList(resources, statusColor, null)
            }
        }

        binding.snapShotButton.setOnClickListener {
            val bitmap = getSnapshot()
            // TODO Save snapshot to DCIM folder
            if (bitmap != null) {
                Toast.makeText(requireContext(), "Snapshot succeeded", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(), "Snapshot failed", Toast.LENGTH_LONG).show()
            }
        }

        binding.preset1.setOnClickListener( {
            gotoPreset(1);
        })

        binding.preset2.setOnClickListener( {
            gotoPreset(2);
        })

        binding.preset3.setOnClickListener( {
            gotoPreset(3);
        })

        binding.preset4.setOnClickListener( {
            gotoPreset(4);
        })

        binding.preset5.setOnClickListener( {
            gotoPreset(5);
        })

        return binding.root
    }

    override fun onResume() {
        if (DEBUG) Log.v(TAG, "onResume()")
        super.onResume()

        val sharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context /* Activity context */)
        val url = sharedPreferences.getString("url", null)
        val username = sharedPreferences.getString("username", null)
        val password = sharedPreferences.getString("password", null)

        getPtzConfiguration();

        if (url == null) {
            val myIntent = Intent(context, SettingsActivity::class.java)
            startActivity(myIntent)
            return;
        }

        var uri = Uri.parse(url);
        binding.svVideo.init(uri, username, password, "rtsp-client-android")
        binding.svVideo.start(true, true)
    }

    override fun onPause() {
        val started = binding.svVideo.isStarted()
        if (DEBUG) Log.v(TAG, "onPause(), started:$started")
        super.onPause()

        if (started) {
            binding.svVideo.stop()
        }
    }

    companion object {
        private val TAG: String = LiveFragment::class.java.simpleName
        private const val DEBUG = true
    }

    private fun getPtzConfiguration() {

        val sharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context /* Activity context */)
        val onvif = sharedPreferences.getString("onvif", null)

        if (onvif == null)
            return

        var ptzBinding = PTZBinding( object: IServiceEvents {
            override fun Starting() {};
            override fun Completed(result: OperationResult<*>?) {
                var res = result!!.Result;
                when (res) {
                    is GetConfigurationsResponse -> {
                        defaultPTZSpeed = res[0].DefaultPTZSpeed;

                        enable(binding.preset1, true);
                        enable(binding.preset2, true);
                        enable(binding.preset3, true);
                        enable(binding.preset4, true);
                        enable(binding.preset5, true);
                    }
                    is GetPresetsResponse -> {
                        presets.clear();
                        for (i in 0..4) {
                            presets.add(res[i].token);
                        }                    }
                }
            }}, onvif );

        ptzBinding.GetConfigurationsAsync();
        ptzBinding.GetPresetsAsync(profileToken);

    }
    private fun gotoPreset(preset: Int) {
        val sharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context /* Activity context */)
        val onvif = sharedPreferences.getString("onvif", null)

        if (onvif == null)
            return

        var ptzBinding = PTZBinding(object: IServiceEvents {
            override fun Starting() {};
            override fun Completed(result: OperationResult<*>?) {}}, onvif )
        ptzBinding.GotoPresetAsync(profileToken, presets[preset-1], defaultPTZSpeed);

    }

}
