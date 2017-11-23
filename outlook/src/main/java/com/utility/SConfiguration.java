package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SConfiguration {

	

private static Properties prop;

public static String IE_browser=null;
public static String FF_browser=null;
public static String Chrome_browser=null;
public static String reportLocation=null;

public static Logger log= Logger.getLogger(SConfiguration.class);



public  static void intilize(){
	prop = new Properties();
	
	try {
		
		prop.load(new FileInputStream(System.getProperty("user.dir").concat("/config/configuration.properties")));
		
		Chrome_browser=prop.getProperty("chrome_driver");
		
		IE_browser=prop.getProperty("iE_Driver");
		FF_browser=prop.getProperty("fireFox");
		
		reportLocation=prop.getProperty("report_location");
		
	File f = new File(prop.getProperty("log4j.appender.HTML.File"));
		
		if(f.delete())
		{
			System.out.println("File is deleted");
		}	
		else{
			System.out.println("Delete operation is failed.");			
		}
		
		 PropertyConfigurator.configure(System.getProperty("user.dir").concat("/config/configuration.properties"));
		   log.info("Sample info message");
	
	
	
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	
}

	
	
}
