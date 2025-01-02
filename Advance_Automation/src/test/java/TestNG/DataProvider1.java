package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	@Test(dataProvider = "getData")
	public void bookTickets(String src, String dest) {
		System.out.println("Book ticket from"+" "+src+" "+"to"+" "+dest);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] obj = new Object[2][2];
		obj[0][0] = "Bangalore";
		obj[0][1] = "Mumbai";
		
		obj [1][0] = "Pune";
		obj[1][1] = "Mysore";
		return obj;
	}
}
