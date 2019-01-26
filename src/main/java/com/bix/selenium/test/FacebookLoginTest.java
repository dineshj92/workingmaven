package com.bix.selenium.test;

import java.util.Arrays;
import java.util.HashMap;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bix.selenium.dataprovider.MyDataProvider;
import com.bix.selenium.dataprovider.MyDataProvider_XLS;
import com.bix.selenium.pom.FacebookLoginPage;
import com.bix.selenium.webdriver.InitChromeDriver;

//this class contains my actual test methods/logic
//Download TestNg Libraraies from
// http://www.java2s.com/Code/Jar/t/Downloadtestng60jar.htm

//testNg Docs
// http://testng.org/doc/documentation-main.html

//test case 1: 
//goto www.facebook.com, check login

public class FacebookLoginTest extends InitChromeDriver {

	@BeforeMethod
	public void beforemethod() {
		System.out.println("before mehotd");
	}

	// Test method for testCase 1:
	@Test(groups = { "regression", "e2e",
			"grp1" }, dataProvider = "pair_from_Class", dataProviderClass = MyDataProvider.class)
	public void checkCreateAccountLabel(String[] creds) {
		driver.get("https://www.facebook.com/");
		FacebookLoginPage fbloginPage = new FacebookLoginPage(driver);
		fbloginPage.enterUsername(creds[0]);
		fbloginPage.enterPassword(creds[1]);
	}

	@Test(groups = { "regression", "e2e",
			"grp1" }, dataProvider = "pair_from_Class_hashMap", dataProviderClass = MyDataProvider.class)
	public void checkCreateAccountLabel_forManager(String[] creds) {
		driver.get("https://www.facebook.com/");
		FacebookLoginPage fbloginPage = new FacebookLoginPage(driver);
		fbloginPage.enterUsername(creds[1]);
		fbloginPage.enterPassword(creds[2]);
	}

	@Test(groups = { "regression", "e2e",
			"grp1" }, dataProvider = "pair_from_Class_2d_diff_datatype_XLS", dataProviderClass = MyDataProvider_XLS.class)
	public void checkCreateAccountLabel1(String[] creds, String desc) {
		driver.get("https://www.facebook.com/");
		FacebookLoginPage fbloginPage = new FacebookLoginPage(driver);
		fbloginPage.enterUsername(creds[0]);
		fbloginPage.enterPassword(creds[1]);
		System.out.println(desc);
	}

}
