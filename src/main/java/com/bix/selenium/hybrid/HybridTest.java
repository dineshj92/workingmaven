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

public class HybridTest extends InitChromeDriver {

	List<HashMap<String, String>> data;

	@Factory(dataProvider = "hybridCSV_data", dataProviderClass = MyDataProvider.class)
	public HybridTest(List<HashMap<String, String>> data) {
		this.data = data;
	}

	@Test
	public void execute() {
		
		driver.get(TestConstants.URL);
		
		//get list of actions from Enum class
		List<String> actions = Stream.of(Hybrid.values()).map(Enum::name).collect(Collectors.toList());

		for (HashMap<String, String> map : data) {
			//get list of actions from data provided by dataprovider
			Set<String> keys = map.keySet();
			//loop through each action in actions from enum class
			for (String action : actions) {
				//for each action, check whether the acion present in dataprovider map 
				//and it is non-null and non-empty
				if (keys.contains(action)) {
					if (map.get(action) != null && !map.get(action).trim().equals("")) {
						//execute the action, by setting parameters
						HashMap<String, String> param = new HashMap<>();
						param.put(action, map.get(action));
						Hybrid.valueOf(action).runHybrid(this.driver, param);
					}
				}
			}
		}
	}

}
