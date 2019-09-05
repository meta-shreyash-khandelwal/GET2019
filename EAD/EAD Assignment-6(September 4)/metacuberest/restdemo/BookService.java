package com.metacuberest.restdemo;
import java.sql.Connection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;


import java.util.*;
@Path("/books")
public class BookService {
	public static Connection connect;
	BookDAO bookdao = new BookDAO();
	//Displaying all the books in JSON format
	@GET
	@Path("/display")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookObject> displayBook() {
		System.out.println("HERE B");
		return bookdao.getBook();

	}
//Display books by title in url
	@GET
	@Path("/displaytitle/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public BookObject displayBookByTitle(@PathParam("id") String title) {
		System.out.println("HERE in 2");
		return bookdao.getBookByTitle(title);
		// return bookdao.getBookByTitle(title);

	}
//Create new record
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public BookObject addBook(BookObject newRecord) {
		System.out.println("I am creating");
		bookdao.create(newRecord);
		return newRecord;
	}
//Update by id
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public BookObject updateBook(BookObject updatingRecord) {
		System.out.println("I am updating");
		bookdao.update(updatingRecord);
		return updatingRecord;
	}
//Delete by id
	@DELETE
	@Path("/deletetitle/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public BookObject deleteBookByTitle(@PathParam("id") int id) {
		System.out.println("HERE in delete");
		return bookdao.deleteBookByTitle(id);
		// return bookdao.getBookByTitle(title);

	}
//Delete all record
	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteAllBook() {
		System.out.println("HERE in delete ALL");
		bookdao.deleteAllBook();
		// return bookdao.getBookByTitle(title);

	}

}
