package com.bix.selenium.hybrid;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.bix.selenium.constants.TestConstants;
import com.bix.selenium.dataprovider.MyDataProvider;
import com.bix.selenium.dataprovider.MyDataProvider_XLS;
import com.bix.selenium.webdriver.InitChromeDriver;

public class HybridTest2 extends InitChromeDriver {

	String[] data;

	@Factory(dataProvider = "hybridCSV_data_sample", dataProviderClass = MyDataProvider.class)
	public HybridTest2(String[] data) {
		this.data = data;
	}

	@Test
	public void execute() {
		init();
		
		driver.get(data[0]);
		
		//get list of actions from Enum class
		
	}

}
