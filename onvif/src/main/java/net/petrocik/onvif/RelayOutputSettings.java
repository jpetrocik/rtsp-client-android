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

public  class RelayOutputSettings extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    public Enums.RelayMode Mode=Enums.RelayMode.Monostable;
    
    public String DelayTime;
    
    public Enums.RelayIdleState IdleState=Enums.RelayIdleState.closed;

    

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
        if (info.name.equals("Mode"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Mode = Enums.RelayMode.fromString(j.toString());
                    }
                }
                else if (obj instanceof Enums.RelayMode){
                    this.Mode = (Enums.RelayMode)obj;
                }
            }
            return true;
        }
        if (info.name.equals("DelayTime"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.DelayTime = ExtendedSoapSerializationEnvelope.getDateTimeConverter().convertDuration(j.toString());
                    }
                }
                else if (obj instanceof String){
                    this.DelayTime = (String)obj;
                }
                else{
                    this.DelayTime = "";
                }
            }
            return true;
        }
        if (info.name.equals("IdleState"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.IdleState = Enums.RelayIdleState.fromString(j.toString());
                    }
                }
                else if (obj instanceof Enums.RelayIdleState){
                    this.IdleState = (Enums.RelayIdleState)obj;
                }
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
            return this.Mode!=null?this.Mode.toString():SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==1)
        {
            return this.DelayTime!=null?ExtendedSoapSerializationEnvelope.getDateTimeConverter().getStringFromDuration(this.DelayTime):SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==2)
        {
            return this.IdleState!=null?this.IdleState.toString():SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 3;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
            if(propertyIndex==0)
            {
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "Mode";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==1)
            {
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "DelayTime";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==2)
            {
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "IdleState";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
