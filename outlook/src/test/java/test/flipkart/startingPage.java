package test.flipkart;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


import org.testng.annotations.Test;

import com.common.StartDriver;
import com.utility.SConfiguration;
import com.utility.TestCases;
import com.utility.TestSuits;

import flipkart.Common;

public class startingPage extends StartDriver {
	
	public startingPage(){
		super();
	}
	
	public static Common cm;
	private TestSuits suits;
	private List<TestCases> testCases;
	private static int totalNoTetsCase=0;
	public static Method method[];
	
	
	
	@Test
	
	public void TC_009() throws Exception {
		String TestcaseShet=SConfiguration.testCaesSheet;
		cm= new Common(super.webDriver, super.URL);
		 method=cm.getClass().getMethods();
		 suits= new TestSuits();
			suits=cm.readfromExcel(TestcaseShet);
			testCases = new ArrayList<TestCases>();
		 
			  for (int i =0;i<suits.getTestcases().size();i++){
			    	if(!(suits.getTestcases().get(i).getTestCase().isEmpty())){
			    		testCases.add(i, suits.getTestcases().get(i));
			    		totalNoTetsCase++;
			    	}    	   
			}
			    System.out.println("Total Test cses count in tester class is "+totalNoTetsCase);
			    for(int i=0;i<=totalNoTetsCase;){
			    	
			 	   String Key=testCases.get(0).getTestSteps().get(0).getSteps().getKeyword();
			 	   System.out.println("keyword"+Key);	  
					execute_Actions(Key);
					break;
				 
			    	
			    }
		
	}
	
	public static void execute_Actions(String sActionKeyword ) throws Exception {	
  		for(int i=0;i<method.length;i++){		
  			if(method[i].getName().equals(sActionKeyword)){
  				method[i].invoke(cm);
  				break;
  				}
  			}
  		}
}
	
	
	

