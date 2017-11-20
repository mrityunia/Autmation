package outlook;



import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.common.StartDriver;

import com.outlook.login;




public class OpenOutlook extends StartDriver {
	

	
	
	public OpenOutlook(){
		super();
		//initilize();
		
	}
	
	@Test
	@Parameters({"username","passwrod"})
	public void TC_01(String username,String passwrod){		                           
		login Log= new login(super.webDriver,super.URL);
		r.startTest(r.getReport(), "TC_01");
		String Title=null;
		
		
		try {
			//Steps 1
			
			Log.openStratingPage("TC_01");
			Title=webDriver.getTitle();
			r.logs(r.getTest(), "INFO", "outlook successfully opend ".concat(Title));
			r.saveSreentShots(config, "TC_01", r.takeScreentShots(super.webDriver));
			
			assertTrue(Title.equalsIgnoreCase("Sign in to your Microsoft account"));
			{
				r.logs(r.getTest(), "PASS", "Starting Title page is correct",config.getProperty("ScreenShotsLocation"));
				
			}	

			//Steps 2
			
			Log.loginTo("TC_01",username,passwrod);
			Title=webDriver.getTitle();
			r.logs(r.getTest(), "INFO", "user is able to login  ".concat(Title));
			r.saveSreentShots(config, "TC_02", r.takeScreentShots(super.webDriver));
			 
			assertTrue(Title.equalsIgnoreCase("Mail - mchowdhury891@outlook.com"));
			{
				r.logs(r.getTest(), "PASS", "Starting Title page is correct",config.getProperty("ScreenShotsLocation"));
				
			}	
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	r.endTest(r.getReport(), r.getTest());
	r.flash(r.getReport());
	

	}
	
}
