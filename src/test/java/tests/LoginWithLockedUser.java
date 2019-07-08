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

public class LoginWithLockedUser {
private WebDriver driver = null;
	
	@Test
	public void testLockedUserCanNotLogin() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers"
				+ File.separator + "chromedriver_win32" + File.separator + "chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		driver.findElement(By.xpath(".//*[text()='Sorry, this user has been locked out.']"));
		
		WebElement lockedUserError = driver.findElement(By.xpath(".//*[text()='Sorry, this user has been locked out.']"));
		
		Assert.assertTrue(lockedUserError.isDisplayed());
		Assert.assertEquals(lockedUserError.getText(), "Epic sadface: Sorry, this user has been locked out.");
	}
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}
