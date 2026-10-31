package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ActionHelpers;

public class CheckoutPage {

	ActionHelpers actionHP;
	
	@FindBy(id = "full-name") private WebElement fullName_txt;
	@FindBy(id = "mobile") private WebElement mobile_txt;
	@FindBy(id = "email") private WebElement email_txt;
	@FindBy(id = "address") private WebElement address_txt;
	@FindBy(id = "city") private WebElement city_txt;
	@FindBy(id = "state") private WebElement state_dropdown;
	@FindBy(id = "zip") private WebElement pincode_txt;
	
	@FindBy(xpath = "//h3[text()='Payment method']/following-sibling::label/input[@type='radio']") 
	private List<WebElement> paymentMethod_radiobtns;
	
	@FindBy(id = "terms") private WebElement terms_checkbox;
	@FindBy(id = "confirm-order") private WebElement confirmOrder_btn;
	@FindBy(xpath = "//a[@href=\"cart.html\"]") private WebElement backToCart_btn;
	
	@FindBy(xpath = "//h1") private WebElement orderSuccess_msg;
	@FindBy(id = "order-customer") private WebElement customerName;
	@FindBy(id = "order-id") private WebElement orderID;
	@FindBy(id = "view-orders") private WebElement viewMyOrders_btn;
	@FindBy(id = "keep-shopping") private WebElement continueShopping_btn;
	
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		actionHP = new ActionHelpers();
	}
	
	public void enterCustomerDetails(Map<String, String> details)
	{
		actionHP.enterText(fullName_txt, details.get("Full Name"));
		actionHP.enterText(mobile_txt, details.get("Mobile"));
		actionHP.enterText(email_txt, details.get("Email"));
		actionHP.enterText(address_txt, details.get("Address"));
		actionHP.enterText(city_txt, details.get("City"));
		actionHP.selectOption(details.get("State"), state_dropdown);
		actionHP.enterText(pincode_txt, details.get("Pincode"));
	}
	
	public void selectPaymentMethod(String method)
	{
		for(WebElement radioBtn: paymentMethod_radiobtns)
		{
			if(actionHP.getElementAttribute(radioBtn, "value").equalsIgnoreCase(method))
			{
				actionHP.clickOnElement(radioBtn);
				break;
			}
		}
	}
	
	public void clickTerms()
	{
		actionHP.clickOnElement(terms_checkbox);
	}
	
	public void clickConfirmOrder()
	{
		actionHP.clickOnElement(confirmOrder_btn);
	}
	
	public boolean isOrderPlacedMsgDisplayed()
	{
		return orderSuccess_msg.isDisplayed();
	}
	
	public boolean isCustomerNameDisplayedCorrectly(String name)
	{
		String actualName = actionHP.fetchElementText(customerName);
		return actualName.equalsIgnoreCase(name)? true: false;
	}
	
	public String fetchOrderID()
	{
		return actionHP.fetchElementText(orderID);
	}
	
	public void clickViewMyOrders()
	{
		actionHP.clickOnElement(viewMyOrders_btn);
	}
}
