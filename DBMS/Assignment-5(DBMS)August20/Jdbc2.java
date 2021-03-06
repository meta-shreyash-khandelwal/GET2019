package dbms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbc2 {
    public static Connection connect;
  public static void main(String[] argv) {
      try
        {
    	  connect=JDBCConnection.connectionQuery("storefront", "root", "root");

            String sqlQuery="select count(categoryname) as child,parentcategorytitle from category where parentcategorytitle in ( select categoryname from category where parentcategorytitle ='Topcategory') group by parentcategorytitle";
            
            PreparedStatement statement =  connect.prepareStatement(sqlQuery);
            ResultSet result = statement.executeQuery();
            System.out.println("Parent Category Title\t"+"Child Count");

            while(result.next())
            {
               String retrievedid1= result.getString("parentcategorytitle");
               String retrievedid2= result.getString("child");
               
               System.out.print(retrievedid1+"\t\t");
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
