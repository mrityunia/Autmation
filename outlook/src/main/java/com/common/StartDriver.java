package com.common;




import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utility.Report;
import com.utility.SConfiguration;

public class StartDriver {

	
	protected static Properties config;	
	public static  Report r;
	protected static Logger log; 
	
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
public void quiteDriver() throws IOException{
		
		r.flash(r.getReport());
		String ReLocation=SConfiguration.reportLocation;
		File htmlFile = new File(ReLocation);		
		Desktop.getDesktop().browse(htmlFile.toURI());	
		
		String StLocation=SConfiguration.logerLocation;
		File htmlFile2 = new File(StLocation);		
		Desktop.getDesktop().browse(htmlFile2.toURI());
		
		
		
		webDriver.close();
	}

}
