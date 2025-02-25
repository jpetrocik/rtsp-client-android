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

public  class IOCapabilitiesExtension extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    public Boolean Auxiliary;
    
    public java.util.ArrayList< String> AuxiliaryCommands =new java.util.ArrayList<String >();
    
    public IOCapabilitiesExtension2 Extension;
    
    public java.util.ArrayList< PropertyInfo> any =new java.util.ArrayList< PropertyInfo>();

    

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
                    info= __envelope.getAny(info);
                    this.any.add(info);
                }
            } 
        }


    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("Auxiliary"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Auxiliary = Boolean.valueOf(j.toString());
                    }
                }
                else if (obj instanceof Boolean){
                    this.Auxiliary = (Boolean)obj;
                }
            }
            return true;
        }
        if (info.name.equals("AuxiliaryCommands"))
        {
            if(obj!=null)
            {
                if(this.AuxiliaryCommands==null)
                {
                    this.AuxiliaryCommands = new java.util.ArrayList< String>();
                }
                java.lang.Object j =obj;
                String j1= j.toString();
                this.AuxiliaryCommands.add(j1);
            }
            return true;
        }
        if (info.name.equals("Extension"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Extension = (IOCapabilitiesExtension2)__envelope.get(j,IOCapabilitiesExtension2.class,false);
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
            return this.Auxiliary!=null?this.Auxiliary:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex>=1 && propertyIndex < 1+this.AuxiliaryCommands.size())
        {
            String AuxiliaryCommands = this.AuxiliaryCommands.get(propertyIndex-(1));
            return AuxiliaryCommands!=null?AuxiliaryCommands:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==1+this.AuxiliaryCommands.size())
        {
            return this.Extension;
        }
        else if(propertyIndex>=2+this.AuxiliaryCommands.size() && propertyIndex < 2+this.AuxiliaryCommands.size()+this.any.size())
        {
            return this.any.get(propertyIndex-(2+this.AuxiliaryCommands.size())).getValue();
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 2+AuxiliaryCommands.size()+ any.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
            if(propertyIndex==0)
            {
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "Auxiliary";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex>=1 && propertyIndex < 1+this.AuxiliaryCommands.size())
            {
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "AuxiliaryCommands";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==1+this.AuxiliaryCommands.size())
            {
                info.type = IOCapabilitiesExtension2.class;
                info.name = "Extension";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex>=2+this.AuxiliaryCommands.size() && propertyIndex < 2+this.AuxiliaryCommands.size()+this.any.size())
            {
                PropertyInfo j=this.any.get(propertyIndex-(2+this.AuxiliaryCommands.size()));
                info.type = j.type;
                info.name = j.name;
                info.namespace= j.namespace;
            }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
