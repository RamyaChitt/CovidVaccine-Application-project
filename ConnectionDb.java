package SAMPLE;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb {

	public  static Connection  getCon() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/COVID19","root","root");
		return con;
		
	}

}
