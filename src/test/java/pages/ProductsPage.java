package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.collect.Ordering;

import app.WebApp;

public class ProductsPage extends HeaderMenuPage {
	private WebDriver pageDriver;

	public ProductsPage() {
		this.pageDriver = WebApp.getBrowser();
	}

	@FindBy(id = "shopping_cart_container")
	private WebElement shoppingCartIcon;

	@FindBy(css = "div.inventory_item_name")
	private List<WebElement> productNames;

	@FindBy(css = "div.inventory_item_price")
	private List<WebElement> productPrices;

	@FindBy(css = "select.product_sort_container")
	private WebElement sortingDropdown;

	@FindBy(css = "option[value='az']")
	private WebElement namesASCSortingOption;

	@FindBy(css = "option[value='za']")
	private WebElement namesDESCSortingOption;

	@FindBy(css = "option[value='lohi']")
	private WebElement pricesASCSortingOption;

	@FindBy(css = "option[value='hilo']")
	private WebElement pricesDESCSortingOption;

	public boolean isUserLoggedIn() {
		try {
			return shoppingCartIcon.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;

		}

	}

	public YourCartPage yourCartPageOpened() {
		shoppingCartIcon.click();
		return new YourCartPage(pageDriver);
	}

	public ProductsPage addProductToCart(String... productNames) {
		for (int i = 0; i < productNames.length; i++) {
			pageDriver.findElement(By.xpath("//*[@class=\"inventory_item\"]//div[contains(text(),'" + productNames[i]
					+ "')]//ancestor::div[@class=\"inventory_item\"]//button")).click();
		}
		return new ProductsPage();
	}

	public List<String> getProductsNames() {
		List<String> names = new ArrayList<>();
		for (int i = 0; i < productNames.size(); i++) {
			String productName = productNames.get(i).getText();
			names.add(productName);
		}
		return names;

	}

	public List<Double> getProductPrices() {
		List<Double> prices = new ArrayList<>();
		for (int i = 0; i < productPrices.size(); i++) {
			String productPrice = productPrices.get(i).getText();
			double price = Double.parseDouble(productPrice.replace("$", ""));
			prices.add(price);
		}
		return prices;

	}

	public ProductsPage sortByNameASC() {
		Select select = new Select(sortingDropdown);
		select.selectByValue("az");
		return this;
	}

	public ProductsPage sortByNameDESC() {
		Select select = new Select(sortingDropdown);
		select.selectByValue("za");
		return this;
	}

	public ProductsPage sortByPriceASC() {
		Select select = new Select(sortingDropdown);
		select.selectByValue("lohi");
		return this;
	}

	public ProductsPage sortByPriceDESC() {
		Select select = new Select(sortingDropdown);
		select.selectByValue("hilo");
		return this;
	}
	public boolean isErrorShown(){
		return false;
	}


}
