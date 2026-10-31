package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionHelpers {
		
	public void navigateToApp(String url, WebDriver driver)
	{
		driver.get(url);
	}
	
	public void enterText(WebElement element, String text)
	{
		element.sendKeys(text);
	}
	
	public void clickOnElement(WebElement element)
	{
		element.click();
	}

	public void mouseHover(WebElement element, WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}
	
	public void selectOption(WebElement dropdown, String value)
	{
		Select s = new Select(dropdown);
		s.selectByValue(value);
	}
	
	public void selectOption(String text, WebElement dropdown)
	{
		Select s = new Select(dropdown);
		s.selectByVisibleText(text);
	}
	
	public String fetchElementText(WebElement element)
	{
		return element.getText();
	}
	
	public void clearText(WebElement element)
	{
		element.clear();
	}
	
	public String getElementAttribute(WebElement element, String attributeName)
	{
		return element.getAttribute(attributeName);
	}
	
	public void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
