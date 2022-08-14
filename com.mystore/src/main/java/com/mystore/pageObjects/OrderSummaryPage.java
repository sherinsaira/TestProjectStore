package com.mystore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actionDrivers.Action;

public class OrderSummaryPage extends BaseClass {
//@FindBy(xpath="//*[@id=\"cart_navigation\"]/button/span")
WebElement orderConfirmation=(driver).findElement(By.xpath("//span[contains(text(),'confirm')]"));


public OrderSummaryPage()
{
	PageFactory.initElements(driver,this);
}

public OrderConfirmationPage clickOnConfirmOrder() throws Exception
{    Action.fluentWait(driver,orderConfirmation,10);

WebElement orderConfirmation=(driver).findElement(By.xpath("//span[contains(text(),'confirm')]"));	
Action.JSClick((WebDriver) driver,orderConfirmation);
Thread.sleep(5000);

	return new OrderConfirmationPage();
}
}
