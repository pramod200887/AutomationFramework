package com.framework.baseClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader lr;
	
	@BeforeTest
	public void setup() throws IOException
	{
		if(driver==null)
		{
			
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\ConfigFiles\\config.properties");
			FileReader lr = new FileReader(System.getProperty("user.dir")+"\\ConfigFiles\\locators.properties");
			prop.load(fr);
			loc.load(lr);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
		}
		
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			driver.get(prop.getProperty("testurl"));
		}
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		System.out.println("Base Class executed!!");
		
	}
}
