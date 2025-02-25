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
import java.util.ArrayList;
import org.ksoap2.serialization.PropertyInfo;

public  class PTZPresetTourSupported extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    public Integer MaximumNumberOfPresetTours=0;
    
    public java.util.ArrayList< Enums.PTZPresetTourOperation> PTZPresetTourOperation =new java.util.ArrayList<Enums.PTZPresetTourOperation >();
    
    public PTZPresetTourSupportedExtension Extension;

    

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
        if (info.name.equals("MaximumNumberOfPresetTours"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.MaximumNumberOfPresetTours = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.MaximumNumberOfPresetTours = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("PTZPresetTourOperation"))
        {
            if(obj!=null)
            {
                if(this.PTZPresetTourOperation==null)
                {
                    this.PTZPresetTourOperation = new java.util.ArrayList< Enums.PTZPresetTourOperation>();
                }
                java.lang.Object j =obj;
                Enums.PTZPresetTourOperation j1= Enums.PTZPresetTourOperation.fromString(j.toString());
                this.PTZPresetTourOperation.add(j1);
            }
            return true;
        }
        if (info.name.equals("Extension"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Extension = (PTZPresetTourSupportedExtension)__envelope.get(j,PTZPresetTourSupportedExtension.class,false);
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
            return this.MaximumNumberOfPresetTours;
        }
        else if(propertyIndex>=1 && propertyIndex < 1+this.PTZPresetTourOperation.size())
        {
            Enums.PTZPresetTourOperation PTZPresetTourOperation = this.PTZPresetTourOperation.get(propertyIndex-(1));
            return PTZPresetTourOperation!=null?PTZPresetTourOperation.toString():SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==1+this.PTZPresetTourOperation.size())
        {
            return this.Extension!=null?this.Extension:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 2+PTZPresetTourOperation.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
            if(propertyIndex==0)
            {
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "MaximumNumberOfPresetTours";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex>=1 && propertyIndex < 1+this.PTZPresetTourOperation.size())
            {
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "PTZPresetTourOperation";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==1+this.PTZPresetTourOperation.size())
            {
                info.type = PTZPresetTourSupportedExtension.class;
                info.name = "Extension";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
