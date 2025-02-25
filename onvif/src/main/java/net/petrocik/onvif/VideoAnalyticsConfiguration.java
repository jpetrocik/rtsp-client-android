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

public  class VideoAnalyticsConfiguration extends ConfigurationEntity implements KvmSerializable
{

    
    public AnalyticsEngineConfiguration AnalyticsEngineConfiguration;
    
    public RuleEngineConfiguration RuleEngineConfiguration;

    

    @Override
    public void loadFromSoap(java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
        if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;
        super.loadFromSoap(paramObj, __envelope);


    }

    @Override
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("AnalyticsEngineConfiguration"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.AnalyticsEngineConfiguration = (AnalyticsEngineConfiguration)__envelope.get(j,AnalyticsEngineConfiguration.class,false);
            }
            return true;
        }
        if (info.name.equals("RuleEngineConfiguration"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.RuleEngineConfiguration = (RuleEngineConfiguration)__envelope.get(j,RuleEngineConfiguration.class,false);
            }
            return true;
        }
        return super.loadProperty(info,soapObject,__envelope);
    }    
    
    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        int count = super.getPropertyCount();
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==count+0)
        {
            return this.AnalyticsEngineConfiguration;
        }
        else if(propertyIndex==count+1)
        {
            return this.RuleEngineConfiguration;
        }
        return super.getProperty(propertyIndex);
    }


    @Override
    public int getPropertyCount() {
        return super.getPropertyCount()+2;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
            int count = super.getPropertyCount();
            if(propertyIndex==count+0)
            {
                info.type = AnalyticsEngineConfiguration.class;
                info.name = "AnalyticsEngineConfiguration";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            else if(propertyIndex==count+1)
            {
                info.type = RuleEngineConfiguration.class;
                info.name = "RuleEngineConfiguration";
                info.namespace= "http://www.onvif.org/ver10/schema";
            }
            super.getPropertyInfo(propertyIndex,arg1,info);
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
