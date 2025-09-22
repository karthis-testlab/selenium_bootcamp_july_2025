package pico.steps.def;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoSteps {
	
	private WebDriver driver;
	
	public SauceDemoSteps(WebDriver driver) {
		this.driver = driver;
	}

	@Given("User want to purchase the sauce lab merchandise product on the offical cart site")
	public void user_want_to_purchase_the_sauce_lab_merchandise_product_on_the_offical_cart_site() {
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
	public void user_confirm_the_added_product_and_checkout_the_product_to_purchase_with_details(DataTable dataTable) {
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("checkout")).click();
	    List<WebElement> elements = driver.findElements(By.cssSelector(".checkout_info > div > input"));
		List<Map<String, String>> asMaps = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> map : asMaps) {
			elements.get(0).sendKeys(map.get("firstName"));
			elements.get(1).sendKeys(map.get("lastName"));
			elements.get(2).sendKeys(map.get("postalCode"));
		}
		driver.findElement(By.id("continue")).click();
	}
	
	@Then("User able to validate and confirm the added product is correct one or not")
	public void user_able_to_validate_and_confirm_the_added_product_is_correct_one_or_not(DataTable dataTable) {
	    List<Map<String, String>> asMaps = dataTable.asMaps();
	    for (Map<String, String> map : asMaps) {
			assertEquals(driver.findElement(By.className("inventory_item_name")).getText(), map.get("productName"));
		}
	}
	
	@When("User want to the multiple products {string} purchase and add to the cart")
	public void user_want_to_the_multiple_products_purchase_and_add_to_the_cart(String productName) {
		List<WebElement> elements = driver.findElements(By.cssSelector("div.inventory_item_name"));
		String idValue = "add-to-cart-"+productName.toLowerCase().replace(" ", "-");
		for (WebElement element : elements) {
			if(element.getText().equals(productName)) {
				driver.findElement(By.id(idValue)).click();
				break;
			}
		}
	}
	

}