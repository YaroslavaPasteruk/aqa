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

public class LoginTest {
	private WebDriver driver = null;

	@Test
	public void testUserIsAbleToLoginIntoApp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers"
				+ File.separator + "chromedriver_win32" + File.separator + "chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();

		WebElement el = driver.findElement(By.id("shopping_cart_container"));

		SoftAssert soft = new SoftAssert();

		soft.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"),
				"Current URL after login should be 'https://www.saucedemo.com/inventory.html' + but found ["
						+ driver.getCurrentUrl() + "] ");
		soft.assertTrue(el.isDisplayed());
		soft.assertAll();

//		String currentUrl = driver.getCurrentUrl();
//		if (currentUrl.contentEquals("https://www.saucedemo.com/inventory.html")) {
//			System.out.println("User is loged in and redirected to " + currentUrl);
//		}

	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}
