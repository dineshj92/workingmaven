package com.bix.selenium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	protected List<String[]> list = new LinkedList<String[]>();

	private static Logger log = Logger.getLogger(ExcelUtils.class);

	
	//converts the row that has been read into a List<String>
	private List<String> getRowData(Row row, int... headerSize) throws Exception {
		List<String> rowData = new ArrayList<String>();
		int size = 0;
		if (headerSize.length > 0) {
			size = headerSize[0];
		} else {
			size = row.getLastCellNum();
		}
		for (int i = 0; i < size; i++) {
			Cell cell = row.getCell(i);
			if (cell != null) {
				switch (cell.getCellType()) {
				case NUMERIC:
					//String.valueof(int)
					rowData.add("" + cell.getNumericCellValue());
					break;
				case STRING:
					rowData.add(cell.getStringCellValue());
					break;
				case BLANK:
					rowData.add("");
					break;
				}
			} else {
				rowData.add("");
			}
		}
		return rowData;
	}

	public List<HashMap<String, String>> retrieveData(String filepath) throws Exception {
		Workbook workbook = new HSSFWorkbook(new FileInputStream(filepath));
		Sheet sheet = workbook.getSheetAt(0);
		Row headerRow = sheet.getRow(0);
		List<String> header = getRowData(headerRow);
		List<HashMap<String, String>> outputData = new ArrayList<HashMap<String, String>>();
		int totalRows = sheet.getLastRowNum();
		//start iterate from '1' to skip headerRow
		for (int i = 1; i <= totalRows; i++) {
			List<String> rowData = getRowData(sheet.getRow(i));
			HashMap<String, String> map = new HashMap<String, String>();
			for (int j=0; j<header.size(); j++) {
				map.put(header.get(j), rowData.get(j));
			}
			outputData.add(map);
		}
		workbook.close();
		return outputData;
	}

	public List<String> retrieveHeaderData(Workbook workbook) throws Exception {
		Sheet sheet = workbook.getSheetAt(0);
		Row headerRow = sheet.getRow(0);
		List<String> header = getRowData(headerRow);
		workbook.close();
		return header;
	}
	
	//WRITING
	public void addData(String[] data) throws Exception {
		list.add(data);
	}

	public void saveData(Workbook workbook, String filename, boolean forceNumbersAsString) throws Exception {

		CreationHelper createHelper = workbook.getCreationHelper();

		Sheet sheet = workbook.createSheet("Sheet1");

		for (int i = 0; i < list.size(); i++) {
			Row row = sheet.createRow((short) i);
			String[] data = list.get(i);

			for (int j = 0; j < data.length; j++) {
				log.debug("For row: " + i + ", creating column: " + j + " with data: " + data[j]);
				if (forceNumbersAsString) {
					row.createCell(j).setCellValue(createHelper.createRichTextString(data[j]));
					continue;
				}
				if (data[j].matches("[-+]?\\d*\\.?\\d+")) {
					row.createCell(j, CellType.NUMERIC).setCellValue(createHelper.createRichTextString(data[j]));
				} else {
					row.createCell(j).setCellValue(createHelper.createRichTextString(data[j]));
				}
			}
		}

		FileOutputStream fileOut = new FileOutputStream(filename);
		workbook.write(fileOut);
		fileOut.close();
	}


	public void writeDataToFile(Workbook workbook, String filename, List<HashMap<String, String>> data)
			throws Exception {
		if (data.size() == 0) {
			return;
		}

		HashMap<String, String> map = data.get(0);
		Set<String> header = map.keySet();
		writeDataToFile(workbook, filename, data, header.toArray(new String[header.size()]));
	}

	public void writeDataToFile(Workbook workbook, String filename, List<HashMap<String, String>> data, String[] header)
			throws Exception {
		writeDataToFile(workbook, filename, data, header, false);
	}

	public void writeDataToFile(Workbook workbook, String filename, List<HashMap<String, String>> data, String[] header,
			boolean forceNumbersAsString) throws Exception {
		addData(header);
		for (HashMap<String, String> map : data) {
			String[] row = new String[header.length];
			for (int i = 0; i < header.length; i++) {
				row[i] = map.get(header[i]);
			}
			addData(row);
		}
		saveData(workbook, filename, forceNumbersAsString);
	}

	public void appendToXLS(Workbook workbook, List<HashMap<String, String>> data) {
		try {
			FileInputStream myxls = new FileInputStream("poi-testt.xls");
			Sheet worksheet = workbook.getSheetAt(0);
			int lastRow = worksheet.getLastRowNum();
			System.out.println(lastRow);
			for(HashMap<String, String> map : data) {
				Row row = worksheet.createRow(++lastRow);
				for(int i=0; i<map.size(); i++) {
					row.createCell(i).setCellValue(map.get(i));
				}
			}
			myxls.close();
			FileOutputStream output_file = new FileOutputStream(new File("poi-testt.xls"));
			// write changes
			workbook.write(output_file);
			output_file.close();
			System.out.println(" is successfully written");
		} catch (Exception e) {
		}
	}

}
