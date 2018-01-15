package com.utility;


import java.io.File;
import java.io.IOException;
import java.util.Properties;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report {
	ExtentReports report;
	ExtentTest Test;

	public void createReport(String location){
		 report= new ExtentReports(location,true);
		 
		
				
	}
	public ExtentReports getReport(){
    return report;
	}
	public  ExtentTest getTest(){
	    return Test ;
		}
	public void startTest(ExtentReports report,String testCaseName ){
		
		Test=report.startTest(testCaseName);
		
		
		
	}
	public void endTest(ExtentReports report,ExtentTest Test){
		report.endTest(Test);
		
	}
	
	
	public void logs(ExtentTest Test,String status,String message,String scLocation){
		
		if(status.equalsIgnoreCase("PASS")){
			Test.log(LogStatus.PASS,message+Test.addScreenCapture(scLocation));
			
			
		}
		else if(status.equalsIgnoreCase("FAIL")){
			
			Test.log(LogStatus.FAIL, message+Test.addScreenCapture(scLocation));
			
		}
		else if (status.equalsIgnoreCase("INFO")){
			
			Test.log(LogStatus.INFO, message);
		}
		
	}

	public void logs(ExtentTest Test,String status,String message){
		
		if(status.equalsIgnoreCase("PASS")){
			Test.log(LogStatus.PASS,message);
			
		}
		else if(status.equalsIgnoreCase("FAIL")){
			
			Test.log(LogStatus.FAIL, message);
			
		}
		else if (status.equalsIgnoreCase("INFO")){
			
			Test.log(LogStatus.INFO, message);
		}
		
	}
	
	public void flash(ExtentReports report){
		report.flush();
		
	}
	public String saveSreentShots(String TestcaseName,File SaveFile) throws IOException{
		
		String storageLocation = SConfiguration.ScreenShots;
		
		//String storageLocation = config.getProperty("ScreenShotsStorageLocation");
		String scName ="\\"+TestcaseName.concat(".png");
		String location =storageLocation.concat(scName);
	//	config.setProperty("ScreenShotsLocation", location);
		  File destination =new  File(location);
		  FileUtils.copyFile(SaveFile, destination);
		  return location;
		  
		  
	}
	public  File takeScreentShots(WebDriver webDriver){
		File srcFile;
	
		
		try {
			TakesScreenshot src = ((TakesScreenshot)webDriver);
			 srcFile = src.getScreenshotAs(OutputType.FILE);
			 
			 
			 ////You can uncomment the to take a specified size location
			 
			/*BufferedImage  fullImg = ImageIO.read(srcFile);
			
			
			
			BufferedImage eleScreenshot= fullImg.getSubimage(Constraints.point.getX(), Constraints.point.getY(),
					Constraints.witdth,Constraints.hight);
				ImageIO.write(eleScreenshot, "png", srcFile);*/
				
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			srcFile=null;
		}
		
		
		return  srcFile;
		
	}
	
	
}
