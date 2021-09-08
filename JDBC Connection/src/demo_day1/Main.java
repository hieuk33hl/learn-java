package demo_day1;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;  

public class Main {
	private final static String DB_NAME = "jdbc";
	private final static String DB_URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
	private final static String USER = "root";
	private final static String PASSWORD = "";
	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection(DB_URL,USER,PASSWORD);
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("Select * from student");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" +rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
		}	

	}

}
