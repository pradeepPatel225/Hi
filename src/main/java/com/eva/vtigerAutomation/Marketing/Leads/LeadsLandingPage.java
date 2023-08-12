package com.eva.vtigerAutomation.Marketing.Leads;

import org.openqa.selenium.support.PageFactory;

import com.eva.vtigerAutomation.Marketing.LeadsOR.LeadsLandingPageOR;

import utillityLayer.WebUtil;

public class LeadsLandingPage extends LeadsLandingPageOR {

	WebUtil util;
	public LeadsLandingPage(WebUtil utl) {
		util=utl;
		PageFactory.initElements(util.driver, this);
	}


	public LeadsCreationPage clickOnCreateLeadsBtn() {
		util.click(weCreateLeadsBtn, "Create Leads Btn");
		return	new LeadsCreationPage(util);

	}

	
	


}


