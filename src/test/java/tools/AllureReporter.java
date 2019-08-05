package tools;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import app.WebApp;
import io.qameta.allure.Attachment;

public class AllureReporter {
	
	@Attachment(value = "{0}", type = "image/png")
	public static synchronized byte[] makeScreenshot(String name) {
		return TakesScreenshot.class.cast(WebApp.getBrowser()).getScreenshotAs(OutputType.BYTES);
	}

}
