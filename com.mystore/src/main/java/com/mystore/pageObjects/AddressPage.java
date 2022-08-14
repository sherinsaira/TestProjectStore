package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actionDrivers.Action;

public class AddressPage extends BaseClass {
	@FindBy(xpath="//*[@id=\"center_column\"]/form/p/button/span")
	WebElement proceedtoCheckoutButton;
	
	
	public AddressPage()
	{
		PageFactory.initElements(driver,this);
	}
public ShippingPage clickonProceedoCheckout()

{
	Action.click(driver, proceedtoCheckoutButton);
	return new ShippingPage();
}
}
