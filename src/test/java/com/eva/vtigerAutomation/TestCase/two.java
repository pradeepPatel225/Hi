package com.eva.vtigerAutomation.TestCase;

import utillityLayer.WebUtil;

public class two {

	

	public static void main(String[] args) {
		WebUtil w=  new WebUtil();
		w.initHtmlReport();
		w.setExtentLogger("tc");
		w.launchBrowser("chrome");
		System.out.println("hi");
	}
}
