package com.eva.vtigerAutomation.TestCaseLayer;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.eva.vtigerAutomation.Login.LoginPage;
import com.eva.vtigerAutomation.Marketing.Leads.LeadsDetailsPage;

import utillityLayer.ExcelUtility;
import utillityLayer.WebUtil;

public class BaseTest {

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

	@org.testng.annotations.Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void beforeClass(String browserName) throws IOException {
		System.out.println("I am beforeClass");
		util.initHtmlReport();
		util.setExtentLogger("TC001");
		// util.launchBrowser(util.configDataRead(browserName));
		util.launchBrowser(browserName);

		util.hitUrl(util.configDataRead("URL"));
		login = new LoginPage(util);
		login.inValidLogin();
		login.validLogin();
		// login.validLogin(map);

	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method m) throws IOException {
		System.out.println("I am beforeMethod");
				String methodName = m.getName();
				map = ExcelUtility.getRowData("src\\test\\resources\\ExelData\\ExcelTestData.xlsx", methodName, 1);

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws IOException {

		util.flushReport();
		System.out.println("I am afterMethod");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		LeadsDetailsPage ldp = new LeadsDetailsPage(util);
		ldp.SignOut();
		// util.close();
		// util.quit();
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

//	@DataProvider
//	public void getData(Method m) {
//		String methodName = m.getName();
//		map = ExcelUtility.getRowData("src\\test\\resources\\ExelData\\ExcelTestData.xlsx", methodName, 1);
//		int size =	map.size();
//		Object obj = new Object[size][1];
//		for(int i=0; i<=size; i++) {
//			
//		}

	}


