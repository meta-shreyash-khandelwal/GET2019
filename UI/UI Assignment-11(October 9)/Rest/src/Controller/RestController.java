/*
 * Controller for RestApi
 */
package Controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Item;
import utility.Helper;

@Path("/items")
public class RestController {



	/**
	 * Gets All Items
	 * @return list ofitems as json
	 */
	@GET
	@Path("/getItems")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getBooks(){
		List<Item> books = Helper.getAllItems(); 
		return books;
	}


}
