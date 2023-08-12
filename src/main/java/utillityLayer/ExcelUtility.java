package utillityLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static List<Map<String, String>> listAllData;

	public static List<Map<String, String>> getAllData(String filePath, String sheetName)  {
		Workbook wBook = getWorkBook(filePath);
		org.apache.poi.ss.usermodel.Sheet sheet = wBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (int i = 0; i < rowCount; i++) {
			Map<String, String> map = new HashMap<String, String>();
			Row row = sheet.getRow(i);
			Row firstRow = sheet.getRow(0);
			int cellCount = row.getLastCellNum();
			for (int j = 0; j <= cellCount - 1; j++) {
				String cellValue = getCellValue(row, j);
				String keyName = getCellValue(firstRow, j);
				map.put(keyName, cellValue);
			}
			list.add(map);
		}
		return list;
	}




	public static Map<String, String> getRowData(String filePath, String sheetName, int rowNo)  {
		Workbook wBook = getWorkBook(filePath);
		org.apache.poi.ss.usermodel.Sheet sheet = wBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 1; i < rowCount; i++) {
			Row row = sheet.getRow(rowNo);
			Row firstRow = sheet.getRow(0);
			int cellCount = row.getLastCellNum();
			for (int j = 0; j <= cellCount ; j++) {
				String cellValue = getCellValue(row, j);
				String keyName = getCellValue(firstRow, j);
				map.put(keyName, cellValue);
				//System.out.println(map);
			}
		}
		return map;
	}



	public static String getCellValue(Row row, int cellNumber) {
		String cellValue;
		Cell cell = row.getCell(cellNumber, MissingCellPolicy.CREATE_NULL_AS_BLANK);
		if (cell.getCellType() == CellType.STRING) {
			cellValue = cell.getStringCellValue();
		} else {
			Double doubl = cell.getNumericCellValue();
			Integer inV = doubl.intValue();
			cellValue = inV.toString();
		}
		return cellValue;
	}

	public static Workbook getWorkBook(String filePath) {
		File file = new File(filePath);
		InputStream in;
		Workbook wBook =null;
		try {
			in = new FileInputStream(file);
			wBook = new XSSFWorkbook(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wBook;
	}




	//////////////////============================/////////////////



	public static List<Map<String, String>> totalListData;
	public static List<Map<String, String>> getAllData1(String filePath,String sheetName) {
		Workbook wBook = getWorkbook(filePath);
		Sheet sheetObj = wBook.getSheet(sheetName);
		int rowCount = sheetObj.getLastRowNum();
		totalListData = new ArrayList<Map<String, String>>();
		for (int i = 1; i <= rowCount; i++) {
			Map<String, String> listData = new HashMap<String, String>();
			Row rowObj = sheetObj.getRow(i);
			Row firstName = sheetObj.getRow(0);
			int cellCount = rowObj.getLastCellNum();
			for (int j = 0; j <= cellCount - 1; j++) {
				String cellColumKey = getCellData(firstName, j);
				String cellData = getCellData(rowObj, j);
				listData.put(cellColumKey, cellData);
			}
			totalListData.add(listData);
		}
		return totalListData;
	}



	public static Workbook getWorkbook(String excelFilePath) {
		File fileObj = new File(excelFilePath);
		InputStream fis = null;
		Workbook wBook = null;
		try { /// Interface - Workbook
			fis = new FileInputStream(fileObj);
			wBook = new XSSFWorkbook(fis); /// xlsx
			// HSSFWorkbook hBook= new HSSFWorkbook(fis); /// xls
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wBook;
	}



	public static String getCellData(Row rowObj, int cellNumber) {
		Cell cellObj = rowObj.getCell(cellNumber,
				MissingCellPolicy.CREATE_NULL_AS_BLANK);
		CellType cellTypeObj = cellObj.getCellType();
		String cellData;
		if (cellTypeObj == CellType.NUMERIC) { 
			//// double Double int Integer boolean
			Double dblData = cellObj.getNumericCellValue();
			Integer intData = dblData.intValue();
			cellData = intData.toString();
		} else {
			cellData = cellObj.getStringCellValue();
		}
		return cellData;
	}



}


