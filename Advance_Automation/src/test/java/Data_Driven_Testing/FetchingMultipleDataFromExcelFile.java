package Data_Driven_Testing;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingMultipleDataFromExcelFile {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/DDT-Advance.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Data");
	
		int rowNum = sheet.getLastRowNum();
		System.out.println(rowNum);
		
		for(int i = 0; i < rowNum; i++) {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(0);
			String links = cell.getStringCellValue();
			System.out.println(links);
		}
	}

}
