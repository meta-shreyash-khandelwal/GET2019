package dbms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Jdbc1 {
    public static Connection connect;
  public static void main(String[] argv) {
      try
        {
           connect=JDBCConnection.connectionQuery("storefront", "root", "root");
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

}
