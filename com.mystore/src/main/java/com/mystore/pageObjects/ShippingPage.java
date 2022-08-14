package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actionDrivers.Action;

public class ShippingPage extends BaseClass {
@FindBy(id="cgv")
WebElement agreeterm;

@FindBy(xpath="//*[@id=\"form\"]/p/button/span")
WebElement proceedToCheckoutButton;


public ShippingPage()
{
	PageFactory.initElements(driver,this);
}


public void agreeTremsAndCondition() {
	Action.click((WebDriver) driver, agreeterm);
}
public PaymentPage clickProceedtoCheckout()
{
	Action.click(driver,proceedToCheckoutButton);
	return new PaymentPage();
}
}
