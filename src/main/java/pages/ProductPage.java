package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ActionHelpers;

public class ProductPage {
	
	ActionHelpers actionHP;

	@FindBy(id = "pincode") private WebElement pincode_txt;
	@FindBy(id = "check-pincode") private WebElement checkPincode_btn;
	@FindBy(id = "pincode-result") private WebElement deliveryStatus_msg;
	@FindBy(id = "qty-plus") private WebElement qtyPlus_btn;
	@FindBy(id = "add-to-cart") private WebElement addToCart_btn;
	@FindBy(id = "buy-now") private WebElement buyNow_btn;
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		actionHP = new ActionHelpers();
	}
	
	public boolean checkPincode(String pincode)
	{
		actionHP.enterText(pincode_txt, pincode);
		actionHP.clickOnElement(checkPincode_btn);
		
		if(actionHP.fetchElementText(deliveryStatus_msg).contains("available"))
			return true;
		else
			return false;
	}
	
	public void clickQuantityPlus()
	{
		actionHP.clickOnElement(qtyPlus_btn);
	}
	
	public void clickAddToCart()
	{
		actionHP.clickOnElement(addToCart_btn);
	}
	
	public void clickBuyNow()
	{
		actionHP.clickOnElement(buyNow_btn);
	}
}
