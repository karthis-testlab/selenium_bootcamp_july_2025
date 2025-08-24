package com.selenium.pom.script.demo;

import com.selenium.testng.script.demo.LocatorType;
import com.selenium.testng.script.demo.SeleniumBase;

public class LoginPage extends SeleniumBase {

	public void enterUserName(String text) {
		waitUnitElemenVisibilty(locateElement("user-name"));
		type(locateElement("user-name"), text);
	}

	public void enterPassowrd(String text) {
		type(locateElement("password"), text);
	}

	public void clickLoginButton() {
		click(locateElement(LocatorType.XPATH, "//*[@id=login-button]"));
	}

}