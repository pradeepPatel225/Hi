package com.eva.vtigerAutomation.Marketing.LeadsOR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsEditionPageOR {

	@FindBy(xpath = "//input[@name='firstname']")
	protected WebElement weFirstname;

	@FindBy(xpath = "//input[@name='lastname']")
	protected WebElement weLastname;
	
	@FindBy(xpath = "//input[@name='company']")
	protected WebElement weCompany;
	
	@FindBy(xpath = "//input[@name='designation']")
	protected WebElement weTitle;
	
	
	
}
