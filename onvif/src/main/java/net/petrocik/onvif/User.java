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

public  class User extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    public String Username;
    
    public String Password;
    
    public Enums.UserLevel UserLevel=Enums.UserLevel.Administrator;
    
    public UserExtension Extension;

    

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
        if (info.name.equals("Username"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Username = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.Username = (String)obj;
                }
                else{
                    this.Username = "";
                }
            }
            return true;
        }
        if (info.name.equals("Password"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Password = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.Password = (String)obj;
                }
                else{
                    this.Password = "";
                }
            }
            return true;
        }
        if (info.name.equals("UserLevel"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.UserLevel = Enums.UserLevel.fromString(j.toString());
                    }
                }
                else if (obj instanceof Enums.UserLevel){
                    this.UserLevel = (Enums.UserLevel)obj;
                }
            }
            return true;
        }
        if (info.name.equals("Extension"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Extension = (UserExtension)__envelope.get(j,UserExtension.class,false);
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
            return this.Username;
        }
        else if(propertyIndex==1)
        {
            return this.Password!=null?this.Password:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==2)
        {
            return this.UserLevel!=null?this.UserLevel.toString():SoapPrimitive.NullSkip;
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
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "Username";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==1)
            {
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "Password";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==2)
            {
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "UserLevel";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==3)
            {
                info.type = UserExtension.class;
                info.name = "Extension";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
