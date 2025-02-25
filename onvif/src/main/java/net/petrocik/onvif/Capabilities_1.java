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

public  class Capabilities_1 extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    public AnalyticsCapabilities Analytics;
    
    public DeviceCapabilities Device;
    
    public EventCapabilities Events;
    
    public ImagingCapabilities Imaging;
    
    public MediaCapabilities Media;
    
    public PTZCapabilities PTZ;
    
    public CapabilitiesExtension Extension;

    

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
        if (info.name.equals("Analytics"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Analytics = (AnalyticsCapabilities)__envelope.get(j,AnalyticsCapabilities.class,false);
            }
            return true;
        }
        if (info.name.equals("Device"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Device = (DeviceCapabilities)__envelope.get(j,DeviceCapabilities.class,false);
            }
            return true;
        }
        if (info.name.equals("Events"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Events = (EventCapabilities)__envelope.get(j,EventCapabilities.class,false);
            }
            return true;
        }
        if (info.name.equals("Imaging"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Imaging = (ImagingCapabilities)__envelope.get(j,ImagingCapabilities.class,false);
            }
            return true;
        }
        if (info.name.equals("Media"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Media = (MediaCapabilities)__envelope.get(j,MediaCapabilities.class,false);
            }
            return true;
        }
        if (info.name.equals("PTZ"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.PTZ = (PTZCapabilities)__envelope.get(j,PTZCapabilities.class,false);
            }
            return true;
        }
        if (info.name.equals("Extension"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Extension = (CapabilitiesExtension)__envelope.get(j,CapabilitiesExtension.class,false);
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
            return this.Analytics!=null?this.Analytics:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==1)
        {
            return this.Device!=null?this.Device:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==2)
        {
            return this.Events!=null?this.Events:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==3)
        {
            return this.Imaging!=null?this.Imaging:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==4)
        {
            return this.Media!=null?this.Media:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==5)
        {
            return this.PTZ!=null?this.PTZ:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==6)
        {
            return this.Extension!=null?this.Extension:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 7;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
            if(propertyIndex==0)
            {
                info.type = AnalyticsCapabilities.class;
                info.name = "Analytics";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==1)
            {
                info.type = DeviceCapabilities.class;
                info.name = "Device";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==2)
            {
                info.type = EventCapabilities.class;
                info.name = "Events";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==3)
            {
                info.type = ImagingCapabilities.class;
                info.name = "Imaging";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==4)
            {
                info.type = MediaCapabilities.class;
                info.name = "Media";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==5)
            {
                info.type = PTZCapabilities.class;
                info.name = "PTZ";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==6)
            {
                info.type = CapabilitiesExtension.class;
                info.name = "Extension";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
