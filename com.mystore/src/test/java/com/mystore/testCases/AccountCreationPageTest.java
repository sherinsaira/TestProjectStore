package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.mystore.Base.BaseClass;
import com.mystore.pageObjects.AccountCreationPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	IndexPage index;
	LoginPage login;
	AccountCreationPage accountcreate;
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
	@Test(groups="sanity")
	public void createAccountPage()
	{
		index=new IndexPage();
		login=index.clickSignIn();
		accountcreate=login.createNew("admin8@gmail.com");
		boolean result=accountcreate.validateAccountCreatePage();
		Assert.assertTrue(result);
	}

}
