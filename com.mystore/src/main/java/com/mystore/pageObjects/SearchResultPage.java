package com.mystore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.Base.BaseClass;
import com.mystore.actionDrivers.Action;

public class SearchResultPage extends BaseClass {
	// @FindBy(xpath="//a[@class='product_img_link']/img[@src='http://automationpractice.com/img/p/1/2/12-home_default.jpg']")
	// WebElement productResult=driver.findElement(By.);
	WebElement productResult=driver.findElement(By.xpath("//a[@class='product_img_link']/img[@src='http://automationpractice.com/img/p/1/2/12-home_default.jpg']"));
	 public void SearchResultPage()
	 {
		 PageFactory.initElements(driver,this);
	 }
public void isProductAvailable() throws InterruptedException
{  Thread.sleep(5000);
	
	
	System.out.println(productResult.isDisplayed());
	System.out.println(productResult.isEnabled());
}

public AddToCartPage clickOnProduct() throws InterruptedException
{    
    Thread.sleep(5000);
	productResult.click();
	return new AddToCartPage();
}
}
