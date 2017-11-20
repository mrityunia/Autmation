package fitnessblender;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.common.StartDriver;
import com.utility.JSONMain;

	
public class Testcases extends StartDriver {
	public Testcases(){
		super();
	}
	
	protected static homepage page;

	public void TC_01(){	
		
		page= new homepage(super.webDriver,super.URL);
		
		page.openPage("TC_01");	
	}
	@Test
	@Parameters({"userName","Password"})
	public void TC_02(String userName,String Password){
		
		page= new homepage(super.webDriver,super.URL);
		page.openPage("TC_01");	
		
		page.login("TC_02",userName, Password);
		
	}
	@Test
	@Parameters({"url"})
	public void TC_003(String url) throws Exception{
		System.out.println("Entering Test casdes");
		
		
		
		//String A=url.concat("/activity_stream/0/");
		String A=super.URL.concat("/activity_stream/0/");
		
		JSONMain.getMethods(A);
	}

}
