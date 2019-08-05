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

public class LoginWithLockedUser extends GenericTest {

	@Test
	public void testLockedUserCanNotLogin() {
		LoginPage lockedUserLogin = openLoginPage().fillInUserCredentials("locked_out_user", "secret_sauce");

		Assert.assertTrue(
				lockedUserLogin.getErrorMessage().equals("Epic sadface: Sorry, this user has been locked out."),
				"Error message for login with locked User should be 'Epic sadface: Sorry, this user has been locked out' + but found ["
						+ lockedUserLogin.getErrorMessage() + "] ");

	}

}
