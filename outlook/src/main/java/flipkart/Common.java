package flipkart;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.common.Base;

public class Common extends Base {
	public Common(WebDriver webDriver, String url) {
		super(webDriver, url);
	}
	public void OpenHomepage(){
		
	    try {
	    	webDriver.get(url);
			Thread.sleep(2000);
			List<WebElement> list=getAllref();

			for (int a =0;a<=list.size();a++){
				
				getsourcCode(list.get(5).getText());
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		
		} 
	

}}
