package dao;
import java.util.*;
import model.Cart;
import model.User;
public class CartDAO {
private static CartDAO cartdao;
List<User> userList=new ArrayList<User>();
//private List<Cart> cartList=new ArrayList<Cart>();
//private Map<User,Cart> usercart=new HashMap<User,Cart>();
	private CartDAO()
	{
		UserDAO userdao=UserDAO.getInstance();
	
		userList=userdao.userList;
	}
	public static CartDAO getInstance()
	{
		if(cartdao==null)
			cartdao=new CartDAO();
		return cartdao;
	}
public Cart getCart(int userid)
{int i=0;
	for(i=0;i<userList.size();i++)
	{
		if(userList.get(i).getUserID()==userid)
		{
			break;
		}
		
	}
	//System.out.println("I HAVE MATCHED   "+i+" SD WE"+userList.get(i).getUserName());
	return userList.get(i).getUserCart();
}

	
	
	/*	
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
	
*/
	
}
