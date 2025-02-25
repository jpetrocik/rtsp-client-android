package net.petrocik.onvif;
//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 6.0.1.1
//
// Created by Quasar Development 
//
//----------------------------------------------------


import org.ksoap2.serialization.*;

public  class BaseFaultType_Description  
{

    
    private transient java.lang.Object __source;    
    
    public String value;
    
    public String lang;

    

    public void loadFromSoap(java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
        if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;
        __source=inObj; 
        if(!(inObj instanceof SoapObject))
        {
            java.lang.Object j =(java.lang.Object)inObj;
            value = j.toString();
        }

		if (inObj.hasAttribute("lang"))
        {	
            java.lang.Object j = inObj.getAttribute("lang");
            if (j != null)
            {
                lang = j.toString();
            }
        }

    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("value"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.value = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.value = (String)obj;
                }
                else{
                    this.value = "";
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
        public Object getSimpleValue()
    {
        Object value=this.value != null ? this.value.toString() : "";
        SoapPrimitive primitive = new SoapPrimitive("http://docs.oasis-open.org/wsrf/bf-2", "value",value);
        
        if (this.lang != null)
        {
            AttributeInfo attrInfo = new AttributeInfo();
            attrInfo.setName("lang");
            attrInfo.setValue(this.lang);
            attrInfo.setNamespace("http://www.w3.org/XML/1998/namespace");
            primitive.addAttribute(attrInfo);
        }
        return primitive;
    }    
}
