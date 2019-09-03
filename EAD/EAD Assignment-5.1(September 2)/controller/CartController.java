package controller;
import model.*;
import java.util.*;
import dao.*;
import facade.*;
public class CartController {
private static CartController cartController;
private CartFacade cartFacade;
private ProductController productController;
public CartController() {
		cartFacade=CartFacade.getInstance();
		productController=ProductController.getInstance();
	}

	public static CartController getInstance(){
		if(cartController==null){
			return new CartController();
		}
		return cartController;
	}

	public List<Product> getCartList(int userID)
	{
		return cartFacade.getCartProduct(userID);
	}

	public void addProductToCart(int userID, String productID, int productQuantity) 
	{
		//Product product=productController.getProductById(productID);
			
		cartFacade.addProductToCart(userID, productID, productQuantity);
	}

	public void deleteProductFromCart(int userID,String productID) 
	{
cartFacade.deleteProductFromCart(userID, productID);
	
	
}
	
	
}
