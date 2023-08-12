package onlineWebsitesAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataRead {

	public static void main(String[] args) throws IOException {

		// Workbook wBookObj = null;
		//
		// try {
		// FileInputStream fis = new
		// FileInputStream("src\\test\\resources\\ExelData\\NewDataReadExcel.xlsx");
		// wBookObj = new XSSFWorkbook(fis);
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// }
		//
		// Sheet sheetObj = wBookObj.getSheet("Sheet1");
		// Row rowObj = sheetObj.getRow(4);
		// Cell cellObj = rowObj.getCell(2);
		//
		// CellType cellTypeObj = cellObj.getCellType();
		// if(cellTypeObj == CellType.STRING) {
		// String cellData = cellObj.getStringCellValue();
		// System.out.println(cellData);
		//
		// }else if (cellTypeObj == CellType.NUMERIC) {
		// Double data = cellObj.getNumericCellValue();
		// System.out.println(data);
		//
		// }
		// }
		// }






		FileInputStream fis = new FileInputStream("src\\test\\resources\\ExelData\\NewDataReadExcel.xlsx");
		Workbook wbook = new XSSFWorkbook(fis);
		Sheet sheet = wbook.getSheet("Sheet1");
		int rowcount = sheet.getLastRowNum();
		for (int j = 0; j < rowcount; j++) {
			Row row = sheet.getRow(j);
			int cellcount = row.getLastCellNum();
			for (int i = 0; i <= cellcount - 1; i++) {
				Cell cell = row.getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				if (cell.getCellType() == CellType.STRING) {
					String cellvalue = cell.getStringCellValue();
					System.out.print(" " + cellvalue);
				} else if(cell.getCellType() == CellType.NUMERIC) {
					double dvalue = cell.getNumericCellValue();
					System.out.println(dvalue+" ,");
				}
				System.out.println(" ");
			}
		}
	}
}
