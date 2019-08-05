package tests;

import java.io.File;

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

public class LoginWithoutUserNameTest extends GenericTest {

	@Test
	public void testUserNameCanNotBeEmpty() {

		LoginPage emptyUsernameLogin = openLoginPage().fillInUserCredentials("", "secret_sauce");

		Assert.assertTrue(emptyUsernameLogin.getErrorMessage().equals("Epic sadface: Username is required"),
				"Error message for login without Username should be 'Epic sadface: Username is required' + but found ["
						+ emptyUsernameLogin.getErrorMessage() + "] ");

	}

}
