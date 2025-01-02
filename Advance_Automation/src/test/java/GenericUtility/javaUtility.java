package GenericUtility;

import java.util.Random;

public class javaUtility {
	
	/**
	 * This method is created to avoid duplicates
	 * @author DELL
	 * @return
	 */
	
	public int RandomNumber() {
		Random random = new Random();
		int ranNum = random.nextInt(1000);
		return ranNum;
		
	}
}
