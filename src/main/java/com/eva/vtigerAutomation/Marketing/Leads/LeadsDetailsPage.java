package com.eva.vtigerAutomation.Marketing.Leads;

import org.openqa.selenium.support.PageFactory;

import com.eva.vtigerAutomation.Marketing.LeadsOR.LeadsDetailsPageOR;

import utillityLayer.WebUtil;

public class LeadsDetailsPage extends LeadsDetailsPageOR {

	WebUtil util;
	public LeadsDetailsPage(WebUtil utl) {
		util=utl;
		PageFactory.initElements(util.driver, this);
	}

	public void clickOnEditButton() {
		util.click(weEditButton, "Edit Button");
	}

	public void clickOnSaveBtnAfterEdit() {
		util.click(weSaveBtn, "Save Button");


	}

	public void deleteLeadsCreationInfo() {
		util.click(weDeleteBtn, "Delete btn");

	}

	public void handleDeletePopup() {
		util.popPupHandle("accept");
	}

	public void SignOut() {
		util.click(weSgnOut, "Sign out link");
	}




}
