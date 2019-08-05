package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderMenuPage {
	protected WebDriver pageDriver;
	
	public HeaderMenuPage() {
		
	}
	
	public HeaderMenuPage(WebDriver driver) {
		this.pageDriver = driver;
		PageFactory.initElements(pageDriver, this);
		
	}
	
	@FindBy(css = "div.bm-burger-button button")
	private WebElement burgerMenuButton;
	
	@FindBy(id = "inventory_sidebar_link")
	private WebElement allProductsBurgerMenu;
	
	@FindBy(id = "about_sidebar_link")
	private WebElement aboutBurgerMenuButton;
	
	@FindBy(id = "logout_sidebar_link")
	private WebElement logOutButton;
	
	@FindBy(id = "reset_sidebar_link")
	private WebElement resetBurgerMnuButton;
	
	public HeaderMenuPage isBurgerMenuOpened() {
		WebDriverWait waiter = new WebDriverWait(pageDriver, 10);
		waiter.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.bm-burger-button button")));
		burgerMenuButton.click();
		return new HeaderMenuPage(pageDriver);
	}
	
	public LoginPage isUserLoggedOut() {
		WebDriverWait waiter = new WebDriverWait(pageDriver, 10);
		waiter.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
		logOutButton.click();
		return new LoginPage();
	}

}
