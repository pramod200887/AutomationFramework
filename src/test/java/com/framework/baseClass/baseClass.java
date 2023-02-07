package com.framework.baseClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
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
	public void setup() throws IOException, InterruptedException
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
			driver.findElement(By.xpath(loc.getProperty("SignIn_Link"))).click(); // Locators also can be placed at different place for the ease of changes
			driver.findElement(By.xpath(loc.getProperty("Username"))).sendKeys("pramod11112021@gmail.com");//can be taken from files
			driver.findElement(By.xpath(loc.getProperty("NextButton"))).click(); //can be taken from files
			Thread.sleep(3000);
			driver.findElement(By.xpath(loc.getProperty("Password"))).sendKeys("Zoho@2022@1234");
			driver.findElement(By.xpath(loc.getProperty("SignIn_Login"))).click();
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
