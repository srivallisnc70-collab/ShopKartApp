package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.MyOrdersPage;
import pages.ProductPage;

public class BaseClass {
	protected WebDriver driver;
	protected BrowserConfig browser;
	protected PropertyFileReader property;
	protected ActionHelpers actionHP;
	
	protected HomePage home;
	protected ProductPage product;
	protected CheckoutPage checkout;
	protected CartPage cart;
	protected MyOrdersPage myOrders;
	
	public static WebDriver sdriver;
	
	@BeforeClass
	public void classconfig()
	{
		browser = new BrowserConfig();
		actionHP = new ActionHelpers();
		property = new PropertyFileReader();
		
		property.propertyInit("./src/test/resources/Config.properties");
		
		driver = browser.launchBrowser("chrome");
		actionHP.navigateToApp(property.fetchProperty("url"), driver);
		
		sdriver = driver;
		
	}
	
	@BeforeMethod
	public void methodCofig()
	{
		home = new HomePage(driver);
		product = new ProductPage(driver);
		checkout = new CheckoutPage(driver);
		cart = new CartPage(driver);
		myOrders = new MyOrdersPage(driver);
		
	}
	
	@AfterMethod
	public void methodTeardown()
	{
		((JavascriptExecutor) driver).executeScript("window.localStorage.clear()");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@AfterClass
	public void classTeardown()
	{		
		actionHP.closeBrowser(driver);
	}

}
