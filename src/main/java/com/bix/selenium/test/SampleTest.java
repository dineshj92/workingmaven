package com.bix.selenium.test;

import org.testng.annotations.Test;

import com.bix.selenium.webdriver.InitChromeDriver;

public class SampleTest extends InitChromeDriver {
	
	@Test
	public void test() {
		driver.get("https://www.google.com");
	}

}
