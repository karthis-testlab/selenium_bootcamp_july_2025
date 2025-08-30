package com.selenium.page.chain.pattern.demo;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.selenium.testng.script.demo.SeleniumBase;

public class TestNGHooks extends SeleniumBase {
	
	@Parameters({"browser-name"})
	@BeforeSuite
	public void beforeSuite(@Optional("chrome") String browserName) {
		System.out.println(browserName);
		launchBrowser(browserName);
		maximize();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(!result.isSuccess()) {
			takeSnapShot(result.getName());
		}
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