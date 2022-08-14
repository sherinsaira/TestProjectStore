package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actionDrivers.Action;

public class OrderConfirmationPage extends BaseClass{
@FindBy(xpath="//p[@class='cheque-indent']//strong[text()='Your order on My Store is complete.']")
WebElement orderComplete;

public OrderConfirmationPage()
{
	PageFactory.initElements(driver,this);
}
public String validateConfirmMessage()
{
	String confirmMessage=orderComplete.getText();
	return confirmMessage;
	
}
}
