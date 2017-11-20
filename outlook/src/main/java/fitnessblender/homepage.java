package fitnessblender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.common.Base;

public class homepage extends Base {
	public homepage(WebDriver Driver, String url){
		super(Driver,url);
		
	}
	public void openPage(String TestcasesName ){
		
		webDriver.get(url);	
		
	}
	
	public void login (String TestCaseName,String Username,String Password){
		
		Actions act = new Actions(webDriver);
		
		//waitForElementDisply(Opnepage.getProperty("click_Sign_Home"));
		//act.moveToElement(webDriver.findElement(By.xpath(Opnepage.getProperty("b"))));	
		//waitForElementDisply(Opnepage.getProperty("b"));
		//clickObject(Opnepage.getProperty("b"));
		
		
		
		try {
			//webDriver.findElement(By.xpath(Opnepage.getProperty("b"))).click();
			webDriver.findElement(By.xpath(Opnepage.getProperty("login_xpath"))).click();
			webDriver.findElement(By.xpath(Opnepage.getProperty("username_xpath"))).sendKeys(Username);
			webDriver.findElement(By.xpath(Opnepage.getProperty("password_xpath"))).sendKeys(Password);
			Thread.sleep(1000);
			webDriver.findElement(By.xpath(Opnepage.getProperty("login_buttton_xpath"))).click();
			Thread.sleep(100000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	

}
