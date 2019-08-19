package dbms;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc4 {
    public static Connection connect;
  public static void main(String[] argv) {
      try
        {
         connectionQuery();
   
         String sqlQuery1="SET FOREIGN_KEY_CHECKS=0";;
   
         PreparedStatement statement1 = connect.prepareStatement(sqlQuery1);
         
         statement1.executeUpdate(sqlQuery1);
         
         String sqlQuery="delete from products where products.productid"
            		+ " in(select * from (select products.productid from products left join cart on "
            		+ "cart.productid=products.productid where cart.orderid is null)as t);";//To prevent post delete update select * is used in front
      
            PreparedStatement statement = connect.prepareStatement(sqlQuery);
              
            int numRowsAffected = statement.executeUpdate(sqlQuery);//Returns the total number of rows deleted
            connect.close();//Closing the connection
        System.out.println("The total number of records deleted are "+numRowsAffected);
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
