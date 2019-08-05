package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import app.WebApp;
import io.qameta.allure.Step;
import pages.LoginPage;
import tools.AllureReporter;

public class GenericTest {
	
//	@Step("Get driver")
//	public void getDriver() {
////		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers"
////				+ File.separator + "chromedriver_win32" + File.separator + "chromedriver.exe");
//		this.driver = getBrowser();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("https://www.saucedemo.com/");
//		driver.manage().window().maximize();
//
//	}
	@Step("Open login page")
	public LoginPage openLoginPage() {
		
		WebDriver driver = WebApp.getBrowser();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		return new LoginPage();
	}

	
	@Step
	@AfterClass(alwaysRun = true)
	public void closeApp() {
		WebApp.closeBrowser();
	}
	@AfterMethod
	public void attachScreenshot() {
		AllureReporter.makeScreenshot("Screen");
		
	}
}
