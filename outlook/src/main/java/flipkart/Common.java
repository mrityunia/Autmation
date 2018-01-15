package flipkart;



import org.openqa.selenium.WebDriver;

import com.common.Base;

public class Common extends Base {
	public Common(WebDriver webDriver, String url) {
		super(webDriver, url);
	}

	    
	    public void OpenHomepage(String D){
	    

	        try {
	        	webDriver.get(url);
	      
	        	Thread.sleep(2000);
	    	
	  
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
