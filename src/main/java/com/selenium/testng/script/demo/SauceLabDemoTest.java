package com.selenium.testng.script.demo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceLabDemoTest extends TestNGHooks {
	
	@DataProvider(name = "data")
	public String[][] getTestData() {
		return ExcelDataHandler.getTestData("test-data");
	}
	
	@Test
	public void userShouldAbleToLoginIntoSauceDemoSite() {
		waitUnitElemenVisibilty(locateElement("user-name"));
		type(locateElement("user-name"), "standard_user");
		type(locateElement("password"), "secret_sauce");
		click(locateElement(LocatorType.XPATH, "//*[@id=login-button]"));	
		Assert.assertEquals(getDomText(locateElement("")), "");
	}
	
	@Test(dataProvider = "data")
	public void dataProviderTest(String username, String password) {
		System.out.println(username+" | "+password);
	}

}