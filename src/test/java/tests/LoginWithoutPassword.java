package tests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LoginWithoutPassword {
	
private WebDriver driver = null;
	
	@Test
	public void testPasswordCanNotBeEmpty() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers"
				+ File.separator + "chromedriver_win32" + File.separator + "chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		driver.findElement(By.xpath(".//*[text()='Password is required']"));
		
		WebElement passwordError = driver.findElement(By.xpath(".//*[text()='Password is required']"));
		
		Assert.assertTrue(passwordError.isDisplayed());
		Assert.assertEquals(passwordError.getText(), "Epic sadface: Password is required");
	}
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}


}
