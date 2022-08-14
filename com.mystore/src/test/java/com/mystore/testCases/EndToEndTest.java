/**
 * 
 */
package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.AddressPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
import com.mystore.pageObjects.OrderConfirmationPage;
import com.mystore.pageObjects.OrderPage;
import com.mystore.pageObjects.OrderSummaryPage;
import com.mystore.pageObjects.PaymentPage;
import com.mystore.pageObjects.SearchResultPage;
import com.mystore.pageObjects.ShippingPage;
import com.mystore.Base.BaseClass;

/**
 * @author 1274
 *
 */
public class EndToEndTest extends BaseClass {
	IndexPage index;
	SearchResultPage searchresultpage;
	AddToCartPage  addtocartpage;
	OrderPage order;
	LoginPage login;
	AddressPage address;
	ShippingPage shipping;
	PaymentPage payment;
	OrderSummaryPage ordersummary;
	OrderConfirmationPage orderconfirm;
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
	@Test(groups="regression")
	public void endToEnd() throws Exception
	{
		index=new IndexPage();
		searchresultpage=index.searchProduct("dresses");

		addtocartpage=searchresultpage.clickOnProduct();
		
		addtocartpage.selectQuantity("2");
		
		addtocartpage.selectSize("M");
		
		addtocartpage.clickOnAddToCart();
		
		order=addtocartpage.clickOnCheckOut();
		
		login=order.clickOnProceedToCheckOut();
	
		address=login.loginMethod2(prop.getProperty("username"),prop.getProperty("password"));
		shipping=address.clickonProceedoCheckout();
		shipping.agreeTremsAndCondition();
		payment=shipping.clickProceedtoCheckout();
		ordersummary=payment.clickOnPaymentMethod();
		orderconfirm=ordersummary.clickOnConfirmOrder();
		String actuslmessage=orderconfirm.validateConfirmMessage();
		String expectedmessage="Your order on My Store is complete.";
		Assert.assertEquals(actuslmessage,expectedmessage);
		
	    }
}
