package test.flipkart;




import org.testng.annotations.Test;

import com.common.StartDriver;
import com.utility.SConfiguration;

import com.utility.TestController;
import com.utility.TestSuits;

import flipkart.Common;

public class startingPage extends StartDriver {
	
	public startingPage(){
		super();
	}
	
	public static Common cm;
	private TestSuits suits;
	
	
	@Test
	
	public void TC_009() throws Exception {
		String TestcaseShet=SConfiguration.testCaesSheet;
		cm= new Common(super.webDriver, super.URL);
		// method=cm.getClass().getMethods();
		 suits= new TestSuits();
			suits=cm.readfromExcel(TestcaseShet);
			
			TestController tc= new TestController();
			int tcs= tc.testExecuter(cm, suits,super.webDriver);
			
			    System.out.println("Total Test cses count in tester class is "+tcs);
		
	}
	
}
	
	
	

