package com.eva.vtigerAutomation.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;


public class retryFailedCases implements IRetryAnalyzer{
 
	int start=0;
	int  counter=2;
	
	
	public boolean retry(ITestResult result) {

		if(start<=counter) {
			start++;
			System.out.println("method retried :"+result.getTestName());
			return true;
		}
		return false;
	}

	

	
	
	
	
	
	
}
