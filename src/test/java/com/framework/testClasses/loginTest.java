package com.framework.testClasses;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.framework.baseClass.baseClass;

public class loginTest extends baseClass{

	@Test
	public static void loginTest() throws InterruptedException
	{
		System.out.println("We are here");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[@class='login']")).click();
	driver.findElement(By.xpath(loc.getProperty("SignIn_Link"))).click(); // Locators also can be placed at different place for the ease of changes
	driver.findElement(By.xpath(loc.getProperty("Username"))).sendKeys("pramod11112021@gmail.com");//can be taken from files
	driver.findElement(By.xpath(loc.getProperty("NextButton"))).click(); //can be taken from files
	Thread.sleep(3000);
	driver.findElement(By.xpath(loc.getProperty("Password"))).sendKeys("Zoho@2022@1234");
	driver.findElement(By.xpath(loc.getProperty("SignIn_Login"))).click();
	System.out.println("Welcome to ZOHO.com");
	}
	
}
