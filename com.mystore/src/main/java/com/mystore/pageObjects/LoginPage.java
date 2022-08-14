package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actionDrivers.Action;

public class LoginPage extends BaseClass {

	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement signinButton;
	
	
	@FindBy(id="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(id="SubmitCreate")
	WebElement createNewAccountButton;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	
	
	public HomePage loginMethod(String uname,String pwd)
	{    Action.fluentWait(driver,username,10);
		Action.type(username,uname);
		
		Action.type(password, pwd);
		
		Action.click(driver,signinButton);
		return new HomePage();
	}
	
	public AddressPage loginMethod2(String uname,String pwd)
	{
		Action.fluentWait(driver,username,10);
		Action.type(username,uname);
		Action.type(password, pwd);
		Action.click(driver,signinButton);
		return new AddressPage();
	}
	
	public AccountCreationPage createNew(String newemail)
	{
		Action.type(emailForNewAccount,newemail);
		Action.click(driver, createNewAccountButton);
		return new AccountCreationPage();
	}
}
