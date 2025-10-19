package com.selenium4.grid.demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class RunChromeGrid {

	public static void main(String[] args) {
		
		try {
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.password_manager_leak_detection", false);
			RemoteWebDriver driver = new RemoteWebDriver(new URI("http://localhost:4444/").toURL(), new ChromeOptions().setExperimentalOption("prefs", prefs));		
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
