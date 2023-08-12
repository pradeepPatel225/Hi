package com.eva.vtigerAutomation.Marketing.Leads;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import com.eva.vtigerAutomation.Marketing.LeadsOR.LeadsEditionPageOR;

import utillityLayer.WebUtil;

public class LeadsEditionPage extends LeadsEditionPageOR {

	WebUtil util;
	public LeadsEditionPage(WebUtil utl) {
		util=utl;
		PageFactory.initElements(util.driver, this);


	}

	public void editLeadsDetails(Map <String,String> mapData) {


		String Firstname = mapData.get("EditFirstname");
		String Lastname = mapData.get("EditLastname");
		String CompanyName = mapData.get("EditCompany");
		String Title = mapData.get("EditTitle");

		util.sendkeys(weFirstname, Firstname, "Firstname text box");
		util.sendkeys(weLastname, Lastname, "Lastname Text box");
		util.sendkeys(weCompany, CompanyName, "Company Text box");
		util.sendkeys(weTitle, Title, "Title Text box");
	}


}
