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

public  class VideoSourceMode extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    public Float MaxFramerate=0f;
    
    public VideoResolution MaxResolution;
    
    public String Encodings;
    
    public Boolean Reboot=false;
    
    public String Description;
    
    public VideoSourceModeExtension Extension;
    
    public String token;
    
    public Boolean Enabled=false;

    

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

		if (inObj.hasAttribute("token"))
        {	
            java.lang.Object j = inObj.getAttribute("token");
            if (j != null)
            {
                token = j.toString();
            }
        }
		if (inObj.hasAttribute("Enabled"))
        {	
            java.lang.Object j = inObj.getAttribute("Enabled");
            if (j != null)
            {
                Enabled = Boolean.valueOf(j.toString());
            }
        }

    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("MaxFramerate"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.MaxFramerate = Float.valueOf(j.toString());
                    }
                }
                else if (obj instanceof Float){
                    this.MaxFramerate = (Float)obj;
                }
            }
            return true;
        }
        if (info.name.equals("MaxResolution"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.MaxResolution = (VideoResolution)__envelope.get(j,VideoResolution.class,false);
            }
            return true;
        }
        if (info.name.equals("Encodings"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Encodings = j.toString();
                    }
                }
                else{
                    this.Encodings = obj.toString();
                }
            }
            return true;
        }
        if (info.name.equals("Reboot"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Reboot = Boolean.valueOf(j.toString());
                    }
                }
                else if (obj instanceof Boolean){
                    this.Reboot = (Boolean)obj;
                }
            }
            return true;
        }
        if (info.name.equals("Description"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Description = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.Description = (String)obj;
                }
                else{
                    this.Description = "";
                }
            }
            return true;
        }
        if (info.name.equals("Extension"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Extension = (VideoSourceModeExtension)__envelope.get(j,VideoSourceModeExtension.class,false);
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
            return this.MaxFramerate;
        }
        else if(propertyIndex==1)
        {
            return this.MaxResolution;
        }
        else if(propertyIndex==2)
        {
            return this.Encodings;
        }
        else if(propertyIndex==3)
        {
            return this.Reboot;
        }
        else if(propertyIndex==4)
        {
            return this.Description!=null?this.Description:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==5)
        {
            return this.Extension!=null?this.Extension:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 6;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
            if(propertyIndex==0)
            {
                info.type = Float.class;
                info.name = "MaxFramerate";
                info.namespace= "http://www.onvif.org/ver10/media/wsdl";
            }
            else if(propertyIndex==1)
            {
                info.type = VideoResolution.class;
                info.name = "MaxResolution";
                info.namespace= "http://www.onvif.org/ver10/media/wsdl";
            }
            else if(propertyIndex==2)
            {
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "Encodings";
                info.namespace= "http://www.onvif.org/ver10/media/wsdl";
            }
            else if(propertyIndex==3)
            {
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "Reboot";
                info.namespace= "http://www.onvif.org/ver10/media/wsdl";
            }
            else if(propertyIndex==4)
            {
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "Description";
                info.namespace= "http://www.onvif.org/ver10/media/wsdl";
            }
            else if(propertyIndex==5)
            {
                info.type = VideoSourceModeExtension.class;
                info.name = "Extension";
                info.namespace= "http://www.onvif.org/ver10/media/wsdl";
            }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }



        public int getAttributeCount() {
        return 2;
    }
    
    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
if(index==0)
        {
            info.name = "token";
            info.namespace= "";
            if(this.token!=null)
            {
                info.setValue(this.token);
            }
        
        }
        if(index==1)
        {
            info.name = "Enabled";
            info.namespace= "";
            if(this.Enabled!=null)
            {
                info.setValue(this.Enabled);
            }
        
        }
        
    }

    @Override
    public void getAttribute(int i, AttributeInfo attributeInfo) {

    }

    @Override
    public void setAttribute(AttributeInfo attributeInfo) {

    }    
}
