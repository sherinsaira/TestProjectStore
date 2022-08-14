package com.mystore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actionDrivers.Action;

public class IndexPage extends BaseClass {
@FindBy(xpath="//a[@class='login']")
WebElement signInBtn;

@FindBy(xpath="//img[@class='logo img-responsive']")
WebElement myStoreLogo;

@FindBy(id="search_query_top")
WebElement searchBox;


@FindBy(xpath="//button[@name='submit_search']")
WebElement searchButton;

public IndexPage()
{
	PageFactory.initElements(driver,this);
	
}
public LoginPage clickSignIn()
{    Action.fluentWait(driver,signInBtn,7);
	Action.click(driver,signInBtn);
	return new LoginPage();
}
public boolean validateLogo()
{
	return Action.isDisplayed(driver, myStoreLogo);
}

public String getStoreTitle()
{
	String mystoreTitle=(driver).getTitle();
	return mystoreTitle;
}

public SearchResultPage searchProduct(String productname) throws InterruptedException
{
	Action.type(searchBox,productname);

	Action.click(driver,searchButton);
	 Thread.sleep(10000);
	return new SearchResultPage();
}

}
