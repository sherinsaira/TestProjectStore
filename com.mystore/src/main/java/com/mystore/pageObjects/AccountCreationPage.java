package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actionDrivers.Action;

public class AccountCreationPage extends BaseClass {

	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement formtitle;
	
	
	public AccountCreationPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public  boolean validateAccountCreatePage()
	{
		return Action.isDisplayed(driver, formtitle);
	}
}
