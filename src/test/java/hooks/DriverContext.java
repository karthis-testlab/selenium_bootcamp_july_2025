package hooks;

import org.openqa.selenium.WebDriver;

public class DriverContext {
	
	private WebDriver driver;	

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}