package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;

import pages.ProductsPage;

public class ASCPricesSortTest extends GenericTest {

	@Test
	public void testProductsAreSortedInASCPrice() {
		ProductsPage productsPage = openLoginPage().loginAs("standard_user", "secret_sauce")
				.sortByPriceASC();
		List<Double> prices = productsPage.getProductPrices();
		Assert.assertTrue(Ordering.natural().isOrdered(prices));
	}

}
