package com.bix.selenium.dataprovider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.bix.selenium.constants.TestConstants;
import com.bix.selenium.utils.CSVUtils;
import com.bix.selenium.utils.ExcelUtils;

public class MyDataProvider {

	@DataProvider(name = "pair_from_Class")
	public Object[] pair_from_Class() {
		CSVUtils utils = new CSVUtils();

		List<HashMap<String, String>> data = utils.getCSVDataHash(
				"C:\\Users\\djayakum\\Desktop\\stash\\recascade\\mavensession\\resources\\data\\input1.csv");

		Object[] obj = new Object[data.size()];

		for (int i = 0; i < data.size(); i++) {
			obj[i] = new String[] { data.get(i).get("Username"), data.get(i).get("Password") };
		}

		return obj;
	}

	@DataProvider(name = "pair_from_Class_hashMap")
	public Object[] pair_from_Class_hashMap() {
		CSVUtils utils = new CSVUtils();

		HashMap<String, String[]> data = utils.getCSVDataHashArray(
				"C:\\Users\\djayakum\\Desktop\\stash\\recascade\\mavensession\\resources\\data\\input2.csv", true);

		Object[] obj = new Object[data.size()];

		for (int i = 0; i < data.size(); i++) {
			obj[i] = data.get("Manager");
		}

		return obj;
	}

	@DataProvider(name = "pair_from_Class1")
	public Object[] pair_from_Class1() {
		CSVUtils utils = new CSVUtils();

		HashMap<String, String[]> data = utils.getCSVDataHashArray("C:\\Users\\djayakum\\Desktop\\input1.csv", false);

		Object[] obj = new Object[data.size()];

		for (int i = 0; i < data.size(); i++) {
			obj[i] = new String[] { data.get(i)[1], data.get(i)[2] };
		}

		return obj;
	}

	@DataProvider(name = "pair_from_Class_simple")
	public Object[] pair_from_Class_simple() {
		return new Object[] { new String[] { "a@gmail.com", "pass1" }, new String[] { "b@gmail.com", "pass2" },
				new String[] { "c@gmail.com", "pass3" } };
	}

	@DataProvider(name = "pair_from_Class_2d_same_datatype")
	public Object[][] pair_from_Class_2d_same_datatype() {
		return new Object[][] { new String[] { "a@gmail.com", "pass1" }, new String[] { "b@gmail.com", "pass2" } };
	}

	@DataProvider(name = "pair_from_Class_2d_diff_datatype")
	public Object[][] pair_from_Class_2d_diff_datatype() {
		Object[][] obj = new Object[2][2];

		obj[0][0] = new String[] { "a@gmail.com", "pass1" };
		obj[0][1] = 10;

		obj[1][0] = new String[] { "b@gmail.com", "pass2" };
		obj[1][1] = 20;

		return obj;
	}

	@DataProvider(name = "pair_from_Class_2d_diff_datatype")
	public Object[][] pair_from_Class_2d_diff_datatype2() {
		return new Object[][] { { new String[] { "a@gmail.com", "pass1" }, 10 },
				{ new String[] { "b@gmail.com", "pass2" }, 20 } };
	}

	@DataProvider(name = "hybridCSV_data")
	public Object[] hybridCSV_data() throws FileNotFoundException, IOException, Exception {

		CSVUtils utils = new CSVUtils();

		List<HashMap<String, String>> dataFromCSV = utils.getCSVDataHash("./resources/hybrid/hybrid.csv");

		//it indicated the list of hashmap for the given scenario
		List<HashMap<String, String>> scenarioList = new ArrayList<HashMap<String, String>>();

		Object[] obj = new Object[TestConstants.scenarios.length];
		int objIndex = 0;

		for (String scenario : TestConstants.scenarios) {
			scenarioList.clear();
			for (HashMap<String, String> map : dataFromCSV) {
				if(map.get("Test Scenario").equalsIgnoreCase(scenario)) {
					scenarioList.add(map);
				}
			}
			obj[objIndex++] = scenarioList;
		}

		return obj;
	}
	
	@DataProvider(name = "hybridCSV_data_sample")
	public Object[] hybridCSV_data_sample() throws FileNotFoundException, IOException, Exception {

		CSVUtils utils = new CSVUtils();

		//List<HashMap<String, String>> dataFromCSV = utils.getCSVDataHash("./resources/hybrid/hybrid.csv");

		//it indicated the list of hashmap for the given scenario
		String[] scenarioList = new String[2];

		Object[] obj = new Object[TestConstants.scenarios.length];
		int objIndex = 0;

		for (String scenario : TestConstants.scenarios) {
			scenarioList[0] = "https://www.facebook.com";
			scenarioList[1] = "https://www.facebook.com";
			obj[objIndex++] = scenarioList;
		}

		return obj;
	}

}
