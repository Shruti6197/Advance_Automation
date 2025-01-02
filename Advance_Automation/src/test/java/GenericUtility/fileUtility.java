package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class fileUtility {
	
	public String getKeyandValuePair(String key) throws IOException {
		
		/**
		 * This class is created to read data from properties file
		 * @author DELL
		 * @return
		 */
		
		FileInputStream fis = new FileInputStream(iPath.Property_filePath);
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
	}
}
