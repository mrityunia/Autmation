package com.utility;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestController {
	public static Method method[];
	private static List<TestCases> testCases;
	
	
	public static void execute_Action(Object cl ,String KeyWord,String data) {
	
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
	
	public static  void execute_Action(Object cl ,String KeyWord,String data,String param) {
		
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

public static int testExecuter(Object cl,TestSuits suits) {
	int testCaseCount=0;
	
	try {
		testCases = new ArrayList<TestCases>();
		
		  for (int i =0;i<suits.getTestcases().size();i++){
		    	if(!(suits.getTestcases().get(i).getTestCase().isEmpty())){
		    		testCases.add(i, suits.getTestcases().get(i));
		    		testCaseCount++;
		    	}} 
		  
		  System.out.println("Total Test Cases count in tester class is "+testCaseCount);
		  
		  TestCases tc =new TestCases();
		    List <Steps> sts = new ArrayList<Steps>();
		    Steps st = new Steps();
		    StepsDetails std= new StepsDetails();
		    List <String> pr= new ArrayList<String>();
		    List  <String> M= new ArrayList<String>();
		    
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
	    		
	    		if(pr==null){

	    			if(a.startsWith("OpenHomepage")){
	        			execute_Action(cl,a,b);
	        		}
	        		else if(a.startsWith("Click")){
	        			execute_Action(cl,a,b);
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
	        		}
	    			 else if(a.startsWith("OpenHomepage")){
	         			execute_Action(cl,a,b);
	         		}
	    			 else if(a.startsWith("Click")){
	         			execute_Action(cl,a,b);
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
	    
		
	}
	
	catch(Exception e) {
		System.out.println("error occured in "+cl.getClass()+""+e.getMessage());
		
	}
	
	return testCaseCount;
	
	
}
	
	
}
