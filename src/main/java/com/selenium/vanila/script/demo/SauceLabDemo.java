package com.selenium.vanila.script.demo;

public class SauceLabDemo extends SeleniumBase {
	
	public static void main(String[] args) {
		launchChromeBrowser();
		maximize();
		launchAUTUrl("https://www.saucedemo.com/");
		
		waitUnitElemenVisibilty(locateElement("user-name"));
		type(locateElement("user-name"), "standard_user");
		type(locateElement("password"), "secret_sauce");
		click(locateElement(LocatorType.XPATH, "//*[@id=login-button]"));		
	}

}