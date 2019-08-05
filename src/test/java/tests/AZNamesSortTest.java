package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;

import pages.ProductsPage;

public class AZNamesSortTest extends GenericTest{
	@Test
	public void testProductsAreSortedInASCByName() {
		ProductsPage productsPage = openLoginPage().loginAs("standard_user", "secret_sauce").sortByNameASC();
		List<String> names = productsPage.getProductsNames();
		
		Assert.assertTrue(Ordering.natural().isOrdered(names));
		
		
}
}
