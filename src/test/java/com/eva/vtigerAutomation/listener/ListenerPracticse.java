package com.eva.vtigerAutomation.listener;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListenerPracticse extends ListnerBaseTest {

	@Test(retryAnalyzer = retryFailedCases.class)
	public void testCase001() {
		System.out.println("hi I am @Test method");
		Assert.assertEquals(false, true);
	}
}
