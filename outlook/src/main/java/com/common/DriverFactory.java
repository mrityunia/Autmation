package com.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.utility.SConfiguration;



public class DriverFactory  {
	private WebDriver webDriver;
	private String BrowserDetails=null;
	
	public WebDriver getDriver(String browserName){
		try{
		if(browserName.equalsIgnoreCase(Constraints.IE_Browser)){
			
			
			//System.setProperty("webdriver.ie.driver","F:\\selenium\\IEDriverServer_x64_2.52.0\\IEDriverServer.exe");
			
			System.setProperty("webdriver.ie.driver",SConfiguration.IE_browser);
			
			
			webDriver= new InternetExplorerDriver();
			BrowserDetails=Constraints.IE_Browser;
			}
		else if(browserName.equalsIgnoreCase(Constraints.CHROME_Browser)){
			
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\Mrityunjoy\\Downloads\\chromedriver_win32\\chromedriver.exe");
			
			System.setProperty("webdriver.chrome.driver",SConfiguration.Chrome_browser);
			
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
			options.addArguments("--start-maximized");
			options.addArguments("--disable-extensions");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);

		  webDriver= new ChromeDriver(capabilities);
		  
		  BrowserDetails=Constraints.CHROME_Browser;
		  
		}else if(browserName.equalsIgnoreCase(Constraints.FF_Browser)){
System.setProperty("webdriver.gecko.driver",SConfiguration.FF_browser);
			
			webDriver= new FirefoxDriver();
			BrowserDetails= Constraints.FF_Browser;
			
		}
		else{
			System.setProperty("webdriver.gecko.driver",SConfiguration.FF_browser);
			
			webDriver= new FirefoxDriver();
			BrowserDetails= Constraints.FF_Browser;
			
		}
		}
		catch(Exception a){
			System.out.println("Some Exception occured at DriverFActoryClass"+a.getMessage());
		}
		return webDriver;
	}
	
	public String getBrowser(){
		return BrowserDetails;
	}
	
	
	

}
