package com.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.Constraints;

public class Base {
protected WebDriver webDriver;
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public WebElement getWebelement() {
	return webelement;
}
public void setWebelement(WebElement webelement) {
	this.webelement = webelement;
}
public WebDriver getWebDriver() {
	return webDriver;
}
public void setWebDriver(WebDriver webDriver) {
	this.webDriver = webDriver;
}
protected String url;
protected WebElement webelement;

protected Properties Opnepage;
protected Properties config;

	
public Base(WebDriver webDriver,String url){
	setWebDriver(webDriver);
	setUrl(url);
	initilize();
	
}
public void initilize(){
	Opnepage = new Properties();
	config = new Properties();
	try {
		
		Opnepage.load(new FileInputStream(System.getProperty("user.dir").concat("/src/test/java/Prop/Opnepage.properties")));
		
		config.load(new FileInputStream(System.getProperty("user.dir").concat("/config/local.properties")));
		
		
	} catch (FileNotFoundException e) {
		System.out.println("Error occured in initilize method");
		System.out.println(e.getMessage());
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Error occured in initilize method");
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	
}

	
///////****************Common methods all are written here**************////////////////////////


public void Click(){
	}

public void waitForElementDisply(String xpath){
	
	for(int j=0;j<=30;j++){
	if(isPresent(1,By.xpath(xpath))){
    break;		
	}
	else {
		
		System.out.println("Element is not present");
	}

	}
}

public boolean isPresent(int time,By by){
	
	try{
		WebDriverWait wait = new WebDriverWait(webDriver,time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		webDriver.findElement(by).isDisplayed();
		return true;
		
	}
	catch(Exception e){
		
		return false;	
	}
	
	
}

public void clickObject(String Xpath){
	waitForElementDisply(Xpath);
	webelement =getObejct(Xpath);
	webelement.click();
	
}
public WebElement getObejct(String Xpath){
	try{
		//waitForElementDisply(Xpath);
		webelement =webDriver.findElement(By.xpath(Xpath));
		return webelement;
	}
	catch(Exception E){
		System.out.println("Some error occured inget Obejct ");
		return null;
	}
	
}

public void insertString(String Xpath,String data){
	waitForElementDisply(Xpath);
	webelement= getObejct(Xpath);
	try{
		if(webelement.isDisplayed()&&webelement.isEnabled()){
			
			if(data.isEmpty()){
				
				System.out.println("Data is empty");
			}
			else {
				webelement.clear();
				webelement.sendKeys(data);
				Thread.sleep(2000);
			}
			
		}
		else{
			System.out.println("Text boX is not enebled or displayed");
		}
	}
	catch(Exception e){
		
	}
}

public String saveSreentShots(String TestcaseName,File SaveFile) throws IOException{
	String storageLocation = config.getProperty("ScreenShotsStorageLocation");
	String scName ="\\"+TestcaseName.concat(".png");
	String location =storageLocation.concat(scName);
	  File destination =new  File(location);
	  FileUtils.copyFile(SaveFile, destination);
	  return location;
	  
	  
}
public  File takeScreentShots(){
	
	TakesScreenshot src = ((TakesScreenshot)webDriver);
	File srcFile = src.getScreenshotAs(OutputType.FILE);
	return  srcFile;
	
} 

public void addsc(String Xpath){
	webelement=getObejct(Xpath);
	Constraints.point = webelement.getLocation();
	Constraints.witdth =webelement.getSize().getWidth();
	Constraints.hight = webelement.getSize().getHeight();
	

}

} 
