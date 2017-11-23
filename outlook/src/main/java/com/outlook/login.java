package com.outlook;


import org.openqa.selenium.WebDriver;

import com.common.Base;



public class login extends Base{
	
	public login(WebDriver Driver, String url){
		super(Driver,url);
		
	}
	public void openStratingPage(String TestCaseName){
		webDriver.get(url);	
		try {
			//allWebelemtsLinks();
			allWebelemtsInPage();
			Thread.sleep(2000);		
			addsc(Opnepage.getProperty("Click_oSign"));
			
			clickObject(Opnepage.getProperty("Click_oSign"));
			//allWebelemtsInPage();
			
			
		} catch (Exception e) {
			
			System.out.println("Log in functionality");
		}
	}
	
	public void loginTo(String TestcaseName,String userName,String password){
		
    try{
	
	Thread.sleep(4000);
	insertString(Opnepage.getProperty("Insert_UserName"),userName);	
	
	clickObject(Opnepage.getProperty("Click_Next"));

	insertString(Opnepage.getProperty("Insert_password"),password);	
	
	
	addsc(Opnepage.getProperty("Insert_password"));
	clickObject(Opnepage.getProperty("click_signin"));

  }
catch(Exception E){
	
}
		
	}

}
