package Data_Driven_Testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class InsertDataIntoPropertyFile {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/DDT-Advance.properties");
		Properties p = new Properties();
		
		p.setProperty("url", "https://www.saucedemo.com/v1");
		p.setProperty("username", "standard_user");
		p.setProperty("password", "secret_sauce");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/DDT-Advance.properties");
		p.store(fos, "CommonData");
		fis.close();
	}

}
