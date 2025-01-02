package Data_Driven_Testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataIntoDatabase {

	public static void main(String[] args) throws SQLException {
		//step1 - Register driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2 - get connect to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "swarangikhond@123");
		
		//step3 - create SQL statement
		Statement statement = con.createStatement();
		String Query = "insert into info(first_name,last_name,address)values('Asavari','Khond','Pune')";
		
		//step4 - execute the query
		int result = statement.executeUpdate(Query);
		if(result == 1) {
			System.out.println("Data has been inserted");
		}
		else {
			System.out.println("Data has not inserted");
		}
		
		//step5 - close the connection
		con.close();

	}

}
