package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2 {
	@Test(dataProvider = "getData")
	public void bookTickets(String src, String dest, int num) {
		System.out.println("Book ticket from"+" "+src+" "+"to"+" "+dest+" "+"with"+" "+num+" "+"people");
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] obj = new Object[3][3];
		obj[0][0] = "Bangalore";
		obj[0][1] = "Mumbai";
		obj[0][2] = 3;
		
		obj[1][0] = "Pune";
		obj[1][1] = "Mysore";
		obj[1][2] = 4;
		
		obj[2][0] = "Mumbai";
		obj[2][1] = "Pune";
		obj[2][2] = 1;
		return obj;
	}
}
