package com.bix.selenium.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.bix.selenium.constants.TestConstants;
import com.bix.selenium.utils.ExcelUtils;

public class MyDataProvider_XLS {

	@DataProvider(name = "pair_from_Class_2d_diff_datatype_XLS")
	public Object[][] pair_from_Class_2d_diff_datatype() throws FileNotFoundException, IOException, Exception {

		ExcelUtils utils = new ExcelUtils();

		List<HashMap<String, String>> data = utils.retrieveData(
				"C:\\Users\\djayakum\\Desktop\\stash\\recascade\\mavensession\\resources\\data\\input1.xls");

		Object[][] obj = new Object[data.size()][2];

		for (int i = 0; i < data.size(); i++) {
			obj[i][0] = new String[] { data.get(i).get("Username"), data.get(i).get("Password") };
			obj[i][1] = data.get(i).get("Desc");
		}

		return obj;
	}
	
	

}
