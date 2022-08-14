package com.mystore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actionDrivers.Action;

public class AddToCartPage extends BaseClass{
//	@FindBy(id="quantity_wanted")
	WebElement quantity=driver.findElement(By.id("quantity_wanted"));
	
	//@FindBy(name="group_1")
	WebElement size= driver.findElement(By.id("group_1"));
	
//	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addtocart=driver.findElement(By.xpath("//span[text()='Add to cart']"));
	
	//@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	//WebElement addtocarmessage=driver.findElement(By.xpath(""));
	
	//@FindBy(xpath="//a[@class='btn btn-default button button-medium']/span[contains(text(),'Proceed to checkout')]")
	WebElement checkoutButton= driver.findElement(By.xpath("//span[contains(text(),'Proceed')]"));
	
	
	public void AddToCartPage()
	{
		PageFactory.initElements(driver,this);
	}

	
	public void selectQuantity(String num)
	{
		Action.type(quantity,num);
	}
	
	public void selectSize(String sizee)
	{
		Action.selectByVisibleText(sizee,size);
	}
	
	public void clickOnAddToCart()
	{Action.fluentWait((WebDriver) driver,addtocart,15);
		Action.click((WebDriver) driver, addtocart);
	}
	
	/*public boolean validateAddtoCart()
	
	{
		return Action.isDisplayed(driver, addtocarmessage);
	}*/
	
	public OrderPage clickOnCheckOut() throws Exception
	{
		
		Action.fluentWait( driver,checkoutButton,15);
		try {
		//Action.JSClick(driver,checkoutButton);
		}catch(StaleElementReferenceException s) 
		{
			WebElement checkoutButton=((WebDriver) driver).findElement(By.xpath("//span[contains(text(),'Proceed')]"));	
			Action.JSClick((WebDriver) driver,checkoutButton);
			Thread.sleep(5000);
		}
		
		return new OrderPage();
		
	}
}
