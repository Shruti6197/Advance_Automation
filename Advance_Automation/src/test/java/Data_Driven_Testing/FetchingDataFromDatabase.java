package Data_Driven_Testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchingDataFromDatabase {

	public static void main(String[] args) throws SQLException {
	
		//step1 - register driver/load the mysql database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2 - get connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "swarangikhond@123");
		
		//step3 - create SQL statement
		Statement statement = con.createStatement();
		String Query = "select * from info";
		
		//step4 - execute statement query
		ResultSet result = statement.executeQuery(Query);
		while(result.next()) {
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		
		//step5 - close the connection
		con.close();

	}

}
