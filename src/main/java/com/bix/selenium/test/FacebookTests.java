package com.bix.selenium.test;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bix.selenium.pom.FacebookLoginPage;
import com.bix.selenium.webdriver.InitChromeDriver;

//this class contains my actual test methods/logic
//Download TestNg Libraraies from
// http://www.java2s.com/Code/Jar/t/Downloadtestng60jar.htm

//testNg Docs
// http://testng.org/doc/documentation-main.html

//test case 1: 
//goto www.facebook.com, check wether it contains "Create an Account" label

//test case 2:
//goto www.facebook.com, check whether it contains 2 gender radio buttons
public class FacebookTests extends InitChromeDriver{
	
		
	// Test method for testCase 1:
	@Test( groups = {"regression", "e2e", "grp1"}, timeOut=4)
	public void checkCreateAccountLabel() {
		driver.get("https://www.facebook.com/");
		FacebookLoginPage fbloginPage = new FacebookLoginPage(driver);
		System.out.println(fbloginPage.getCreateAccountLabel());
		// actual, expected
		Assert.assertEquals(fbloginPage.getCreateAccountLabel(), "Create account",
				"Failed: Create an account label is mismatching");

	}

	@Test(alwaysRun=true, dependsOnMethods="checkCreateAccountLabel")
	public void checkCreateAccountLabel1() {		
		driver.get("https://www.facebook.com/");
		FacebookLoginPage fbloginPage = new FacebookLoginPage(driver);
		System.out.println(fbloginPage.getCreateAccountLabel());
		// actual, expected
		Assert.assertEquals(fbloginPage.getCreateAccountLabel(), "Create an account",
				"Failed: Create an account label is mismatching");

	}

	// Test method for testCase 2:
	@Test( dependsOnGroups= {"e2e" })
	public void checkGenderRadioButtons() {
		driver.get("https://www.facebook.com/");
		FacebookLoginPage fbloginPage = new FacebookLoginPage(driver);
		System.out.println(Arrays.toString(fbloginPage.getGenderTypes()));
		String[] expected = { "Female", "Male" };
		Assert.assertEquals(fbloginPage.getGenderTypes(), expected);

	}

}
