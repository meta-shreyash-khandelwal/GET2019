/*
 * Helper Class
 */
package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Query;
import model.Item;

public class Helper {



	/**
	 * Gets All items
	 * @return list of items
	 */
	public static List<Item> getAllItems(){
		List<Item> books = new ArrayList<Item>();
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.getAll())){
			ResultSet res = p.executeQuery();
			while(res.next()){
				int id = res.getInt("id");
				String title = res.getString("title");
				double price = res.getDouble("price");
				String imageUrl = res.getString("imageUrl");
				String category = res.getString("category");
				int quantity = res.getInt("quantity");
				books.add(new Item(id,title,price, imageUrl, category, quantity));
			}
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
		
		return books;
	}
	

}
