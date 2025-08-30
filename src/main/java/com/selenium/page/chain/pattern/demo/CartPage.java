package com.selenium.page.chain.pattern.demo;

import org.testng.Assert;

import com.selenium.testng.script.demo.SeleniumBase;

public class CartPage extends SeleniumBase {
	
	public CartPage() {
		Assert.assertTrue(getCurrentPageUrl().contains("/cart.html"));
	}

}