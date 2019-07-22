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

public class LoginWithoutUserNameTest extends GenericTest{
	
	
	@Test
	public void testUserNameCanNotBeEmpty() {
		

//		driver.findElement(By.id("user-name")).sendKeys("");
//		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		
		LoginPage loginPage = openLoginPage().fillInUserCredentials("","secret_sauce");
//		loginPage.loginAs("", "secret_sauce");
		
		driver.findElement(By.xpath(".//*[text()='Username is required']"));
		
		WebElement userNameError = driver.findElement(By.xpath(".//*[text()='Username is required']"));
		
		Assert.assertTrue(loginPage.isErrorShown(), 
				"User should be logged into app after entering correct credentials");
		Assert.assertEquals(userNameError.getText(), "Epic sadface: Username is required");
	}
	
}
