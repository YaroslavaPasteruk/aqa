package tests;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends GenericTest {

	@Test
	public void testUserIsAbleToLoginIntoApp() {
//
//		driver.findElement(By.id("user-name")).sendKeys("standard_user");
//		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		
//		LoginPage loginPage = openLoginPage();
		openLoginPage().loginAs("standard_user", "secret_sauce")
				.addProductToCart("Sauce Labs Backpack", "Sauce Labs Bike Light");
		System.out.println("HERE");
		
//		ProductsPage productsPage = new ProductsPage(driver);
		
//		Assert.assertTrue(loginPage.isErrorShown(), 
//				"User should be logged into app after entering correct credentials");

//		WebElement el = driver.findElement(By.id("shopping_cart_container"));

//		SoftAssert soft = new SoftAssert();
//
//		soft.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"),
//				"Current URL after login should be 'https://www.saucedemo.com/inventory.html' + but found ["
//						+ driver.getCurrentUrl() + "] ");
//		soft.assertTrue(el.isDisplayed());
//		soft.assertAll();

//		String currentUrl = driver.getCurrentUrl();
//		if (currentUrl.contentEquals("https://www.saucedemo.com/inventory.html")) {
//			System.out.println("User is loged in and redirected to " + currentUrl);
//		}

	}

}
