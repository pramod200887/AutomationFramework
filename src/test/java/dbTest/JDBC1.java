package dbTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC1 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "SYSTEM", "System");
		
		//Query Statements
		
		Statement stmt=con.createStatement();
		
		//Execution
		
		ResultSet rs =stmt.executeQuery("select first_name from employees");
		
		while (rs.next())
		{
			String firstname =rs.getString("first_name");
			System.out.println("This is executed after db query processed:  " + firstname);
		}
		
		con.close();
		System.out.println("Execution done");
	}

}
