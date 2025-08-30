package com.selenium.page.chain.pattern.demo;

import org.testng.annotations.Test;

public class SauceDemoTest extends TestNGHooks {
	
	@Test
	public void userflowtest() {
		new LoginPage()
		    .enterUsername("standard_user")
		    .enterPassword("secret_sauce")
		    .clickOnTheLoginButton()
		    .addTheFirstProductIntoTheCart()
		    .clickCartIcon();
	}

}