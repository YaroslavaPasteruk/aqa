package tests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginWithoutPassword extends GenericTest{

	@Test
	public void testPasswordCanNotBeEmpty() {
		LoginPage emptyPasswordLogin = openLoginPage().fillInUserCredentials("standard_user", "");

		Assert.assertTrue(emptyPasswordLogin.getErrorMessage().equals("Epic sadface: Password is required"),
				"Error message for login without password should be 'Epic sadface: Password is required' + but found ["
						+ emptyPasswordLogin.getErrorMessage() + "] ");

	}

}
