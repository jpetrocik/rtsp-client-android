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

public  class IPv4Configuration extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    public java.util.ArrayList< PrefixedIPv4Address> Manual =new java.util.ArrayList<PrefixedIPv4Address >();
    
    public PrefixedIPv4Address LinkLocal;
    
    public PrefixedIPv4Address FromDHCP;
    
    public Boolean DHCP=false;
    
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
        if (info.name.equals("Manual"))
        {
            if(obj!=null)
            {
                if(this.Manual==null)
                {
                    this.Manual = new java.util.ArrayList< PrefixedIPv4Address>();
                }
                java.lang.Object j =obj;
                PrefixedIPv4Address j1= (PrefixedIPv4Address)__envelope.get(j,PrefixedIPv4Address.class,false);
                this.Manual.add(j1);
            }
            return true;
        }
        if (info.name.equals("LinkLocal"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.LinkLocal = (PrefixedIPv4Address)__envelope.get(j,PrefixedIPv4Address.class,false);
            }
            return true;
        }
        if (info.name.equals("FromDHCP"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.FromDHCP = (PrefixedIPv4Address)__envelope.get(j,PrefixedIPv4Address.class,false);
            }
            return true;
        }
        if (info.name.equals("DHCP"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.DHCP = Boolean.valueOf(j.toString());
                    }
                }
                else if (obj instanceof Boolean){
                    this.DHCP = (Boolean)obj;
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
        if(propertyIndex>=0 && propertyIndex < 0+this.Manual.size())
        {
            PrefixedIPv4Address Manual = this.Manual.get(propertyIndex-(0));
            return Manual!=null?Manual:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==0+this.Manual.size())
        {
            return this.LinkLocal!=null?this.LinkLocal:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==1+this.Manual.size())
        {
            return this.FromDHCP!=null?this.FromDHCP:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==2+this.Manual.size())
        {
            return this.DHCP;
        }
        else if(propertyIndex>=3+this.Manual.size() && propertyIndex < 3+this.Manual.size()+this.any.size())
        {
            return this.any.get(propertyIndex-(3+this.Manual.size())).getValue();
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 3+Manual.size()+ any.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
            if(propertyIndex>=0 && propertyIndex < 0+this.Manual.size())
            {
                info.type = PrefixedIPv4Address.class;
                info.name = "Manual";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==0+this.Manual.size())
            {
                info.type = PrefixedIPv4Address.class;
                info.name = "LinkLocal";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==1+this.Manual.size())
            {
                info.type = PrefixedIPv4Address.class;
                info.name = "FromDHCP";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==2+this.Manual.size())
            {
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "DHCP";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex>=3+this.Manual.size() && propertyIndex < 3+this.Manual.size()+this.any.size())
            {
                PropertyInfo j=this.any.get(propertyIndex-(3+this.Manual.size()));
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
