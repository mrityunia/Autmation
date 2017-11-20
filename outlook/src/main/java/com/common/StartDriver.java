package com.common;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utility.Report;
import com.utility.SConfiguration;

public class StartDriver {

	
	protected static Properties config;	
	protected static  Report r;
	
	protected String URL=null;
	protected WebDriver webDriver;
	protected WebElement webelement;
	private DriverFactory factory;
	
	
	public String getURL(){
		return URL;
	}
	
	public static void initilize(){
		r=new Report();
		r.createReport(SConfiguration.reportLocation);
		try {
			config = new Properties();
	
			config.load(new FileInputStream(System.getProperty("user.dir").concat("/config/local.properties")));
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	@Parameters({"browsername","url"})
	

//ProjectPropertiesUtils.getPropertyValue("remote.user");
	
	public WebDriver intilizeDriver(String browsername,String url){
		SConfiguration.intilize();
		
		factory= new DriverFactory();
		
		webDriver= factory.getDriver(browsername);
		this.URL = url;
		initilize();
	return webDriver;
	}
	
	@AfterClass
public void quiteDriver(){
		webDriver.close();
		
	}

}
