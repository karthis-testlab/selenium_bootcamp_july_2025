package com.selenium.testng.script.demo;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestNGHooks extends SeleniumBase {
	
	@Parameters({"browser-name"})
	@BeforeSuite
	public void beforeSuite(@Optional("chrome") String browserName) {
		System.out.println(browserName);
		launchBrowser(browserName);
		maximize();
	}
	
	@AfterSuite
	public void afterSuite() {
		browserClose();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		launchAUTUrl("https://www.saucedemo.com/");
	}

}