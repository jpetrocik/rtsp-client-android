package net.petrocik.onvif;
//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 6.0.1.1
//
// Created by Quasar Development 
//
//----------------------------------------------------


import java.util.Hashtable;
import org.ksoap2.serialization.*;

public  class ImagingSettingsExtension203 extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    public ToneCompensation ToneCompensation;
    
    public Defogging Defogging;
    
    public NoiseReduction NoiseReduction;
    
    public ImagingSettingsExtension204 Extension;

    

    public void loadFromSoap(java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
        if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;
        __source=inObj; 
        
        if(inObj instanceof SoapObject)
        {
            SoapObject soapObject=(SoapObject)inObj;
            int size = soapObject.getPropertyCount();
            for (int i0=0;i0< size;i0++)
            {
                PropertyInfo info=soapObject.getPropertyInfo(i0);
                if(!loadProperty(info,soapObject,__envelope))
                {
                }
            } 
        }


    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("ToneCompensation"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.ToneCompensation = (ToneCompensation)__envelope.get(j,ToneCompensation.class,false);
            }
            return true;
        }
        if (info.name.equals("Defogging"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Defogging = (Defogging)__envelope.get(j,Defogging.class,false);
            }
            return true;
        }
        if (info.name.equals("NoiseReduction"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.NoiseReduction = (NoiseReduction)__envelope.get(j,NoiseReduction.class,false);
            }
            return true;
        }
        if (info.name.equals("Extension"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Extension = (ImagingSettingsExtension204)__envelope.get(j,ImagingSettingsExtension204.class,false);
            }
            return true;
        }
        return false;
    }    
    public java.lang.Object getOriginalXmlSource()
    {
        return __source;
    }    
    
    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return this.ToneCompensation!=null?this.ToneCompensation:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==1)
        {
            return this.Defogging!=null?this.Defogging:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==2)
        {
            return this.NoiseReduction!=null?this.NoiseReduction:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==3)
        {
            return this.Extension!=null?this.Extension:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 4;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
            if(propertyIndex==0)
            {
                info.type = ToneCompensation.class;
                info.name = "ToneCompensation";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==1)
            {
                info.type = Defogging.class;
                info.name = "Defogging";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==2)
            {
                info.type = NoiseReduction.class;
                info.name = "NoiseReduction";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==3)
            {
                info.type = ImagingSettingsExtension204.class;
                info.name = "Extension";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
