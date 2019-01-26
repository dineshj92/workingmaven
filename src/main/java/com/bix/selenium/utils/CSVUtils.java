package com.bix.selenium.utils;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVUtils {

	public HashMap<String, String[]> csvDataHashArray;
	public HashMap<String, String> csvColumnIndexHash;
	public Object[][] csvDataArray;
	private List<HashMap<String, String>> csvDataHash;

	private static Logger logger = Logger.getLogger(ExcelUtils.class);

	// This method is to set the File path and to open the Excel file, Pass Excel
	// Path and Sheetname as Arguments to this method

	/*
	 * Methods to read a CSV file in different format
	 */

	// this method requires row header
	// and
	// when you need all the rows in a csv
	public List<HashMap<String, String>> getCSVDataHash(String filepath) {
		try {
			csvDataHash = new ArrayList<HashMap<String, String>>();

			CSVReader reader = new CSVReader(new FileReader(filepath));
			// string[] indicate the row
			List<String[]> rowEntries = reader.readAll();
			// 0th index string[] indicates the rowheader
			String[] rowHeader = rowEntries.get(0);
			rowEntries.remove(0);
			for (String[] row : rowEntries) {
				HashMap<String, String> map = new HashMap<String, String>();
				for (int i = 0; i < row.length; i++) {
					map.put(rowHeader[i], row[i]);
				}
				csvDataHash.add(map);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return csvDataHash;
	}

	// this is useful when you don't have a row header
	// or
	// when you need a particular row
	//when you have a rowheader, then isRowHeader-->true
	public HashMap<String, String[]> getCSVDataHashArray(String filepath, boolean isRowHeader) {
		try {
			csvDataHashArray = new HashMap<String, String[]>();
			boolean headerRow = true;
			CSVReader reader = new CSVReader(new FileReader(filepath));
			List<String[]> rowEntries = reader.readAll();
			for (String[] row : rowEntries) {
				if (isRowHeader) {
					isRowHeader = false;
				} else {
					csvDataHashArray.put(row[0], row);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return csvDataHashArray;
	}

	public Object[][] getCSVArray(String filepath) {
		try {
			CSVReader reader = new CSVReader(new FileReader(filepath));
			List<String[]> rowEntries = reader.readAll();
			csvDataArray = new String[rowEntries.size()][];
			csvDataArray = rowEntries.toArray(csvDataArray);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return csvDataArray;
	}

	public Object[][] getCSVArray(String filepath, int rowNum) {
		try {
			CSVReader reader = new CSVReader(new FileReader(filepath));
			List<String[]> rowEntries = new ArrayList<String[]>();
			for (int i = 0; i < rowNum; i++) {
				rowEntries.add(reader.readNext());
			}
			csvDataArray = new String[rowEntries.size()][];
			csvDataArray = rowEntries.toArray(csvDataArray);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return csvDataArray;
	}
	
	//WRITING
	public void writeToCSVFile(String fileName, List<String[]> data) {
		try {
			CSVWriter csvWriter = new CSVWriter(new FileWriter(new File(fileName)));
			csvWriter.writeAll(data);
			csvWriter.close();
		} catch (Exception e) {
			logger.error("Error while writing to " + fileName);
		}
	}

	public void appendToCSVFile(String fileName, List<String[]> data) {
		try {
			File file = new File(fileName);
			if (!file.getParentFile().exists())
				file.getParentFile().mkdirs();
			CSVWriter csvWriter = new CSVWriter(new FileWriter(file, true));
			csvWriter.writeAll(data);
			csvWriter.close();
		} catch (Exception e) {
			logger.error("Error while appending to " + fileName);
		}
	}

}
