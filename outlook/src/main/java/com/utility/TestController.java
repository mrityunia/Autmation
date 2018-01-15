package com.utility;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.common.StartDriver;

public class TestController {
	public static Method method[];
	private static  List<TestCases> testCases;
	
	
	public  void execute_Action(Object cl ,String KeyWord,String data) {
	
		try {
		
		
		method=cl.getClass().getMethods();
	
		for(int i=0;i<method.length;i++){		
  			if(method[i].getName().equals(KeyWord)){
  				method[i].invoke(cl,data);
  				break;
  				}
  			}
	
	}
	
	catch(Exception e) {
		System.out.println("Some system error occured in "+cl.getClass()+"Is class name"+KeyWord);
		
	}
}
	
	public   void execute_Action(Object cl ,String KeyWord,String data,String param) {
		
		try {
		
		
		method=cl.getClass().getMethods();
	
		for(int i=0;i<method.length;i++){		
  			if(method[i].getName().equals(KeyWord)){
  				method[i].invoke(cl,data,param);
  				break;
  				}
  			}
	
	}
	
	catch(Exception e) {
		System.out.println("Some system error occured in "+cl.getClass()+"Is class name"+KeyWord);
		
	}
}

public int testExecuter(Object cl,TestSuits suits,WebDriver webDrive) {
	int testCaseCount=0;
	String SC=null;
	String Title=null;
	try {
		 //List<TestCases> testCases;
		testCases = new ArrayList<TestCases>();
		  for (int i =0;i<suits.getTestcases().size();i++){
		    	if(!(suits.getTestcases().get(i).getTestCase().isEmpty())){
		    		testCases.add(i, suits.getTestcases().get(i));
		    		testCaseCount++;
		    	}} 
		 
		  SConfiguration.log.info("Total Test Cases count is "+testCaseCount);
		  
		  System.out.println("Total Test Cases count in tester class is "+testCaseCount);
		  
		  TestCases tc =new TestCases();
		    List <Steps> sts = new ArrayList<Steps>();
		    Steps st = new Steps();
		    StepsDetails std= new StepsDetails();
		    List <String> pr= new ArrayList<String>();
		    List  <String> M= new ArrayList<String>();
		    for(int i=0;i<=testCaseCount;i++){	
		    	
		    	
		    	tc=testCases.get(i);
		    	
		    	  SConfiguration.log.info("Start Test cases name "+tc.getTestCase());
		    	  SConfiguration.log.info("Test Case Description"+tc.getTestDescription());
		    	
		    	System.out.println("***********************************/n");
		    	System.out.println("Start Test cases name"+tc.getTestDescription());
		    	System.out.println("Start Test cases name"+tc.getTestCase());
		    	
		    	StartDriver.r.startTest(StartDriver.r.getReport(), tc.getTestCase());
		    
		    	
	    	for(int j=0;j<tc.getTestSteps().size();j++){
	    		if(tc.getTestSteps().get(j)==null){
	    			break;
	    		}else{
	         sts.add(j, tc.getTestSteps().get(j));
	         }
	    }
	    	for (int k=0;k<sts.size();k++){
	    		st=sts.get(k);
	    		std=st.getSteps();
	    		String a =std.getStepDesc();
	    		String b=std.getKeyword();
	    		pr =std.getParameters();
	    		String Exr=std.getExpectedResult();
	    		
	    		if(pr==null){

	    			if(a.startsWith("OpenHomepage")){
	        			execute_Action(cl,a,b);
	        			
	        		String Actual =	m(tc,webDrive,Exr,k,a);
	        			  SConfiguration.log.info("Steps desription is "+a);
	        			  SConfiguration.log.info("Steps Key word  is "+b);
	        			  SConfiguration.log.info("Steps Expected  result   is "+Exr);
	        			  SConfiguration.log.info("Steps Actual   result   is "+Actual);
	        			
	        			/*Title=webDrive.getTitle();
	        			
	        			StartDriver.r.logs(StartDriver.r.getTest(), "INFO", a.concat(Title));
	        			StartDriver.r.saveSreentShots(tc.getTestCase()+"Step"+k, StartDriver.r.takeScreentShots(webDrive));
	        			
	        		SC =(SConfiguration.ScreenShots.concat("\\").concat(tc.getTestCase()).concat("Step")+k).concat(".png");
	        		if(Title.equalsIgnoreCase(Exr)) {
	        			StartDriver.r.logs(StartDriver.r.getTest(), "PASS", "Actual Result   "+Title+"expected Result   "+Exr,SC);
	        		}
	        		else
        			{
	        			StartDriver.r.logs(StartDriver.r.getTest(), "FAIL", "Actual Result  "+Title+"expected Result   "+Exr  ,SC);
        				
        			}*/
	        			
	        		}
	        		else if(a.startsWith("Click")){
	        			execute_Action(cl,a,b);
	        			String Actual =	m(tc,webDrive,Exr,k,a);
	        			  SConfiguration.log.info("Steps desription is "+a);
	        			  SConfiguration.log.info("Steps Key word  is "+b);
	        			  SConfiguration.log.info("Steps Expected  result   is "+Exr);
	        			  SConfiguration.log.info("Steps Actual   result   is "+Actual);
	        			
	        		}
	        			else{
	        				System.out.println("Enter correct key word");
	        			}
	        		}
	    		
	    		else{
	    			for(int l=0;l<pr.size();l++){
	    				
	    				
	    				M.add(l, pr.get(0));
	    				
	    			}
	    			
	    			
	    			 if(a.startsWith("Enter")){
	        			execute_Action(cl,a,b,M.get(0));
	        			String Actual =	m(tc,webDrive,Exr,k,a);
	        			  SConfiguration.log.info("Steps desription is "+a);
	        			  SConfiguration.log.info("Steps Key word  is "+b);
	        			  SConfiguration.log.info("Steps Expected  result   is "+Exr);
	        			  SConfiguration.log.info("Steps Actual   result   is "+Actual);
	        			
	        		}
	    			 else if(a.startsWith("OpenHomepage")){
	         			execute_Action(cl,a,b);
	         			String Actual =	m(tc,webDrive,Exr,k,a);
	        			  SConfiguration.log.info("Steps desription is "+a);
	        			  SConfiguration.log.info("Steps Key word  is "+b);
	        			  SConfiguration.log.info("Steps Expected  result   is "+Exr);
	        			  SConfiguration.log.info("Steps Actual   result   is "+Actual);
	        			
	         		}
	    			 else if(a.startsWith("Click")){
	         			execute_Action(cl,a,b);
	         			String Actual =	m(tc,webDrive,Exr,k,a);
	        			  SConfiguration.log.info("Steps desription is "+a);
	        			  SConfiguration.log.info("Steps Key word  is "+b);
	        			  SConfiguration.log.info("Steps Expected  result   is "+Exr);
	        			  SConfiguration.log.info("Steps Actual   result   is "+Actual);
	        			
	         		}
	        		else{
	        			System.out.println("Enyter correct keyword");
	        			
	        		}
	    		}	
	    		

	    		}
	    	    	
	    	System.out.println("***********************************/n");
	    	System.out.println("End Test cases name"+tc.getTestDescription());
	    	System.out.println("End Test cases name"+tc.getTestCase());
	    	System.out.println("***********************************");
	    	StartDriver.r.endTest(StartDriver.r.getReport(), StartDriver.r.getTest());
	    
		
	}}
	
	catch(Exception e) {
		System.out.println("error occured in "+cl.getClass()+""+e.getMessage());
		
	}
	
	return testCaseCount;
	
	
}

public String   m(  TestCases tc,WebDriver webDrive,String Exr,int k,String a) throws IOException {
	
	String SC=null;
	String Title=null;
	
	Title=webDrive.getTitle();
	
	StartDriver.r.logs(StartDriver.r.getTest(), "INFO", a.concat(" "+Title));
	StartDriver.r.saveSreentShots(tc.getTestCase()+"Step"+k, StartDriver.r.takeScreentShots(webDrive));
	
SC =(SConfiguration.ScreenShots.concat("\\").concat(tc.getTestCase()).concat("Step")+k).concat(".png");
if(Title.equalsIgnoreCase(Exr)) {
	StartDriver.r.logs(StartDriver.r.getTest(), "PASS", "Actual Result is :   "+Title+" ||  expected Result :  "+Exr,SC);
}
else
{
	StartDriver.r.logs(StartDriver.r.getTest(), "FAIL", "Actual Result is : "+Title+" || expected Result  : "+Exr  ,SC);
	
}
return Title;
	
}
	
	
}
