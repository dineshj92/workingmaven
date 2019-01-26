package com.bix.selenium.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class InitChromeDriver {
	
	public WebDriver driver;
	
	@BeforeTest
	public void init() {		
		//System.out.println("In Before Suite");
		System.setProperty("webdriver.chrome.driver",
				"/Users/djayakum/Downloads/chromedriver");
		driver = new ChromeDriver();
	}
	
	@AfterTest
	public void finish() {
		System.out.println("Quitting");
		//driver.close();
		//driver.quit();
	}
	

}
