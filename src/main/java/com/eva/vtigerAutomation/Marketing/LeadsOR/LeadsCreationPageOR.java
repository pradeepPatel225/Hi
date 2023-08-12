package com.eva.vtigerAutomation.Marketing.LeadsOR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsCreationPageOR {

	@FindBy(xpath = "//input[@name='firstname']")
	protected WebElement weFirstname;

	@FindBy(xpath = "//input[@name='lastname']")
	protected WebElement weLastname;
	
	@FindBy(xpath = "//input[@name='company']")
	protected WebElement weCompany;
	
	@FindBy(xpath = "//input[@name='designation']")
	protected WebElement weTitle;
	
	@FindBy(xpath = "//textarea[@name='lane']")
	protected WebElement weStreet;
	
	@FindBy(xpath = "//input[@name='code']")
	protected WebElement wePostalCode;
	
	@FindBy(xpath = "//input[@name='country']")
	protected WebElement weCountry;
	
	
	@FindBy(xpath = "//input[@name='phone']")
	protected WebElement wePhone;
	
	@FindBy(xpath = "//input[@name='mobile']")
	protected WebElement weMobile;
	
	@FindBy(xpath = "//input[@name='fax']")
	protected WebElement weFax;
	
	@FindBy(xpath = "//input[@name='email']")
	protected WebElement weEmail;
	
	@FindBy(xpath = "//input[@name='pobox']")
	protected WebElement wePoBox;
	
	@FindBy(xpath = "//input[@name='city']")
	protected WebElement weCity;
	
	@FindBy(xpath = "//input[@name='state']")
	protected WebElement weState;
	
	@FindBy(xpath = "//textarea[@name='description']")
	protected WebElement weDescription;
	
	@FindBy(xpath = "(//span[text()='vtiger CRM 5.2.1']/preceding::div[@id='moreTab']/preceding::div//input[@type=\"submit\"])[2]")
	protected WebElement weSaveButton;
	
}
