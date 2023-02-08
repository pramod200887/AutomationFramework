package com.framework.testClasses;

import static org.testng.Assert.assertEquals;

import org.apache.hc.core5.util.Asserts;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;
import com.framework.baseClass.baseClass;
import com.github.dockerjava.api.model.Driver;

public class titleVerification extends baseClass {

	@Test
	public static void pageTile()	
	{
		String expectedTitle ="Explore All Products | Zoho";
		String actualTitle = driver.getTitle();
		System.out.println("Page title is: " +actualTitle);
		assertEquals(actualTitle, expectedTitle);
		
	}
}
