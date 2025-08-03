package com.selenium.testng.script.demo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceLabDemoTest extends TestNGHooks {
	
	@DataProvider
	public String[][] getTestData() {
		return new String[][] {
			{"", "", ""},
			{"", "", ""},
			{"", "", ""}
		};
	}
	
	@Test
	public void userShouldAbleToLoginIntoSauceDemoSite() {
		waitUnitElemenVisibilty(locateElement("user-name"));
		type(locateElement("user-name"), "standard_user");
		type(locateElement("password"), "secret_sauce");
		click(locateElement(LocatorType.XPATH, "//*[@id=login-button]"));	
		Assert.assertEquals(getDomText(locateElement("")), "");
	}

}