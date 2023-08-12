package com.eva.vtigerAutomation.Marketing.LeadsOR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LeadsDetailsPageOR {
	
	
	@FindBy(xpath = "//span[text()='vtiger CRM 5.2.1']/preceding::td[@class=\"dvtUnSelectedCell\"]/following-sibling::td[@class=\"dvtTabCacheBottom\"]//input[@title=\"Edit [Alt+E]\"]")
	protected WebElement weEditButton;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	protected WebElement weSaveBtn;
	
	@FindBy(xpath = "(//input[@value='Delete'])[1]")
	protected WebElement weDeleteBtn;

	@FindBy(xpath = "//a[text()='Sign Out']")
	protected WebElement weSgnOut;

}
