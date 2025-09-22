package pico.steps.def;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {

	private WebDriver driver;

	@BeforeAll
	public static void itShouldRunBeforeAllScenarios() {
		System.out.println("Run Before All Scenarios.");
	}

	@AfterAll
	public static void itShouldRunAfterAllScenarios() {
		System.out.println("Run After All Scenarios.");
	}

	@Before
	public void itShouldRunBeforeEachScenario() {
		setDriver();
	}

	@After
	public void itShouldRunAfterEachScenario(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("./" + scenario.getName() + ".png"));
			scenario.attach(takesScreenshot.getScreenshotAs(OutputType.BYTES), "image/png",
					"Attached Failed Scenario Snapshot.");
		}
		driver.quit();
		System.out.println("Run After Scenario.");
	}

	@BeforeStep
	public void itShouldRunBeforeEachScenarioStep() {
		System.out.println("Run Before Scenario Step.");
	}

	@AfterStep
	public void itShouldRunAfterEachScenarioStep() {
		System.out.println("Run After Scenario Step.");
	}

	public void setDriver() {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_leak_detection", false);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-infobars");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	public WebDriver getDriver() {
		return driver;
	}

}