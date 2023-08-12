package com.eva.vtigerAutomation.LoginOR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginOr {


	@FindBy(xpath ="//input[@name='user_name']")
	protected WebElement weUserName;

	@FindBy(xpath="//input[@name='user_password']")
	protected WebElement wePassword;

	@FindBy(xpath="//input[@name='Login']")
	protected WebElement weLoginButton;


}
