package svk;
import java.sql.Connection;
import java.sql.DriverManager;
public class JDBCConnection {
	   public static Connection connect;
public static Connection connectionQuery(String database,String userName,String password)
{
	     try
	     {
          Class.forName("com.mysql.cj.jdbc.Driver");
          connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database,userName,password);
          System.out.println("Remote DB connection established");
	     }
	     catch(Exception e)
	        {
	    	    System.out.println("Remote DB connection not established");
	            e.printStackTrace();
	            System.out.println(e.getMessage().toString());
	        }
          return connect;
          
}
	   
	
	         
}
