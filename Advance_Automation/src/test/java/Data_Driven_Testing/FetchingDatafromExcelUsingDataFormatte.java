package Data_Driven_Testing;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDatafromExcelUsingDataFormatte {

	public static void main(String[] args) throws Throwable {
	
		FileInputStream fis = new FileInputStream("./src/test/resources/DDT-Advance.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet2");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);

		DataFormatter format = new DataFormatter();
		String excelData = format.formatCellValue(cell);
		System.out.println(excelData);
	}

}
