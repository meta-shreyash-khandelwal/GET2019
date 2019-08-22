package dbms;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class Jdbc4 {
    public static Connection connect;
  public static void main(String[] argv) {
      try
        {
    	  connect=JDBCConnection.connectionQuery("storefront", "root", "root");
   
         String sqlQuery1="SET FOREIGN_KEY_CHECKS=0";;
   
         PreparedStatement statement1 = connect.prepareStatement(sqlQuery1);
         
         statement1.executeUpdate(sqlQuery1);
         
         String sqlQuery="delete from products where products.productid"
            		+ " in(select * from (select products.productid from products left join cart on "
            		+ "cart.productid=products.productid where cart.orderid is null)as t);";
      
            PreparedStatement statement = connect.prepareStatement(sqlQuery);
              
            int numRowsAffected = statement.executeUpdate(sqlQuery);
            connect.close();//Closing the connection
        System.out.println("The total number of records deleted are "+numRowsAffected);
         }

        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage().toString());
        }
  }

}
