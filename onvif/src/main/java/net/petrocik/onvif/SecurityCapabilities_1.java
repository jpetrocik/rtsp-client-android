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

public  class SecurityCapabilities_1 extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    public Boolean TLS1_x002E_0=false;
    
    public Boolean TLS1_x002E_1=false;
    
    public Boolean TLS1_x002E_2=false;
    
    public Boolean OnboardKeyGeneration=false;
    
    public Boolean AccessPolicyConfig=false;
    
    public Boolean DefaultAccessPolicy=false;
    
    public Boolean Dot1X=false;
    
    public Boolean RemoteUserHandling=false;
    
    public Boolean X_x002E_509Token=false;
    
    public Boolean SAMLToken=false;
    
    public Boolean KerberosToken=false;
    
    public Boolean UsernameToken=false;
    
    public Boolean HttpDigest=false;
    
    public Boolean RELToken=false;
    
    public String SupportedEAPMethods;
    
    public Integer MaxUsers=0;

    

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

		if (inObj.hasAttribute("TLS1.0"))
        {	
            java.lang.Object j = inObj.getAttribute("TLS1.0");
            if (j != null)
            {
                TLS1_x002E_0 = Boolean.valueOf(j.toString());
            }
        }
		if (inObj.hasAttribute("TLS1.1"))
        {	
            java.lang.Object j = inObj.getAttribute("TLS1.1");
            if (j != null)
            {
                TLS1_x002E_1 = Boolean.valueOf(j.toString());
            }
        }
		if (inObj.hasAttribute("TLS1.2"))
        {	
            java.lang.Object j = inObj.getAttribute("TLS1.2");
            if (j != null)
            {
                TLS1_x002E_2 = Boolean.valueOf(j.toString());
            }
        }
		if (inObj.hasAttribute("OnboardKeyGeneration"))
        {	
            java.lang.Object j = inObj.getAttribute("OnboardKeyGeneration");
            if (j != null)
            {
                OnboardKeyGeneration = Boolean.valueOf(j.toString());
            }
        }
		if (inObj.hasAttribute("AccessPolicyConfig"))
        {	
            java.lang.Object j = inObj.getAttribute("AccessPolicyConfig");
            if (j != null)
            {
                AccessPolicyConfig = Boolean.valueOf(j.toString());
            }
        }
		if (inObj.hasAttribute("DefaultAccessPolicy"))
        {	
            java.lang.Object j = inObj.getAttribute("DefaultAccessPolicy");
            if (j != null)
            {
                DefaultAccessPolicy = Boolean.valueOf(j.toString());
            }
        }
		if (inObj.hasAttribute("Dot1X"))
        {	
            java.lang.Object j = inObj.getAttribute("Dot1X");
            if (j != null)
            {
                Dot1X = Boolean.valueOf(j.toString());
            }
        }
		if (inObj.hasAttribute("RemoteUserHandling"))
        {	
            java.lang.Object j = inObj.getAttribute("RemoteUserHandling");
            if (j != null)
            {
                RemoteUserHandling = Boolean.valueOf(j.toString());
            }
        }
		if (inObj.hasAttribute("X.509Token"))
        {	
            java.lang.Object j = inObj.getAttribute("X.509Token");
            if (j != null)
            {
                X_x002E_509Token = Boolean.valueOf(j.toString());
            }
        }
		if (inObj.hasAttribute("SAMLToken"))
        {	
            java.lang.Object j = inObj.getAttribute("SAMLToken");
            if (j != null)
            {
                SAMLToken = Boolean.valueOf(j.toString());
            }
        }
		if (inObj.hasAttribute("KerberosToken"))
        {	
            java.lang.Object j = inObj.getAttribute("KerberosToken");
            if (j != null)
            {
                KerberosToken = Boolean.valueOf(j.toString());
            }
        }
		if (inObj.hasAttribute("UsernameToken"))
        {	
            java.lang.Object j = inObj.getAttribute("UsernameToken");
            if (j != null)
            {
                UsernameToken = Boolean.valueOf(j.toString());
            }
        }
		if (inObj.hasAttribute("HttpDigest"))
        {	
            java.lang.Object j = inObj.getAttribute("HttpDigest");
            if (j != null)
            {
                HttpDigest = Boolean.valueOf(j.toString());
            }
        }
		if (inObj.hasAttribute("RELToken"))
        {	
            java.lang.Object j = inObj.getAttribute("RELToken");
            if (j != null)
            {
                RELToken = Boolean.valueOf(j.toString());
            }
        }
		if (inObj.hasAttribute("SupportedEAPMethods"))
        {	
            java.lang.Object j = inObj.getAttribute("SupportedEAPMethods");
            if (j != null)
            {
                SupportedEAPMethods = j.toString();
            }
        }
		if (inObj.hasAttribute("MaxUsers"))
        {	
            java.lang.Object j = inObj.getAttribute("MaxUsers");
            if (j != null)
            {
                MaxUsers = Integer.parseInt(j.toString());
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
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 0;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }



        public int getAttributeCount() {
        return 16;
    }
    
    @Override
    public void getAttributeInfo(int index, AttributeInfo info) {
if(index==0)
        {
            info.name = "TLS1.0";
            info.namespace= "";
            if(this.TLS1_x002E_0!=null)
            {
                info.setValue(this.TLS1_x002E_0);
            }
        
        }
        if(index==1)
        {
            info.name = "TLS1.1";
            info.namespace= "";
            if(this.TLS1_x002E_1!=null)
            {
                info.setValue(this.TLS1_x002E_1);
            }
        
        }
        if(index==2)
        {
            info.name = "TLS1.2";
            info.namespace= "";
            if(this.TLS1_x002E_2!=null)
            {
                info.setValue(this.TLS1_x002E_2);
            }
        
        }
        if(index==3)
        {
            info.name = "OnboardKeyGeneration";
            info.namespace= "";
            if(this.OnboardKeyGeneration!=null)
            {
                info.setValue(this.OnboardKeyGeneration);
            }
        
        }
        if(index==4)
        {
            info.name = "AccessPolicyConfig";
            info.namespace= "";
            if(this.AccessPolicyConfig!=null)
            {
                info.setValue(this.AccessPolicyConfig);
            }
        
        }
        if(index==5)
        {
            info.name = "DefaultAccessPolicy";
            info.namespace= "";
            if(this.DefaultAccessPolicy!=null)
            {
                info.setValue(this.DefaultAccessPolicy);
            }
        
        }
        if(index==6)
        {
            info.name = "Dot1X";
            info.namespace= "";
            if(this.Dot1X!=null)
            {
                info.setValue(this.Dot1X);
            }
        
        }
        if(index==7)
        {
            info.name = "RemoteUserHandling";
            info.namespace= "";
            if(this.RemoteUserHandling!=null)
            {
                info.setValue(this.RemoteUserHandling);
            }
        
        }
        if(index==8)
        {
            info.name = "X.509Token";
            info.namespace= "";
            if(this.X_x002E_509Token!=null)
            {
                info.setValue(this.X_x002E_509Token);
            }
        
        }
        if(index==9)
        {
            info.name = "SAMLToken";
            info.namespace= "";
            if(this.SAMLToken!=null)
            {
                info.setValue(this.SAMLToken);
            }
        
        }
        if(index==10)
        {
            info.name = "KerberosToken";
            info.namespace= "";
            if(this.KerberosToken!=null)
            {
                info.setValue(this.KerberosToken);
            }
        
        }
        if(index==11)
        {
            info.name = "UsernameToken";
            info.namespace= "";
            if(this.UsernameToken!=null)
            {
                info.setValue(this.UsernameToken);
            }
        
        }
        if(index==12)
        {
            info.name = "HttpDigest";
            info.namespace= "";
            if(this.HttpDigest!=null)
            {
                info.setValue(this.HttpDigest);
            }
        
        }
        if(index==13)
        {
            info.name = "RELToken";
            info.namespace= "";
            if(this.RELToken!=null)
            {
                info.setValue(this.RELToken);
            }
        
        }
        if(index==14)
        {
            info.name = "SupportedEAPMethods";
            info.namespace= "";
            if(this.SupportedEAPMethods!=null)
            {
                info.setValue(this.SupportedEAPMethods);
            }
        
        }
        if(index==15)
        {
            info.name = "MaxUsers";
            info.namespace= "";
            if(this.MaxUsers!=null)
            {
                info.setValue(this.MaxUsers);
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
