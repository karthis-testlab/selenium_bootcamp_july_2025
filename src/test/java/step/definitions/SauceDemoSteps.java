package step.definitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoSteps {
	
	private ChromeDriver driver;

	@Given("User want to purchase the sauce lab merchandise product on the offical cart site")
	public void user_want_to_purchase_the_sauce_lab_merchandise_product_on_the_offical_cart_site() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Given("Regitered user able to login with valid user credentials {string} and {string}")
	public void regitered_user_able_to_login_with_valid_user_credentials_and(String username, String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
	}

	@When("User want to purchase {string} product and add to the cart")
	public void user_want_to_purchase_product_and_add_to_the_cart(String productName) {
		List<WebElement> elements = driver.findElements(By.cssSelector("div.inventory_item_name"));
		String idValue = "add-to-cart-"+productName.toLowerCase().replace(" ", "-");
		for (WebElement element : elements) {
			if(element.getText().equals(productName)) {
				driver.findElement(By.id(idValue)).click();
				break;
			}
		}
	}

	@When("User confirm the added product and checkout the product to purchase with details")
	public void user_confirm_the_added_product_and_checkout_the_product_to_purchase_with_details() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("And User confirm the added product and checkout the product to purchase with details")
	public void and_user_confirm_the_added_product_and_checkout_the_product_to_purchase_with_details() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}