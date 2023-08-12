package com.eva.vtigerAutomation.listener;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ListnerBaseTest {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am beforeSuite() method.");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am beforeTest() method.");


	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("I am beforeClass() method.");


	}

	@BeforeMethod
	public void beforeMehtod() {
		System.out.println("I am beforeMehtod() method.");


	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("I am afterMethod() method.");


	}

	@AfterClass
	public void afterClass() {
		System.out.println("I am afterClass() method.");


	}

	@AfterTest
	public void afterTest() {
		System.out.println("I am afterTest() method.");


	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("I am afterSuite() method.");


	}
}
