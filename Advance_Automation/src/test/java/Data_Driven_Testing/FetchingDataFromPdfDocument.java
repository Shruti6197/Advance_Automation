package Data_Driven_Testing;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDataFromPdfDocument {

	public static void main(String[] args) throws Throwable {
		File file = new File("./src/test/resources/Tutorial 1 - Introduction to Selenium - Google Drive.pdf");
		
		PDDocument doc = PDDocument.load(file);
		int pages = doc.getNumberOfPages();      //read total count of the pages available in PDF
		System.out.println("Total pages available in PDF:"+pages);   
		
		PDFTextStripper pdfData = new PDFTextStripper();
		String readData = pdfData.getText(doc);      //reads all the pages data
		System.out.println(readData);
	}

}
