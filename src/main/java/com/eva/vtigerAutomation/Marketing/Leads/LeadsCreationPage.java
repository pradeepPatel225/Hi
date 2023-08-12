package com.eva.vtigerAutomation.Marketing.Leads;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import com.eva.vtigerAutomation.Marketing.LeadsOR.LeadsCreationPageOR;

import utillityLayer.WebUtil;

public class LeadsCreationPage extends LeadsCreationPageOR {

	WebUtil util;
	public LeadsCreationPage(WebUtil utl) {
		util=utl;
		PageFactory.initElements(util.driver, this);
	}

	public void fillLeadsCreationInfo(Map<String, String> mapData) {
		String Firstname = mapData.get("FirstName");
		String Lastname = mapData.get("LastName");
		String CoompanyName = mapData.get("CompanyName");
		String Title = mapData.get("Title");
		String Street = mapData.get("Street");
		String PostalCode = mapData.get("PostalCode");
		String Country = mapData.get("Country");
		String Phone = mapData.get("Phone");
		String Mobile = mapData.get("Mobile");
		String Fax = mapData.get("Fax");
		String Email = mapData.get("Email");
		String PoBox = mapData.get("PO Box");
		String City = mapData.get("City");
		String State = mapData.get("State");
		String Discription = mapData.get("Discription");

		util.sendkeys(weFirstname, Firstname, "Firstname text box");
		util.sendkeys(weLastname, Lastname, "Lastname Text box");
		util.sendkeys(weCompany, CoompanyName, "Company Text box");
		util.sendkeys(weTitle, Title, "Tile Text box");
		util.sendkeys(weStreet, Street, "Street Text box");
		util.sendkeys(wePostalCode, PostalCode, "PostalCode Text box");
		util.sendkeys(weCountry, Country, "Country Text box");
		util.sendkeys(wePhone, Phone, "Phone Text box");
		util.sendkeys(weMobile, Mobile, "Mobile Text box");
		util.sendkeys(weFax, Fax, "Fax Text box");
		util.sendkeys(weEmail, Email, "Email Text box");
		util.sendkeys(wePoBox, PoBox, "PO box Text box");
		util.sendkeys(weCity, City, "City Text box");
		util.sendkeys(weState, State, "State Text box");
		util.sendkeys(weDescription,Discription, "Description text box");




	}

	public LeadsDetailsPage clickOnSaveButtonInLdsCrnInfo() {
		util.click(weSaveButton, "Save Button");
		return new LeadsDetailsPage(util);

	}



}
