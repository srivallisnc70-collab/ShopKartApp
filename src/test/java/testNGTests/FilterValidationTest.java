package testNGTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.BaseClass;

public class FilterValidationTest extends BaseClass {

	
	@Test
	public void applyFiltersTest()
	{
		home.selectCategory("Books");
		home.selectAvailability();
		
		Assert.assertTrue(home.isCategoryFilterApplied("books"));
		Assert.assertTrue(home.isProductAvailable());
	}
}
