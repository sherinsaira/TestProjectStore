/**
 * 
 */
package com.mystore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actionDrivers.Action;

/**
 * @author 1274
 *
 */
public class OrderPage extends BaseClass{
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	WebElement unitPrice;
	
	@FindBy(id="total_price")
	WebElement totalPrice;
	
	@FindBy(xpath="//*[@id=\\\"center_column\\\"]/p[2]/a[1]/span")
	WebElement proceedtoCheckoutButton;
	
	public OrderPage()
	{
		PageFactory.initElements(driver,this);
		
	}
	public double getUnitPrice()
	{
	String unit=unitPrice.getText();
	String uni=unit.replaceAll("[^a-zA-Z0-9]","");
	Double final_unitprice=Double.parseDouble(uni);
	return final_unitprice/100;
	}

	
	public double getTotalPrice()
	{
	String total=totalPrice.getText();
	String to=total.replaceAll("[^a-zA-Z0-9]","");
	Double final_totalprice=Double.parseDouble(to);
	return final_totalprice/100;
	}
	
	public LoginPage clickOnProceedToCheckOut() throws Exception
	{
		Action.fluentWait(driver, proceedtoCheckoutButton,10);
		
				WebElement proceedtoCheckoutButton=(driver).findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));	
				Actions action=new Actions(driver);
				action.moveToElement(proceedtoCheckoutButton).click().perform();
				Thread.sleep(7000);
			
		return new LoginPage();
	}

}
