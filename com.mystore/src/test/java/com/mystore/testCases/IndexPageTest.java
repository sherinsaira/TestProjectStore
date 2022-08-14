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
import com.mystore.pageObjects.IndexPage;

/**
 * @author Sherin Saira Titty
 *
 */
public class IndexPageTest extends BaseClass {
	IndexPage index;
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
public void verifyLogo()
{
	index=new IndexPage();
	boolean result=index.validateLogo();
	Assert.assertTrue(result);
}

@Test(groups="smoke")
public void verifyTitle()
{
	String acttitle=index.getStoreTitle();
	
	Assert.assertEquals(acttitle,"My Store");
	
}
}
