package Data_Driven_Testing;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDataFromPDF {

	public static void main(String[] args) throws IOException {

		File file = new File("./src/test/resources/Tutorial 1 - Introduction to Selenium - Google Drive.pdf");
		
		PDDocument doc = PDDocument.load(file);
		int pages = doc.getNumberOfPages();
		System.out.println("Total pages available in PDF:"+pages);
		
		PDFTextStripper pdfData = new PDFTextStripper();
		pdfData.setStartPage(2);            //fetching the data for selected pages
		pdfData.setEndPage(5);
		
		System.out.println("Data of the selected pages:");
		String pagesData = pdfData.getText(doc);
		System.out.println(pagesData);
		
	}

}
