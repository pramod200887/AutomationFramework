package com.framework.testClasses;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.framework.baseClass.baseClass;

public class loginTest extends baseClass{

	@Test
	public static void loginTest() throws InterruptedException
	{
		System.out.println("We are logged in suuccessfully");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[@class='login']")).click();

	System.out.println("Welcome to ZOHO.com");
	}
	
}
