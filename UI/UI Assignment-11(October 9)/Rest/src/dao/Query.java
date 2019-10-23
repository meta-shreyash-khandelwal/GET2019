/*
 * Query Class
 */
package dao;

public class Query {


	/**
	 * Gets All items from table
	 * @return query
	 */
	public static String getAll(){
		String query = "select * from items ";
		return query;
	}
	

}
