package com.eva.vtigerAutomation.TestCase;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.eva.vtigerAutomation.Login.LoginPage;
import com.eva.vtigerAutomation.Marketing.Leads.LeadsDetailsPage;

import utillityLayer.ExcelUtility;
import utillityLayer.WebUtil;

public class BaseClass {
	WebUtil util = new WebUtil();;
	public Map<String, String> map;
	LoginPage login;

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		System.out.println("I am beforeSuite");

	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		System.out.println("I am beforeTest");

	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws IOException {
		System.out.println("I am beforeClass");
		util.initHtmlReport();
		util.setExtentLogger("TC001");
		util.launchBrowser(util.configDataRead("BrowserName"));
		util.hitUrl(util.configDataRead("URL"));
		login = new LoginPage(util);
		login.inValidLogin();
		login.validLogin();
		//login.validLogin(map);

	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method m) throws IOException {
		System.out.println("==============" + m.getName() + "================");
		String methodName = m.getName();
		map = ExcelUtility.getRowData("src\\test\\resources\\ExelData\\ExcelTestData.xlsx", methodName, 1);
		
		
		// Map<String, String>
		// map=ExcelUtility.getRowData("src\\test\\resources\\ExelData\\LeadsData.xlsx",
		// "Sheet1", 1);
		//		login =	new LoginPage(util);
		//		login.inValidLogin();
		//		login.validLogin();
		//		//login.validLogin(map);
		//		String methodName =	m.getName();
		//		map=ExcelUtility.getRowData("src\\test\\resources\\ExelData\\ExcelTestData.xlsx", methodName, 1);

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) throws IOException {
		int status = result.getStatus();
		if (status == result.FAILURE) {
			util.takeScreenShot("Failed");
		}else {
			System.out.println("Test Case passed Successfully");
			util.takeScreenShot("Passed");
		}
			util.flushReport();
			System.out.println("I am afterMethod");

		}

		@AfterClass(alwaysRun = true)
		public void afterClass() {
			LeadsDetailsPage ldp = new LeadsDetailsPage(util);
			ldp.SignOut();
			util.close();
			System.out.println("I am afterClass");

		}

		@AfterTest(alwaysRun = true)
		public void afterTest() {
			System.out.println("I am afterTest");

		}

		@AfterSuite(alwaysRun = true)
		public void afterSuite() {
			System.out.println("I am afterSuite");

		}

	}
