package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutSecondStepPage {
	private WebDriver pageDriver;
	public CheckoutSecondStepPage(WebDriver driver) {
		this.pageDriver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[contains(text(),'FINISH')]")
	private WebElement finishButton;
	
	public ThankYouPage checkoutSuccessfull() {
		finishButton.click();
		return new ThankYouPage(pageDriver);
	
	}
}
