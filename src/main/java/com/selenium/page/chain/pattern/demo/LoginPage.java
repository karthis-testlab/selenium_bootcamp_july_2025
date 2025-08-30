package com.selenium.page.chain.pattern.demo;

import org.testng.Assert;

import com.selenium.testng.script.demo.SeleniumBase;

public class LoginPage extends SeleniumBase {
	
	public LoginPage() {
		Assert.assertTrue(locateElement(PropertiesHandler.getObject("LoginPage", "loginpage.username.id")).isDisplayed());
	}
	
	public LoginPage enterUsername(String username) {
		locateElement(PropertiesHandler.getObject("LoginPage", "loginpage.username.id")).sendKeys(username);
		return this;		
	}
	
	public LoginPage enterPassword(String password) {
		locateElement(PropertiesHandler.getObject("LoginPage", "loginpage.password.id")).sendKeys(password);
		return this;		
	}
	
	public InventoryPage clickOnTheLoginButton() {
		locateElement(PropertiesHandler.getObject("LoginPage", "loginpage.loginbtn.id")).click();
		return new InventoryPage();		
	}

}