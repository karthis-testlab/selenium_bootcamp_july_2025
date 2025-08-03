package com.selenium.testng.script.demo;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBase {
	
	private static RemoteWebDriver driver;
	private static WebDriverWait wait;
	
	private static final Logger LOGGER = Logger.getLogger(SeleniumBase.class.getName());
	
	public static void launchChromeBrowser() {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.credentials_enable_service", false);
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		LOGGER.info("Chrome browser launched successfully.");
	}	
	
	public static void launchBrowser(String browser) {
		switch (browser.toUpperCase()) {
		case "CHROME":
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			driver = new FirefoxDriver();
			break;
		case "EDGE":
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Currently we're not support give "+browser+" broswer.");
		}
	}
	
	public static void maximize() {
		driver.manage().window().maximize();
		LOGGER.info("Launched browser was maximized.");
	}
	
	public static void launchAUTUrl(String url) {
		driver.get(url);
		LOGGER.info("Given "+url+" AUT URL was opened in the browser.");
	}
	
	public static WebElement locateElement(String locator) {
		LOGGER.info("Found the ID type"+locator+" locator");
		return driver.findElement(By.id(locator));		
	}
	
	public static void waitUnitElemenVisibilty(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static WebElement locateElement(LocatorType locatorType, String locator) {
		switch (locatorType) {
		case NAME:
			LOGGER.info("Found the NAME type"+locator+" locator");
			return driver.findElement(By.name(locator));
		case CLASSNAME:
			LOGGER.info("Found the CLASSNAME type"+locator+" locator");
			return driver.findElement(By.className(locator));
		case TAGNAME:
			LOGGER.info("Found the TAGNAME type"+locator+" locator");
			return driver.findElement(By.tagName(locator));
		case CSS:
			LOGGER.info("Found the CSS type"+locator+" locator");
			return driver.findElement(By.cssSelector(locator));
		case XPATH:
			LOGGER.info("Found the XPATH type"+locator+" locator");
			return driver.findElement(By.xpath(locator));
		default:
			return null;
		}
	}
	
	public static void jsClick(WebElement element) {		
		driver.executeScript("arguments[0].click();", element);
		LOGGER.info("Successfully clicked the "+element+" using javascript click action");
	}
	
	public static void type(WebElement element, String text) {
		element.sendKeys(text);
		LOGGER.info("Successfully typed the "+text+" in the given element "+element);
	}
	
	public static void click(WebElement element) {
		element.click();
		LOGGER.info("Successfully clicked the "+element+" using click method");
	}
	
	public static void browserClose() {		
		driver.close();
	}

	public static void browserQuit() {
		driver.quit();
	}
	
	public static String getDomText(WebElement element) {
		return element.getText();
	}

}