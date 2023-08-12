package com.eva.vtigerAutomation.Login;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import com.eva.vtigerAutomation.HomePage.HomeLandingPage;
import com.eva.vtigerAutomation.LoginOR.LoginOr;

import utillityLayer.ExcelUtility;
import utillityLayer.WebUtil;

public class LoginPage extends LoginOr {
	WebUtil util;

	public LoginPage(WebUtil utl) {
		util = utl;
		PageFactory.initElements(util.driver, this);

	}

	public void inValidUserName() throws IOException {
		String configData = util.configDataRead("InvalidUserName");
		util.sendkeys(weUserName, configData, "UserName textBox");

	}

	public void inValidPassword() throws IOException {
		util.sendkeys(wePassword, util.configDataRead("InvalidPassword"), "Password textBox");

	}

	public void validUserName() throws IOException {
		util.sendkeys(weUserName, util.configDataRead("ValidUserName"), "UserName textBox");

	}

	public void validPassword() throws IOException {
		util.sendkeys(wePassword, util.configDataRead("ValidPassword"), "Password textBox");

	}

	public void clickOnLoginBtn() {
		util.click(weLoginButton, "Login Button");

	}

	public void validLogin(Map<String, String> mapData) {

		String username = mapData.get("User_name");
		String password = mapData.get("User_password");
		
		//System.out.println(username + " " + password);
		util.sendkeys(weUserName, username, "UserName Text box");
		util.sendkeys(wePassword, password, "Password Text box");
		util.click(weLoginButton, "Loginbtn");

	}

	public HomeLandingPage validLogin() throws IOException {
		validUserName();
		validPassword();
		clickOnLoginBtn();
		return new HomeLandingPage(util);
	}

	public HomeLandingPage inValidLogin() throws IOException {
		inValidUserName();
		inValidPassword();
		clickOnLoginBtn();
		return new HomeLandingPage(util);
	}

	public void changeColor() {

	}

	public void changeLanguage() {

	}

}
