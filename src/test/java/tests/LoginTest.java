package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;

import app.WebApp;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import pages.ProductsPage;

public class LoginTest extends GenericTest {

	@Feature("Login")
	@Story("OCE-2259")
	@Issue("OCE-1596")
	@Test
	public void testUserIsAbleToLoginIntoApp() {

		ProductsPage productsPage = openLoginPage().loginAs("standard_user", "secret_sauce");

		Assert.assertTrue(WebApp.getBrowser().getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"),
				"Current URL after login should be 'https://www.saucedemo.com/inventory.html' + but found ["
						+ WebApp.getBrowser().getCurrentUrl() + "] ");

	}

}
