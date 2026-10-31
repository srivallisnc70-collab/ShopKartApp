package testNGTests;

import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.BaseClass;

public class CheckoutTest extends BaseClass {
	
	@Test
	public void placeOrderTest()
	{
		home.enterSearchText("headset");
		home.clickSerachBTN();
		
		Assert.assertTrue(home.isItemPresent("headset"));
		
		home.clickOnItem("headset");
		
		product.clickBuyNow();
		
		Map<String, String> customerDetails = new HashMap<>();
		customerDetails.put("Full Name", "ABCDEFGHIJ");
		customerDetails.put("Mobile", "9876543210");
		customerDetails.put("Email", "abcdefghij@gmail.com");
		customerDetails.put("Address", "Kukatpally");
		customerDetails.put("City", "Hyderabad");
		customerDetails.put("State", "Telangana");
		customerDetails.put("Pincode", "500086");
		
		checkout.enterCustomerDetails(customerDetails);
		checkout.selectPaymentMethod("cod");
		checkout.clickTerms();
		checkout.clickConfirmOrder();
		Assert.assertTrue(checkout.isOrderPlacedMsgDisplayed());
		Assert.assertTrue(checkout.isCustomerNameDisplayedCorrectly(customerDetails.get("Full Name")));
		String orderID = checkout.fetchOrderID();
		checkout.clickViewMyOrders();
		
		myOrders.searchOrderByID(orderID);
		Assert.assertTrue(myOrders.confirmProductName("headset"));
		
	}

}
