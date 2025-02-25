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

public  class SetDNS extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    public Boolean FromDHCP=false;
    
    public java.util.ArrayList< String> SearchDomain =new java.util.ArrayList<String >();
    
    public java.util.ArrayList< IPAddress> DNSManual =new java.util.ArrayList<IPAddress >();

    

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
        if (info.name.equals("FromDHCP"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.FromDHCP = Boolean.valueOf(j.toString());
                    }
                }
                else if (obj instanceof Boolean){
                    this.FromDHCP = (Boolean)obj;
                }
            }
            return true;
        }
        if (info.name.equals("SearchDomain"))
        {
            if(obj!=null)
            {
                if(this.SearchDomain==null)
                {
                    this.SearchDomain = new java.util.ArrayList< String>();
                }
                java.lang.Object j =obj;
                String j1= j.toString();
                this.SearchDomain.add(j1);
            }
            return true;
        }
        if (info.name.equals("DNSManual"))
        {
            if(obj!=null)
            {
                if(this.DNSManual==null)
                {
                    this.DNSManual = new java.util.ArrayList< IPAddress>();
                }
                java.lang.Object j =obj;
                IPAddress j1= (IPAddress)__envelope.get(j,IPAddress.class,false);
                this.DNSManual.add(j1);
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
            return this.FromDHCP;
        }
        else if(propertyIndex>=1 && propertyIndex < 1+this.SearchDomain.size())
        {
            String SearchDomain = this.SearchDomain.get(propertyIndex-(1));
            return SearchDomain!=null?SearchDomain:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex>=1+this.SearchDomain.size() && propertyIndex < 1+this.SearchDomain.size()+this.DNSManual.size())
        {
            IPAddress DNSManual = this.DNSManual.get(propertyIndex-(1+this.SearchDomain.size()));
            return DNSManual!=null?DNSManual:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 1+SearchDomain.size()+DNSManual.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
            if(propertyIndex==0)
            {
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "FromDHCP";
                info.namespace= "http://www.onvif.org/ver10/device/wsdl";
            }
            else if(propertyIndex>=1 && propertyIndex < 1+this.SearchDomain.size())
            {
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "SearchDomain";
                info.namespace= "http://www.onvif.org/ver10/device/wsdl";
            }
            else if(propertyIndex>=1+this.SearchDomain.size() && propertyIndex < 1+this.SearchDomain.size()+this.DNSManual.size())
            {
                info.type = IPAddress.class;
                info.name = "DNSManual";
                info.namespace= "http://www.onvif.org/ver10/device/wsdl";
            }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
