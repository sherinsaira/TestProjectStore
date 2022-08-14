package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actionDrivers.Action;

public class HomePage extends BaseClass {

	
	@FindBy(xpath="//i[@class=\"icon-heart\"]/following-sibling::span[text()='My wishlists']")
	WebElement wishlist;
	
	
	@FindBy(xpath="//a[@title='Orders']/span[text()='Order history and details']")
	WebElement orderhistory;
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean validateMyWishlist()
	
	{
		Action.fluentWait( driver,wishlist, 4);
		return Action.isDisplayed(driver,wishlist);
		
	}
	
	
	public boolean validateOrderHistory()
	{
		Action.fluentWait(driver,orderhistory,6);
		return Action.isDisplayed( driver, orderhistory);
	}
	
	public String getURL()
	{
		String url= driver.getCurrentUrl();
		return url;
	}
}
