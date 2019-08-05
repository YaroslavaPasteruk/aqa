package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;

public class LoginLogout extends GenericTest {
//
//	@Test
//	public void testUserLoginLogout() {
//		LoginPage loginPage = openLoginPage().fillInUserCredentials("standard_user", "secret_sauce").isBurgerMenuOpened()
//				.isUserLoggedOut();
//
////		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	
//		
//		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/index.html");
//	
//	}
}
