package com.eva.vtigerAutomation.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Itestresult implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("I am onTestStart");

		System.out.println(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("I am onTestSuccess");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("I am onTestFailure"); 
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("I am onTestSkipped");
	}

	public void onStart(ITestContext context) {
		System.out.println("I am onStart");
	}

	public void onFinish(ITestContext context) {
		System.out.println("I am onFinish");
	}

}
