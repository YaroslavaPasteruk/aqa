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

public class LoginLogout {
	private WebDriver driver = null;
	
	

	@Test
	public void testUserLoginLogout() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers"
				+ File.separator + "chromedriver_win32" + File.separator + "chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		driver.findElement(By.cssSelector("div.bm-burger-button button")).click();
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
		
		driver.findElement(By.id("logout_sidebar_link")).click();
		driver.getCurrentUrl();

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/index.html");

	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
}
