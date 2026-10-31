package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ActionHelpers;

public class MyOrdersPage {

	ActionHelpers actionHP;
	
	@FindBy(id = "order-search") private WebElement orderSearch_txt;
	@FindBy(id = "order-filter") private WebElement allOrders_dropdown;
	@FindBy(xpath = "//div[@class=\"order-item\"]/a") private WebElement productName;
	@FindBy(xpath = "//div[@id='order-list']/descendant::b[@data-testid=\"order-card-id\"]") 
	private WebElement orderID;
	@FindBy(xpath = "//div[@id='order-list']/descendant::button[@data-testid=\"cancel-order\"]")
	private WebElement cancelOrder_btn;
	
	public MyOrdersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		actionHP = new ActionHelpers();
	}
	
	public void searchOrderByID(String orderID)
	{
		actionHP.enterText(orderSearch_txt, orderID);
	}
	
	public boolean confirmProductName(String name)
	{
		String product = actionHP.fetchElementText(productName).toLowerCase();
		if(product.contains(name))
			return true;
		else
			return false;
	}
}
