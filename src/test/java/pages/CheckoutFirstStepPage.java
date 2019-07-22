package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFirstStepPage {
	private WebDriver pageDriver;
	
	public CheckoutFirstStepPage(WebDriver driver) {
		this.pageDriver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "first-name")
	private WebElement firstNameField;
	
	@FindBy(id = "last-name")
	private WebElement lastNameField;
	
	@FindBy(id = "postal-code")
	private WebElement postalCodeField;
	
	@FindBy(css = "input.btn_primary.cart_button")
	private WebElement continueButton;
	
	public CheckoutSecondStepPage enterPersonalData(String firstName, String lastName, String postalCode) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		postalCodeField.sendKeys(postalCode);
		continueButton.click();
		return new CheckoutSecondStepPage(pageDriver);
	}
	
	

}
