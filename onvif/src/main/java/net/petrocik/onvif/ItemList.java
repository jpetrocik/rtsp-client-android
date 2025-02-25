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

public  class ItemList extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    public java.util.ArrayList< ItemList_SimpleItem> SimpleItem =new java.util.ArrayList<ItemList_SimpleItem >();
    
    public java.util.ArrayList< ItemList_ElementItem> ElementItem =new java.util.ArrayList<ItemList_ElementItem >();
    
    public ItemListExtension Extension;

    

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
        if (info.name.equals("SimpleItem"))
        {
            if(obj!=null)
            {
                if(this.SimpleItem==null)
                {
                    this.SimpleItem = new java.util.ArrayList< ItemList_SimpleItem>();
                }
                java.lang.Object j =obj;
                ItemList_SimpleItem j1= (ItemList_SimpleItem)__envelope.get(j,ItemList_SimpleItem.class,false);
                this.SimpleItem.add(j1);
            }
            return true;
        }
        if (info.name.equals("ElementItem"))
        {
            if(obj!=null)
            {
                if(this.ElementItem==null)
                {
                    this.ElementItem = new java.util.ArrayList< ItemList_ElementItem>();
                }
                java.lang.Object j =obj;
                ItemList_ElementItem j1= (ItemList_ElementItem)__envelope.get(j,ItemList_ElementItem.class,false);
                this.ElementItem.add(j1);
            }
            return true;
        }
        if (info.name.equals("Extension"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Extension = (ItemListExtension)__envelope.get(j,ItemListExtension.class,false);
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
        if(propertyIndex>=0 && propertyIndex < 0+this.SimpleItem.size())
        {
            ItemList_SimpleItem SimpleItem = this.SimpleItem.get(propertyIndex-(0));
            return SimpleItem!=null?SimpleItem:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex>=0+this.SimpleItem.size() && propertyIndex < 0+this.SimpleItem.size()+this.ElementItem.size())
        {
            ItemList_ElementItem ElementItem = this.ElementItem.get(propertyIndex-(0+this.SimpleItem.size()));
            return ElementItem!=null?ElementItem:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==0+this.SimpleItem.size()+this.ElementItem.size())
        {
            return this.Extension!=null?this.Extension:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 1+SimpleItem.size()+ElementItem.size();
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
            if(propertyIndex>=0 && propertyIndex < 0+this.SimpleItem.size())
            {
                info.type = ItemList_SimpleItem.class;
                info.name = "SimpleItem";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex>=0+this.SimpleItem.size() && propertyIndex < 0+this.SimpleItem.size()+this.ElementItem.size())
            {
                info.type = ItemList_ElementItem.class;
                info.name = "ElementItem";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==0+this.SimpleItem.size()+this.ElementItem.size())
            {
                info.type = ItemListExtension.class;
                info.name = "Extension";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
