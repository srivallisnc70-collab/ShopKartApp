package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ActionHelpers;

public class HomePage {
	
	ActionHelpers actionHP;
	
	@FindBy(xpath = "//a[text()='Home']") private WebElement HomeTab;
	@FindBy(xpath = "//a[text()='My Orders']") private WebElement MyOrdersTab;
	@FindBy(xpath = "//a[text()='Cart ']") private WebElement CartTab;
	@FindBy(xpath = "//a[text()='Login']") private WebElement LoginTab;
	
	@FindBy(id = "search-input") private WebElement search_txt;
	@FindBy(id = "search-button") private WebElement search_btn;
	@FindBy(id = "sort-by") private WebElement sortBy_dropdown;
	@FindBy(xpath = "//h3[@data-testid='card-name']") private List<WebElement> itemNames;
	@FindBy(id = "no-results") private WebElement noResult_msg;
	
	@FindBy(xpath = "//h4[text()='Category']/following-sibling::label") 
	private List<WebElement> category_checkboxes;
	
	@FindBy(xpath = "//h4[text()='Availability']/following-sibling::label") 
	private List<WebElement> availability_chekboxes;
	
	@FindBy(xpath = "//p[@class='brand-name']")
	private List<WebElement> categoryName;
	
	@FindBy(xpath = "//a[contains(@class,'product-card')]/descendant::p[@class='foot in']")
	private List<WebElement> productAvailability;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		actionHP = new ActionHelpers();
	}
	
	public void enterSearchText(String value)
	{
		actionHP.clearText(search_txt);
		actionHP.enterText(search_txt, value);
	}
	
	public void clickSerachBTN()
	{
		actionHP.clickOnElement(search_btn);
	}
	
	public boolean isItemPresent(String itemName)
	{
		
		for(WebElement item: itemNames)
		{
			String name = actionHP.fetchElementText(item).toLowerCase();
			if(name.contains(itemName))
				return true;
		}
		
		return false;
		
	}
	
	public void clickOnItem(String itemName)
	{
		for(WebElement item: itemNames)
		{
			String name = actionHP.fetchElementText(item).toLowerCase();
			if(name.contains(itemName))
			{
				actionHP.clickOnElement(item);
				break;
			}
		}
	}
	
	public void selectCategory(String categoryName)
	{
		for(WebElement category: category_checkboxes)
		{
			if(actionHP.fetchElementText(category).equalsIgnoreCase(categoryName))
			{
				actionHP.clickOnElement(category);
				break;
			}
		}
	}
	
	public void selectAvailability()
	{
		for(WebElement category: availability_chekboxes)
		{
			if(actionHP.fetchElementText(category).equalsIgnoreCase("In stock"))
			{
				actionHP.clickOnElement(category);
				break;
			}
		}
	}
	
	public boolean isCategoryFilterApplied(String name)
	{
		int count = 0;
		for(int i = 0; i < categoryName.size(); i++)
		{
			if(actionHP.fetchElementText(categoryName.get(i)).toLowerCase().contains(name))
			{
				count++;
			}
		}
		if (count == categoryName.size())
			return true;
		else
			return false;
	}
	
	public boolean isProductAvailable()
	{
		int count = 0;
		for(int i = 0; i < productAvailability.size(); i++)
		{
			if(actionHP.fetchElementText(productAvailability.get(i)).equalsIgnoreCase("In stock"))
			{
				count++;
			}
		}
		if (count == productAvailability.size())
			return true;
		else
			return false;
	}
	
	public void clickOnCartTab()
	{
		actionHP.clickOnElement(CartTab);
	}
}
