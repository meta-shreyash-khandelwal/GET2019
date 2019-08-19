package dbms;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc1 {
    public static Connection connect;
  public static void main(String[] argv) {
      try
        {
            connectionQuery();

            PreparedStatement statement =  connect.prepareStatement("select orders.orderid,orders.date,sum(cart.Amount*cart.Quantity) as Amount "
            		+ "from Orders	inner join cart on orders.OrderID=cart.OrderID where cart.shipped=true "
            		+ "and orders.shoppperidr='s004' "
            		+ "group by orders.orderid"
            		+ " order by orders.date");/*write query inside of prepared statement*/
           
            ResultSet result = statement.executeQuery();
            System.out.println("ORDERID\t"+" DATE\t"+"\tCartAmount");

            while(result.next())
            {
               String retrievedid= result.getString("orders.orderid");
               String retrievedid1= result.getString("orders.date");
               String retrievedid2= result.getString("Amount");
               
               System.out.print(retrievedid+"\t");
               System.out.print(retrievedid1+" \t");
               System.out.println(retrievedid2);
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