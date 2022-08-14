package com.mystore.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.w3c.dom.DOMConfiguration;

import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.mystore.Utility.ExtendManager;
import com.mystore.actionDrivers.Action;
import com.mystore.dataProvider.DataProviders;
import com.sun.java.swing.plaf.windows.resources.windows;

import io.github.bonigarcia.wdm.WebDriverManager;
//import utils.ReadExcel;


public class BaseClass {
	
	
	public static Properties prop;
	public  static WebDriver driver;
	public  String ExcelFileName;
	
//	public static ChromeDriver driver;
	
@BeforeSuite(groups= {"smoke","sanity","regression"})
public void loadConfig()
{
	ExtendManager.setExtent();
	DOMConfigurator.configure("Log4j.xml");
	try {
		prop=new Properties();
		FileInputStream io=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
		prop.load(io);
	}catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}catch(IOException ioe)
	{
		ioe.printStackTrace();
	}
}


public void launchApp(String browsername)
{
	WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	
	//String browsername=prop.getProperty("browser");
	if(browsername.contains("chrome"))
	{
	  driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
	}
	else if(browsername.contains("firefox"))
	{
		
		driver=new FirefoxDriver();


driver.manage().window().maximize();
	}
	
Action.implicitWait((WebDriver) driver,10);
Action.pageLoadTimeOut((WebDriver) driver,20);
driver.get(prop.getProperty("url"));

}
@AfterSuite
public void afterSuite()
{
	
	ExtendManager.endReport();

}
@DataProvider(name="getData")
public String[][] fetchData() throws IOException
{
	return DataProviders.readData(ExcelFileName);
}


public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
	// TODO Auto-generated method stub
	
}
}
