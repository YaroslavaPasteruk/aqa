package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;

import pages.ProductsPage;

public class ZANamesSortTest extends GenericTest {

	@Test
	public void testProductsAreSortedInDescByName() {
		ProductsPage productsPage = openLoginPage().loginAs("standard_user", "secret_sauce").sortByNameDESC();

		List<String> names = productsPage.getProductsNames();

		Assert.assertTrue(Ordering.natural().reverse().isOrdered(names));
	}

}
