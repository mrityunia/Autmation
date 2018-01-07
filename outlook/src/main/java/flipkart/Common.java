package flipkart;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.common.Base;

public class Common extends Base {
	public Common(WebDriver webDriver, String url) {
		super(webDriver, url);
	}

	    
	    public void OpenHomepage(String D){
	    

	        try {
	        	webDriver.get(url);
	      
	        	Thread.sleep(2000);
	    		List<WebElement> list=getAllref();
	  
	    	} catch (InterruptedException e) {
	    		// TODO Auto-generated catch block
	    	
	    	}  
	    }
	    
	    
	


	public void click(String linkText) throws InterruptedException{
		Thread.sleep(5000);
		clickObject(linkText);	}
	
	public void enter(String linkText,String data){
		insertString(linkText,data);
	}
}
