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

public class LoginWithIncorrectCredentials extends GenericTest {

	@Test
	public void testUserCanNotLoginWithIncorrectCredentials() {

		LoginPage incorrectUserCredentialsLogin = openLoginPage().fillInUserCredentials("standard_user1",
				"secret_sauce1");

		Assert.assertTrue(
				incorrectUserCredentialsLogin.getErrorMessage()
						.equals("Epic sadface: Username and password do not match any user in this service"),
				"Error message for login with incorrect credentials should be 'Epic sadface: Username and password do not match any user in this service' + but found ["
						+ incorrectUserCredentialsLogin.getErrorMessage() + "] ");

	}

}
