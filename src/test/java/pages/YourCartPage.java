package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {
	private WebDriver pageDriver;
	public YourCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.pageDriver = driver;
	}
	
//	@FindBy(css = ".cart_footer> a")
//	private WebElement continueShoppingButton;
//	
//	
//	
//	public boolean isUserRedirectedToProductsPage() {
//		try {
//			return 
//		}
//	}
	
	@FindBy(css = ".btn_action")
	private WebElement checkoutButton;
	
	public boolean isUserRedirectedToYourCartPage() {
		try {
			return checkoutButton.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	public CheckoutFirstStepPage userIsRedirectedToCheckOutFirstStep() {
		checkoutButton.click();
		return new CheckoutFirstStepPage(pageDriver);
	}
	

}
