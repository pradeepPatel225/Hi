package com.eva.vtigerAutomation.HomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.eva.vtigerAutomation.HomePageOR.HomeLandingPageOr;

import utillityLayer.WebUtil;

public class HomeLandingPage extends HomeLandingPageOr {

	WebUtil util;
	public HomeLandingPage(WebUtil utl) {
		util=utl;
		PageFactory.initElements(util.driver, this);
	}

	public void navigateToMarketingLeads() {
		util.mouseOver(weMarketing, "Marketing Link");
		util.click(weLeads, "Leads Link");

	}


	
}
