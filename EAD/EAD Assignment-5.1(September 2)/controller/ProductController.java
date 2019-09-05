package controller;
import model.*;
import facade.*;
import java.util.*;
public class ProductController {
	private ProductFacade productFacade;
	static private ProductController productController;
private ProductController(){
	productFacade=ProductFacade.getInstance();
	}

	public static ProductController getInstance(){
		if(productController==null){
			return new ProductController();
		}
		return productController;
	}

	public List<Product> getStoreProduct()
	{
		return productFacade.getProducts();
	}

	public Product getProductById(String productID)
	{
		return productFacade.getproductByID(productID);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
