package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.Base.BaseClass;
import com.mystore.Utility.Log;
import com.mystore.dataProvider.DataProviders;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;

public class LoginPageTest extends BaseClass {
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
	
	@Test(dataProvider ="getData",groups= {"smoke","sanity"})
	public void loginTest(String uname,String pwd) throws InterruptedException
	{ 
		Log.startTestCase("--LOGIN TEST--");
		index=new IndexPage();
		Thread.sleep(3000);
		Log.info("User is going to click signin");
		login=index.clickSignIn();
		Thread.sleep(3000);
	//	home=login.loginMethod(prop.getProperty("username"),prop.getProperty("password"));
		home=login.loginMethod(uname,pwd);
		String actualURL=home.getURL();
		System.out.println("actual url"+actualURL);
		String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualURL,expectedURL);
		
	}
}
