package tools;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	private WebDriver driver;

	public static final String BROWSER = "Chrome";

	public WebDriver getWebDriver() {
		if (driver != null) {
			return driver;
		} else {
			this.driver = getBrowser();
			return driver;
		}
	}
	
	public void closeDriver() {
		try {
			if(driver != null) {
				driver.quit();
			}
		} finally {
			driver = null;
		}
	}

	public String getOSName() {
		String osName = System.getProperty("os.name");

		if (osName.contains("MacOS")) {
			return "macOS";
		} else if (osName.contains("Windows")) {
			return "windows";
		} else if (osName.contains("Linux")) {
			return "linux";
		} else {
			throw new IllegalStateException("Unknown OS name, please fix it");
		}

	}

	public WebDriver getBrowser() {
		String browserType = getBrowserType().toLowerCase();

		switch (browserType) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "drivers" + File.separator + getOSName()
							+ File.separator + browserType + File.separator + "chromedriver_win32" + File.separator
							+ "chromedriver.exe");
			return new ChromeDriver();

		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + File.separator + "drivers" + File.separator + getOSName()
							+ File.separator + browserType + File.separator + "geckodriver-v0.24.0-win64"
							+ File.separator + "geckodriver.exe");
			return new FirefoxDriver();
		case "edge":
			if (getOSName().contains("MacOS") || getOSName().contains("Linux")) {
				throw new IllegalStateException("Edge browser is unsupported for " + getOSName());
			}
			System.setProperty("webdriver.edge.driver",

					System.getProperty("user.dir") + File.separator + "drivers" + File.separator + getOSName()
							+ File.separator + browserType + File.separator + "MicrosoftWebDriver.exe");
			return new EdgeDriver();
		case "safari":
			if (getOSName().contains("Windows") || getOSName().contains("Linux")) {
				throw new IllegalStateException("Safari browser is unsupported for " + getOSName());
			}
		default:
			throw new IllegalStateException("Unsupported browser");
		}

	}

	public String getBrowserType() {
		String browser = System.getProperty("browser");
		if (browser == null) {
			return BROWSER;

		} else {
			return browser;
		}
	}
}