package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class ThreeProductsCheckout extends GenericTest {
	@Test

	public void userIsAbleToByFewProducts() {
		openLoginPage().fillInUserCredentials("standard_user", "secret_sauce")
				.addProductToCart("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt")
				.yourCartPageOpened().userIsRedirectedToCheckOutFirstStep().enterPersonalData("John", "Dou", "12345")
				.checkoutSuccessfull();

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html",
				"Checkout of one product successfuly finished");
	}

}
