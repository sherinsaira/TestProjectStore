package com.mystore.testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.Base.BaseClass;
import com.mystore.actionDrivers.Action;
import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.AddressPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass{
	IndexPage index;
	SearchResultPage searchresultpage;
	AddToCartPage  addtocartpage;
	@Parameters("chrome")
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setup(String browser)
	{
		launchApp(browser); 
	}
	@AfterMethod(groups= {"smoke","sanity","regression"})

	public void teardown()
	{
		driver.quit();
	}
	@Test(groups={"sanity","regression"})
	public void addToCartTest() throws InterruptedException
	{
		index=new IndexPage();
		searchresultpage=index.searchProduct("dresses");
		Thread.sleep(3000);
		addtocartpage=searchresultpage.clickOnProduct();
		Thread.sleep(3000);
		addtocartpage.selectQuantity("2");
		Thread.sleep(3000);
		addtocartpage.selectSize("M");
		Thread.sleep(3000);
		addtocartpage.clickOnAddToCart();
		Thread.sleep(3000);
		//boolean result=addtocartpage.validateAddtoCart();
		
		//xAssert.assertTrue(result);
	}
}
