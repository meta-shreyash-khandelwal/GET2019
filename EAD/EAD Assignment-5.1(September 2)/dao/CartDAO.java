package dao;
import java.util.*;

import model.Cart;
import model.Product;
import model.User;
public class CartDAO {
private static CartDAO cartdao;
//private List<Cart> cartList=new ArrayList<Cart>();
private Map<User,Cart> usercart=new HashMap<User,Cart>();
	private CartDAO()
	{
		
	}
	public static CartDAO getInstance()
	{
		if(cartdao==null)
			cartdao=new CartDAO();
		return cartdao;
	}

	public void addToCart(Cart cart,Product product)
	{
		cart.cartItems().add(product);
		
	}	
	public void removeFromCart(Cart cart,Product product)
	{
		cart.cartItems().remove(product);
		
	}	
	
public void cartUpdate(Cart cart,int quantity,String productCode)
{
	//cart.cartItems().remove()
}
	
	
public void displayCart(Cart cart)
{

	for(int i=0;i<cart.cartItems().size();i++)
	{
		System.out.print(cart.cartItems().get(i).getProductCode());
		System.out.print(cart.cartItems().get(i).getProductName());
		System.out.print(cart.cartItems().get(i).getProductType());
		System.out.print(cart.cartItems().get(i).getQuantity());
		
	}
	System.out.println();
	
}
	
public void addCartForUser(User newUser,Cart cart)
{
	usercart.put(newUser, cart);
}
public void removeCartForUser(User user)
{
	usercart.remove(user);
	
}
	
	
	
}
