package sProperty;

import java.io.FileInputStream;
import java.util.Properties;

public class SConfiguration {

	

private static Properties prop;

public static String IE_browser=null;
public static String FF_browser=null;
public static String Chrome_browser=null;
public static String reportLocation=null;


public  static void intilize(){
	prop = new Properties();
	
	try {
		prop.load(new FileInputStream(System.getProperty("user.dir").concat("/config/configuration.properties")));
		
		Chrome_browser=prop.getProperty("chrome_driver");
		
		IE_browser=prop.getProperty("iE_Driver");
		FF_browser=prop.getProperty("fireFox");
		
		reportLocation=prop.getProperty("report_location");
				
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}

	
	
}
