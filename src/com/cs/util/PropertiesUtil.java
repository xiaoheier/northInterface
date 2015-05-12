package com.cs.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static PropertiesUtil instance;
	private Properties props;
	private PropertiesUtil(){	
		props = new Properties();
        try {
         InputStream in = new BufferedInputStream (new FileInputStream("src/socket.properties"));
         props.load(in);
           // Enumeration en = props.propertyNames();
            /* while (en.hasMoreElements()) {
              String key = (String) en.nextElement();
                    String Property = props.getProperty (key);
                    System.out.println(key+Property);
                }*/
        } catch (Exception e) {
         e.printStackTrace();
        }
	}
	public static PropertiesUtil getInstance(){
		if(null==instance){
			instance=new PropertiesUtil();
		}
		return instance;
	}
	public String getAttribute(String key){
	   return props.getProperty(key);	
	}
}
