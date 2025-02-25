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

public  class GeoLocation extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    public Double lon=0d;
    
    public Double lat=0d;
    
    public Float elevation=0f;
    
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

		if (inObj.hasAttribute("lon"))
        {	
            java.lang.Object j = inObj.getAttribute("lon");
            if (j != null)
            {
                lon = Double.valueOf(j.toString());
            }
        }
		if (inObj.hasAttribute("lat"))
        {	
            java.lang.Object j = inObj.getAttribute("lat");
            if (j != null)
            {
                lat = Double.valueOf(j.toString());
            }
        }
		if (inObj.hasAttribute("elevation"))
        {	
            java.lang.Object j = inObj.getAttribute("elevation");
            if (j != null)
            {
                elevation = Float.valueOf(j.toString());
            }
        }

    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
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
        if(propertyIndex>=0 && propertyIndex < 0+this.any.size())
        {
            return this.any.get(propertyIndex-(0)).getValue();
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 0+ any.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
            if(propertyIndex>=0 && propertyIndex < 0+this.any.size())
            {
                PropertyInfo j=this.any.get(propertyIndex-(0));
                info.type = j.type;
                info.name = j.name;
                info.namespace= j.namespace;
            }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }



        public int getAttributeCount() {
        return 3;
    }
    
    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
if(index==0)
        {
            info.name = "lon";
            info.namespace= "";
            if(this.lon!=null)
            {
                info.setValue(this.lon);
            }
        
        }
        if(index==1)
        {
            info.name = "lat";
            info.namespace= "";
            if(this.lat!=null)
            {
                info.setValue(this.lat);
            }
        
        }
        if(index==2)
        {
            info.name = "elevation";
            info.namespace= "";
            if(this.elevation!=null)
            {
                info.setValue(this.elevation);
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
