package tests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.LoginPage;

public class GenericTest {
	public WebDriver driver = null;

	
	public void getDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers"
				+ File.separator + "chromedriver_win32" + File.separator + "chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");

	}

	public LoginPage openLoginPage() {
		getDriver();
		return new LoginPage(driver);
	}

//	@AfterClass(alwaysRun = true)
//	public void closeBrowser() {
//		driver.quit();
//	}
}
