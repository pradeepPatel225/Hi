package com.eva.vtigerAutomation.HomePageOR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeLandingPageOr {

	@FindBy(linkText = "Marketing")
	protected WebElement weMarketing;
	
	@FindBy(linkText = "Leads")
	protected WebElement weLeads;
	
	
}
