package dbms;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc4 {
    public static Connection connect;
  public static void main(String[] argv) {
      try
        {
            connectionQuery();
            String sqlQuery="insert into images(ImageID,ImageSize,ImageCategory,ImageData,ProductID) values(?,?,?,?,?)";
      
            PreparedStatement statement = connect.prepareStatement(sqlQuery);
            
            for(int i=1; i<=5;i++){
            	statement.setString(1,"i00"+(i+5));
            	statement.setInt(2,100);
            	statement.setString(3,".jpg");
            	statement.setString(4,"c/:images/image"+i+".jpg");
            	statement.setString(5,"p008");
            	statement.addBatch();
            }
            try {
                // Batch is ready, execute it to insert the data
            	statement.executeBatch();
            } catch (SQLException e) {
                System.out.println("Error message:--> " + e.getMessage());
                return; // Exit if there was an error
            }
 
            
            
            
            

            connect.close();//Closing the connection
        }

        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage().toString());
        }
  }

  public static void connectionQuery()
  {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/storefront","root","root");
            System.out.println("Remote DB connection established");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("Remote server could not be connected");
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
            System.out.println("Remote server could not be connected");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Remote db connection establishment error");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("False query");
        }
    }
}