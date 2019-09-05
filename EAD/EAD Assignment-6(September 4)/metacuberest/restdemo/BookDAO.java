package com.metacuberest.restdemo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	public static Connection connect;
	/**
	 * This method diplays all book ercord
	 * @return list of bookobject
	 */
	public List<BookObject> getBook() {
		List<BookObject> list = new ArrayList<BookObject>();
		try {
			connect = JDBCConnection.connectionQuery("library", "root", "root");
			String sqlQuery = "select * from book";
			PreparedStatement statement = connect.prepareStatement(sqlQuery);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				BookObject newBook = new BookObject();
				newBook.setTitle(result.getString("title"));
				newBook.setWriter(result.getString("writer"));
				newBook.setPublisher(result.getString("publisher"));
				newBook.setPublishedYear(result.getInt("publishyear"));
				list.add(newBook);
			}

			connect.close();// Closing the connection
		}

		catch (Exception e) {

			e.printStackTrace();
		}
		return list;
	}
/**
 * This method returns bookobject by title
 * @param title is book title
 * @return bookobject
 */
	public BookObject getBookByTitle(String title) {
		BookObject newBook = new BookObject();
		try {
			connect = JDBCConnection.connectionQuery("library", "root", "root");
			String sqlQuery = "select * from book where title=?";
			PreparedStatement statement = connect.prepareStatement(sqlQuery);
			statement.setString(1, title);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				newBook.setTitle(result.getString("title"));
				newBook.setWriter(result.getString("writer"));
				newBook.setPublisher(result.getString("publisher"));
				newBook.setPublishedYear(result.getInt("publishyear"));

			}

			connect.close();// Closing the connection
		}

		catch (Exception e) {

			e.printStackTrace();
		}
		return newBook;
	}
/**
 * This method creates new book record
 * @param newBook contains object to be inserted
 */
	public void create(BookObject newBook) {
		System.out.println("IM here in this part create");
		try {
			connect = JDBCConnection.connectionQuery("library", "root", "root");
			String sqlQuery = "insert into book(title,writer,publisher,publishyear) values(?,?,?,?)";
			PreparedStatement statement = connect.prepareStatement(sqlQuery);
			statement.setString(1, newBook.getTitle());
			statement.setString(2, newBook.getWriter());
			statement.setString(3, newBook.getPublisher());
			statement.setInt(4, newBook.getPublishedYear());
			statement.executeUpdate();
			connect.close();// Closing the connection
		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}
/**
 * This method updates bookobject
 * @param newBook is the book object
 */
	public void update(BookObject newBook) {
		System.out.println("IM here in this part update");
		try {
			connect = JDBCConnection.connectionQuery("library", "root", "root");
			String sqlQuery = "update book set writer=?,publisher=? where title=? and publishyear=?";
			PreparedStatement statement = connect.prepareStatement(sqlQuery);

			statement.setString(1, newBook.getWriter());
			statement.setString(2, newBook.getPublisher());
			statement.setString(3, newBook.getTitle());
			statement.setInt(4, newBook.getPublishedYear());
			statement.executeUpdate();
			connect.close();// Closing the connection
		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}
/**
 * This method deletes book by title
 * @param id is the book id
 * @return bookobject
 */
	public BookObject deleteBookByTitle(int id) {
		BookObject newBook = new BookObject();
		try {
			connect = JDBCConnection.connectionQuery("library", "root", "root");
			String sqlQuery = "delete from book where ID=?";
			PreparedStatement statement = connect.prepareStatement(sqlQuery);
			statement.setInt(1, id);
			statement.executeUpdate();
			connect.close();// Closing the connection
		}

		catch (Exception e) {

			e.printStackTrace();
		}
		return newBook;
	}
/**
 * This method deletes all book records
 */
	public void deleteAllBook() {

		try {
			connect = JDBCConnection.connectionQuery("library", "root", "root");
			String sqlQuery = "delete from book";
			PreparedStatement statement = connect.prepareStatement(sqlQuery);
			statement.executeUpdate();
			connect.close();// Closing the connection
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

}
