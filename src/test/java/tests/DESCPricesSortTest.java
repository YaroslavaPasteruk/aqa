package tests;

import java.util.List;

import org.testng.Assert;

import com.google.common.collect.Ordering;

import pages.ProductsPage;

public class DESCPricesSortTest extends GenericTest{
	public void testProductsAreSortedInDESCPrice() {
		ProductsPage productsPage = openLoginPage().loginAs("standard_user", "secret_sauce")
				.sortByPriceDESC();
		List<Double> prices = productsPage.getProductPrices();
		Assert.assertTrue(Ordering.natural().reverse().isOrdered(prices));
	}
	

}
