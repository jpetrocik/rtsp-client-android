package net.petrocik.onvif;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 6.0.1.1
//
// Created by Quasar Development 
//
//----------------------------------------------------



import org.ksoap2.serialization.*;
import java.util.Vector;
import java.util.Hashtable;

public class GetAudioEncoderConfigurationsResponse extends Vector<AudioEncoderConfiguration> implements KvmSerializable
{
    private transient java.lang.Object __source;

    public GetAudioEncoderConfigurationsResponse()
    {
    }

    public GetAudioEncoderConfigurationsResponse(int initialCapactiy)
    {
        super(initialCapactiy);
    }

    public GetAudioEncoderConfigurationsResponse(java.util.Collection< AudioEncoderConfiguration> initialCapactiy)
    {
        super(initialCapactiy);
    }

    public void loadFromSoap(java.lang.Object inObj,ExtendedSoapSerializationEnvelope __envelope)
    {
        if (inObj == null)
            return;
        __source=inObj;
        SoapObject soapObject=(SoapObject)inObj;
        int size = soapObject.getPropertyCount();
        for (int i0=0;i0< size;i0++)
        {
            java.lang.Object obj = soapObject.getProperty(i0);
            if (obj!=null && obj instanceof AttributeContainer)
            {
                AttributeContainer j =(AttributeContainer) soapObject.getProperty(i0);
                AudioEncoderConfiguration j1= (AudioEncoderConfiguration)__envelope.get(j,AudioEncoderConfiguration.class,false);
                add(j1);
                
            }
        }
    }

    public java.lang.Object getSourceObject()
    {
        return __source;
    }
    
    @Override
    public java.lang.Object getProperty(int arg0) {
        return this.get(arg0)!=null?this.get(arg0):SoapPrimitive.NullNilElement;
    }
    
    @Override
    public int getPropertyCount() {
        return this.size();
    }
    
    @Override
    public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
        info.name = "Configurations";
        info.type = AudioEncoderConfiguration.class;
    	info.namespace= "http://www.onvif.org/ver10/media/wsdl";
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }

    
}