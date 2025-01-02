package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelUtility {
	
	public String getworkbookData(String sheetname, int rowValue, int cellValue) throws Throwable {
		FileInputStream fis1 = new FileInputStream(iPath.Excel_Path);
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rowValue);
		Cell cell = row.getCell(cellValue);
		String Data = cell.getStringCellValue();
		System.out.println(Data);
		return Data;
	}
	
	public String handleDataFormatter(String sheetname, int rowValue, int cellValue) throws EncryptedDocumentException, IOException {
		FileInputStream fis2 = new FileInputStream(iPath.Excel_Path);
		Workbook book = WorkbookFactory.create(fis2);
		Sheet sheet = book.getSheet(sheetname);
		Row row2 = sheet.getRow(rowValue);
		Cell cell2 = row2.getCell(cellValue);
		DataFormatter format = new DataFormatter();            //using dataformatter to convert the numbers into string
		String PhoneNo = format.formatCellValue(cell2);
		return PhoneNo;
	}
	
	public Object[][]readDatafromDataProvider(String sheetname) throws Throwable{
		FileInputStream fis1 = new FileInputStream(iPath.Excel_Path);
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet(sheetname);
		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRow][lastCell];
		for(int i = 1; i < lastRow; i++) {
			for(int j = 1; j < lastCell; j++) {
				obj[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return obj;
	}
}
