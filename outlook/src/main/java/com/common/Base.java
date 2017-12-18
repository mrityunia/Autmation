package com.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.Constraints;
import com.utility.Steps;
import com.utility.StepsDetails;
import com.utility.TestCases;
import com.utility.TestSuits;


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
public void allWebelemtsInPage(){
	List<WebElement> allelements = webDriver.findElements(By.xpath("//*"));
	
System.out.println(allelements.get(0).getText());

webDriver.findElement(By.linkText(allelements.get(0).getText())).click();;
	
	
	
	int size = allelements.size();
	
	for (int a= 0;a<=size;a++){
		
		System.out.println(allelements.get(a).getText());
	}}
	
	public void allWebelemtsLinks(){
		List<WebElement> allelements = webDriver.findElements(By.tagName("a"));
		int size = allelements.size();
		
		for (int a= 0;a<=size;a++){
			System.out.println(allelements.get(a).getText());
		}
		
	}
public void overMouse(String Xpath){
	Actions action = new Actions(webDriver);
	webelement=getObejct(Xpath);
	action.moveToElement(webelement).build().perform();
	
}

//Getting all references present in that page
public List<WebElement> getAllref(){
	
	//List<WebElement> list=webDriver.findElements(By.xpath("//*[@href or @src]"));
	  
	List<WebElement> list = webDriver.findElements(By.tagName("a"));
	
	System.out.println("no. of links on google page are :" +list.size());
	
	return list;
	
	}
// getting all source code in that corresponding page 
public void getsourcCode(String Text){
	
	String sourcs=webDriver.getPageSource();
	
	if(sourcs.contains(Text))
	{
	   webDriver.findElement(By.linkText(Text)).click();;
	}

	else
	{
	   System.out.println("Link is not presatn");
	}
}

//loading the test cases excel sheet
public Sheet getExcel(String Filpath,int a){
	
	try {
		InputStream file = new FileInputStream(Filpath);
		XSSFWorkbook  book= new XSSFWorkbook(file);
		Sheet sh=book.getSheet("Sheet2");	
              	
		
		return sh;
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		return null;
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		return null;
	
	}	
}

///reading the excel file and crating a Test Suites.that test Suits will be passed to evaluate 
public TestSuits readfromExcel( String filePath){
	TestSuits suit=null;
	try {
		suit= new TestSuits();
		suit.setTestSuits("Suit 1");
		 List<TestCases> testCases= new ArrayList<TestCases>();
		 Sheet sh=getExcel(filePath,2);
		 int lastRow=sh.getLastRowNum();
		int TestCoseCount=0;
		System.out.println("Total Test cases are "+TestCoseCount+"last row is "+lastRow);
		int iCount=0;
		//Traversing sheet and reading each row
		while(iCount<=lastRow){
			TestCases test= new TestCases();
			Row r = sh.getRow(iCount);
			// IF 1-checking is row is empty 
			if(r==null){
				iCount++;
			}
			//END IF 1
			else{
				//IF 2: Check is cell is empty or not s
				Cell c=r.getCell(0);
				if(c==null){
					iCount++;
				}
				//END of IF 2
				else{
					//IF 3-Checking row has a TC to not
					if(c.getStringCellValue().trim().startsWith("TC")){
						String testCaseName=c.getStringCellValue().trim();
						String testDesc=r.getCell(1).getStringCellValue().trim();
						String Status=r.getCell(2).getStringCellValue().trim();
						test.setTestCase(testCaseName);
						test.setTestDescription(testDesc);
						test.setRunStatus(Status);
						TestCoseCount++;
						int stepsCount=0;
						int jCount=iCount;
						 List<Steps> Steps= new ArrayList<Steps>();
						//Reading each row for Step and initialize the Steps
						 while(jCount<=lastRow){	
							 Steps steps= new Steps();
							 String StepID= null;
							 StepsDetails  StepDetail= new StepsDetails();
							 Row sRow=sh.getRow(jCount);
							 if(sRow.getCell(4).getStringCellValue().trim().contains("End Step")){
								 break;
							 }
							 else {
								 StepID=sRow.getCell(3).getStringCellValue().trim();
								 steps.setStepId(StepID);
								 StepDetail.setStepDesc(sRow.getCell(4).getStringCellValue().trim());
								 StepDetail.setKeyword(sRow.getCell(5).getStringCellValue().trim());
								 StepDetail.setExpectedResult(sRow.getCell(6).getStringCellValue().trim());
								 List<String> parameters= new ArrayList<String>();
								 int i=7;
								 while(i<=sRow.getLastCellNum()){
									 String param=null;
									 if(sRow.getCell(i).getStringCellValue().trim().contentEquals("##")){
										 break;
										 
									 }
									 else{
										 param=sRow.getCell(i).getStringCellValue().trim();
										 i++;
									 }
									 parameters.add(param);
									 StepDetail.setParameters(parameters);
									 
								 }
								  steps.setSteps(StepDetail);
								 stepsCount++;
								 jCount++; 
							 }       
							 Steps.add(steps);
						 }
						 
					test.setTestSteps(Steps);
					testCases.add(test);
					
				}
					//
					iCount++;
			}
		}

		}
		suit.setTestcases(testCases);
	} 
	catch (Exception e) {
		System.out.println("Some Error occured in readfromExcel"+e.getMessage());
	}
	
	return suit;
	
}

} 
