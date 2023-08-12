package com.eva.vtigerAutomation.TestCase;

import org.testng.annotations.Test;

import com.eva.vtigerAutomation.HomePage.HomeLandingPage;
import com.eva.vtigerAutomation.Marketing.Leads.LeadsCreationPage;
import com.eva.vtigerAutomation.Marketing.Leads.LeadsDetailsPage;
import com.eva.vtigerAutomation.Marketing.Leads.LeadsEditionPage;
import com.eva.vtigerAutomation.Marketing.Leads.LeadsLandingPage;


public class TcLayer extends BaseClass {

	
	LeadsDetailsPage ldp;

	
	@Test(description = "" ,groups = {"smoke"})
	public void Tc001() {
		
		HomeLandingPage homePage = new HomeLandingPage(util);
		homePage.navigateToMarketingLeads();
		LeadsLandingPage llp = new LeadsLandingPage(util);
		LeadsCreationPage lcp = llp.clickOnCreateLeadsBtn();
		lcp.fillLeadsCreationInfo(map);
		ldp = lcp.clickOnSaveButtonInLdsCrnInfo();

	}

	@Test(dependsOnMethods = "verifyLeadsCreation", priority = 1, groups = "regression")
	public void verifyLeadsEdition() {
		// HomeLandingPage homePage = new HomeLandingPage(util);
		// homePage.navigateToMarketingLeads();
		// LeadsLandingPage llp = new LeadsLandingPage(util);
		// LeadsCreationPage lcp = llmapp.clickOnCreateLeadsBtn();
		// lcp.fillLeadsCreationInfo();
		// LeadsDetailsPage ldp = lcp.clickOnSaveButtonInLdsCrnInfo();

		ldp.clickOnEditButton();
		LeadsEditionPage lep = new LeadsEditionPage(util);
		lep.editLeadsDetails(map);
		ldp.clickOnSaveBtnAfterEdit();

	}

    @Test(dependsOnMethods = "verifyLeadsCreation",  priority = 2, groups = {"smoke", "regression"})
	public void verifyLeadsDeletion() {
		// HomeLandingPage homePage = new HomeLandingPage(util);
		// homePage.navigateToMarketingLeads();
		// LeadsLandingPage llp = new LeadsLandingPage(util);
		// LeadsCreationPage lcp = llp.clickOnCreateLeadsBtn();
		// lcp.fillLeadsCreationInfo(map);
		// LeadsDetailsPage ldp = lcp.clickOnSaveButtonInLdsCrnInfo();
		// ldp.editLeadsCreationInfo();
		// ldp.clickOnSaveBtnAfterEdit();
		ldp.deleteLeadsCreationInfo();
		ldp.handleDeletePopup();

	}

}
