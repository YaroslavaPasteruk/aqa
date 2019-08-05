package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import app.WebApp;
import io.qameta.allure.Step;

public class LoginPage {
	private WebDriver pageDriver;
	
	public LoginPage() {
		this.pageDriver = WebApp.getBrowser();
		PageFactory.initElements(pageDriver, this);
	}
	
	
	@FindBy(id = "user-name")
	private WebElement userNameInput;
	
	@FindBy(id = "password")
	private WebElement passwordInput;
	
	@FindBy(css = "input[value='LOGIN']")
	private WebElement loginButton;
	
	@FindBy(css = "h3[data-test='error']")
	private WebElement errorCrossButton;
	
	@Step("Login as with user name [{0}] and password [{1}]")
	public ProductsPage loginAs(String userName, String password) {
		fillInUserCredentials(userName, password);
		return new ProductsPage(pageDriver);
		
	}
	public LoginPage fillInUserCredentials(String userName, String password) {
		userNameInput.sendKeys(userName);
		passwordInput.sendKeys(password);
		loginButton.click();
		return new LoginPage();
		
	}
	public String getErrorMessage() {
		String errorCrossButtonMessage = errorCrossButton.getText();
		return errorCrossButtonMessage;
		

	}

}
