/*
 * Connects to Database
 */
package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBC {
	
	public static Connection makeConnection(){
		final String URL = "jdbc:mysql://localhost:3306/Items";
		final String user ="root";
		final String pass ="root";
		Connection conn = null ;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,user,pass);
		}
		catch(SQLException e){
			System.out.println(e);
		}
		catch(ClassNotFoundException e){
			System.out.println(e);
		}
		
		return conn;
	}
}
