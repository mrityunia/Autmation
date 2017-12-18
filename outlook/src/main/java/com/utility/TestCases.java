package com.utility;

import java.util.List;

public class TestCases {
	private String testCase;
	public String getTestCase() {
		return testCase;
	}
	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}
	public String getTestDescription() {
		return testDescription;
	}
	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}
	public String getRunStatus() {
		return runStatus;
	}
	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}
	private String testDescription;
	private String runStatus;

	
	public List<Steps> getTestSteps() {
		return TestSteps;
	}
	public void setTestSteps(List<Steps> testSteps) {
		TestSteps = testSteps;
	}
	private  List<Steps> TestSteps;
	

}
