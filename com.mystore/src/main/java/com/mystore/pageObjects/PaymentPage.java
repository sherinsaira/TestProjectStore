package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actionDrivers.Action;

public class PaymentPage extends BaseClass {
@FindBy(xpath="//p[@class='payment_module']/a[@class='bankwire']")
WebElement paymentBankwire;

@FindBy(xpath="//p[@class='payment_module']/a[@class='cheque']")
WebElement paymentCheque;

public PaymentPage()
{
	PageFactory.initElements(driver,this);
}

public OrderSummaryPage clickOnPaymentMethod() throws InterruptedException
{
	Action.click(driver, paymentBankwire);
	Thread.sleep(5000);
	return new OrderSummaryPage();
}




}
