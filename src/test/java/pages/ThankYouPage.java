package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage {
	private WebDriver pageDriver;

	public ThankYouPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.pageDriver = driver;
	}

	@FindBy(css = "div.subheader")
	private WebElement finishHeader;

	public boolean isCheckoutSeccessfull() {
		try {
			return finishHeader.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
