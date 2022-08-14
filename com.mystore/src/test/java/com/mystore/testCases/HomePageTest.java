/**
 * 
 */
package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.Base.BaseClass;
import com.mystore.actionDrivers.Action;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;

/**
 * @author 1274
 *
 */
public class HomePageTest extends BaseClass{
	
	IndexPage index;
	LoginPage login;
	HomePage home;
	@Parameters("browser")
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
	@Test(groups="smoke")
	public void wishListTest()
	{
		index=new IndexPage();
		login=index.clickSignIn();
		home=login.loginMethod(prop.getProperty("username"),prop.getProperty("password"));
		Boolean result=home.validateMyWishlist();
		
		Assert.assertTrue(result);
	}
	
	@Test(groups="smoke")
	public void validateOrderHistory()
	{
		index=new IndexPage();
		login=index.clickSignIn();
		home=login.loginMethod(prop.getProperty("username"),prop.getProperty("password"));
		Boolean result1=home.validateOrderHistory();
		Assert.assertTrue(result1);
	}

}
