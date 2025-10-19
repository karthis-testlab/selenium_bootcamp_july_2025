package tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SauceDemoTest {

	RemoteWebDriver driver = null;
	Map<String, Object> prefs = new HashMap<String, Object>();
	WebDriverWait wait = null;

	@Parameters({ "gridUrl", "browser" })
	@BeforeMethod
	public void setUp(@Optional("http://localhost:4444/") String gridUrl, @Optional("chrome") String browserName) {
		switch (browserName.toUpperCase()) {
		case "CHROME":
			prefs.put("profile.password_manager_leak_detection", false);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("prefs", prefs);
			chromeOptions.addArguments("--start-maximized");
			try {
				driver = new RemoteWebDriver(new URI(gridUrl).toURL(), chromeOptions);
				wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			} catch (MalformedURLException | URISyntaxException e) {
				e.printStackTrace();
			}
			break;
		case "EDGE":
			prefs.put("profile.password_manager_leak_detection", false);
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setExperimentalOption("prefs", prefs);
			edgeOptions.addArguments("--start-maximized");
			try {
				driver = new RemoteWebDriver(new URI(gridUrl).toURL(), edgeOptions);
				wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			} catch (MalformedURLException | URISyntaxException e) {
				e.printStackTrace();
			}
			break;
		case "FIREFOX":
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.setPreference("signon.autofillForms", true);
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setProfile(firefoxProfile);			
			try {
				driver = new RemoteWebDriver(new URI(gridUrl).toURL(), firefoxOptions);
				wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				driver.manage().window().maximize();
			} catch (MalformedURLException | URISyntaxException e) {
				e.printStackTrace();
			}
			break;
		default:
			throw new RuntimeException("Given "+browserName+" browser was not supported by the framework.");
		}
	}

	@Test
	public void userShouldAbletoAddProductIntotheCart() {
		driver.get("https://www.saucedemo.com/");		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElements(By.xpath("//button[text()='Add to cart']")).getLast().click();
		String productName = driver.findElement(By.xpath("//button[text()='Remove']/../preceding-sibling::div/a")).getText();
		driver.findElement(By.className("shopping_cart_link")).click();
		Assert.assertEquals(driver.findElement(By.className("inventory_item_name")).getText(), productName);
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cart_item"))));
		driver.findElement(By.id("continue-shopping")).click();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link"))).click();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (!result.isSuccess()) {
			try {
				FileHandler.copy(driver.getScreenshotAs(OutputType.FILE),
						new File("./screenshots/" + result.getMethod().getMethodName() + ".png"));
			} catch (WebDriverException | IOException e) {
				e.printStackTrace();
			}
		}
		driver.quit();
	}

}