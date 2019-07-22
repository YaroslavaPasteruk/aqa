package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductsPage;
import pages.ThankYouPage;
import pages.YourCartPage;

public class OneProduct extends GenericTest {

	@Test
	public void testUserIsAbleToByAProduct() {

		openLoginPage().fillInUserCredentials("standard_user", "secret_sauce").addProductToCart("Sauce Labs Backpack")
				.yourCartPageOpened().userIsRedirectedToCheckOutFirstStep().enterPersonalData("John", "Dou", "12345")
				.checkoutSuccessfull();

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html",
				"Checkout of one product successfuly finished");

	}

}
