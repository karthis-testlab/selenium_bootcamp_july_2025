package com.selenium.page.chain.pattern.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.selenium.testng.script.demo.LocatorType;
import com.selenium.testng.script.demo.SeleniumBase;

public class InventoryPage extends SeleniumBase {
	
	public InventoryPage() {
		Assert.assertTrue(getCurrentPageUrl().contains("/inventory.html"));
	}
	
	public InventoryPage addTheFirstProductIntoTheCart() {
		List<WebElement> elements = driver.findElements(By.xpath(PropertiesHandler.getObject("InventoryPage", "inventorypage.firstproduct.xpath")));
		elements.get(0).click();
		return this;		
	}
	
	public CartPage clickCartIcon() {
		locateElement(LocatorType.CLASSNAME, PropertiesHandler.getObject("InventoryPage", "inventorypage.carticon.classname")).click();
		return new CartPage();
	}

}