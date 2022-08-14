package com.mystore.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.Base.BaseClass;
import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.OrderPage;
import com.mystore.pageObjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	IndexPage index;
	SearchResultPage searchresultpage;
	AddToCartPage  addtocartpage;
	OrderPage order;
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
	@Test(groups="regression")
	public void verifyTotalPrice() throws Exception
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
		order=addtocartpage.clickOnCheckOut();

		Double unitprice=order.getUnitPrice();
		Double totalprice=order.getTotalPrice();
		Double totalexpectedprice=(unitprice*2)+2;
	}
}
