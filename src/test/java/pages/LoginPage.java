package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver pageDriver;
	
	public LoginPage(WebDriver driver) {
		this.pageDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "user-name")
	private WebElement userNameInput;
	
	@FindBy(id = "password")
	private WebElement passwordInput;
	
	@FindBy(css = "input[value='LOGIN']")
	private WebElement loginButton;
	
	public ProductsPage loginAs(String userName, String password) {
		fillInUserCredentials(userName, password);
		return new ProductsPage(pageDriver);
		
	}
	public ProductsPage fillInUserCredentials(String userName, String password) {
		userNameInput.sendKeys(userName);
		passwordInput.sendKeys(password);
		loginButton.click();
		return new ProductsPage(pageDriver);
		
	}
	public boolean isErrorShown(){
		return false;
	}

}
