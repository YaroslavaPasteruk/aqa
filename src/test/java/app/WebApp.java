package app;

import org.openqa.selenium.WebDriver;

import tools.BrowserFactory;

public class WebApp {
	
	private static ThreadLocal<BrowserFactory> instanceApp;
	
	private static ThreadLocal<BrowserFactory> getInstanceApp(){
		if (instanceApp != null) {
			return instanceApp;
		} else {
			instanceApp = new ThreadLocal<BrowserFactory>() {
				@Override
				public BrowserFactory initialValue() {
					return new BrowserFactory();
				}
			};
			return instanceApp;
		}
	}
	
	public static WebDriver getBrowser() {
		return getInstanceApp().get().getWebDriver();
	}
	
	public static void closeBrowser() {
		getInstanceApp().get().closeDriver();;
	}

}
