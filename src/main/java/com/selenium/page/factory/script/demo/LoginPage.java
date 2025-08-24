package com.selenium.page.factory.script.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.testng.script.demo.TestNGHooks;

public class LoginPage extends TestNGHooks {
	
	@FindBy(id = "user-name")
	WebElement usernamefield;	
	
	@FindBy(id = "password")
	WebElement passwordfield;
	
	@FindBy(xpath = "//*[@id='login-button']")
	WebElement loginButton;	
	
	public LoginPage() {		
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String username) {
		waitUnitElemenVisibilty(usernamefield);
		type(usernamefield, username);
	}
	
	public void enterPassword(String password) {
		type(passwordfield, password);
	}
	
	public void clickLoginButton() {
		click(loginButton);
	}

}