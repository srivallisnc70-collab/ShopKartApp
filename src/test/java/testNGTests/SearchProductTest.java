package testNGTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.BaseClass;

public class SearchProductTest extends BaseClass {

	@Test(dataProvider = "searchKeys")
	public void productSearchTest(String key)
	{
		home.enterSearchText(key);
		home.clickSerachBTN();
		
		Assert.assertTrue(home.isItemPresent(key));
	}
	
	@DataProvider
	public Object[][] searchKeys()
	{
		Object[][] obj = new Object[3][1];
		
		obj[0][0] = "webcam";
		
		obj[1][0] = "ceiling fan";
		
		obj[2][0] = "@#$%";
		
		return obj;
	}
}
