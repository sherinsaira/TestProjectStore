package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.mystore.Base.BaseClass;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	IndexPage index;
	SearchResultPage searchresultpage;
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setup(String browser)
	{
		launchApp(browser); 
	}
	
	@Test(groups="smoke")
	public void productAvailabilityTest() throws InterruptedException
	{
		index=new IndexPage();
		Thread.sleep(3000);
		searchresultpage=index.searchProduct("dresses");
		Thread.sleep(3000);
		searchresultpage.isProductAvailable();
		
		
	}
	
}
