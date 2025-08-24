package com.selenium.testng.script.demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.page.factory.script.demo.LoginPage;

public class SauceLabDemoTest extends TestNGHooks {
	
	LoginPage loginPage;
	
	@DataProvider(name = "data")
	public String[][] getTestData() {
		return ExcelDataHandler.getTestData("test-data");
	}
	
	@Test
	public void userShouldAbleToLoginIntoSauceDemoSite() {
		loginPage = new LoginPage();
		loginPage.enterUserName("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLoginButton();
	}
	
	//@Test(dataProvider = "data")
	public void dataProviderTest(String username, String password) {
		System.out.println(username+" | "+password);
	}

}