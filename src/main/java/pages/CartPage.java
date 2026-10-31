package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ActionHelpers;

public class CartPage {
	
	ActionHelpers actionHP;

	@FindBy(id = "continue-shopping") private WebElement continueShopping_btn;
	@FindBy(id = "clear-cart") private WebElement clearCart_btn;
	@FindBy(css = "input#coupon-code") private WebElement couponCode_txt;
	@FindBy(id = "apply-coupon") private WebElement applyCoupon_btn;
	@FindBy(id = "coupon-msg") private WebElement couponStatus_msg;
	@FindBy(id = "remove-coupon") private WebElement removeCoupon_btn;
	@FindBy(id = "place-order") private WebElement placeOrder_btn;
	@FindBy(id = "summary-total") private WebElement totalAmt;
	
	@FindBy(xpath = "//table[@id='cart-table']/tbody/tr")
	private List<WebElement> cartItems;

	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		actionHP = new ActionHelpers();
	}
	
	public boolean IsProductAddedToCart(String name)
	{
		for(WebElement product: cartItems)
		{
			WebElement productName = product.findElement(By.xpath("./td/a[@class='pname']"));
			String itemName = actionHP.fetchElementText(productName).toLowerCase();
			if(itemName.contains(name))
				return true;
		}
		return false;
	}
	
	public void clickClearCart()
	{
		actionHP.clickOnElement(clearCart_btn);
	}
}
