package testNGTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.BaseClass;

// Add to cart feature test
public class AddToCartTest extends BaseClass {

	@Test
	public void cartValidationTest()
	{
		home.enterSearchText("mouse");
		home.clickSerachBTN();
		
		Assert.assertTrue(home.isItemPresent("mouse"));
		
		home.clickOnItem("mouse");
		
		Assert.assertTrue(product.checkPincode("500086"));
		
		product.clickQuantityPlus();
		
		product.clickAddToCart();
		
		home.clickOnCartTab();
		
		Assert.assertTrue(cart.IsProductAddedToCart("mouse"));
		cart.clickClearCart();
		
	}
}
