package com.selenium4.grid.demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class RunSauceLabCode {

	public static void main(String[] args) {
		
		try {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);
			Map<String, Object> sauceOptions = new HashMap<String, Object>();
			sauceOptions.put("username", "<sauce-lab-username>");
			sauceOptions.put("accessKey", "<sauce-lab-access-key>");
			sauceOptions.put("build", "selenium-build-GKORI");
			sauceOptions.put("name", "RunSauceLabCode"+new Date());	
			options.setCapability("sauce:options", sauceOptions);
			RemoteWebDriver driver = new RemoteWebDriver(new URI("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub").toURL(), options);		
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();
			Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"));
			driver.quit();
		} catch (MalformedURLException | URISyntaxException e) {			
			e.printStackTrace();
		}

	}

}
