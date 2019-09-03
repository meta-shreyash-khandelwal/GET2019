package facade;
import model.*;
import java.util.*;
import dao.CartDAO;
import dao.ProductDAO;
public class CartFacade {
	static private CartFacade cartFacade;
	static private ProductDAO productDAO;
	private CartDAO cartDAO;
	private CartFacade()
	{
		cartDAO=CartDAO.getInstance();
		productDAO=ProductDAO.getInstance();
	}
	public static CartFacade getInstance()
	{
		if(cartFacade==null)
			return new CartFacade();
		return cartFacade;
	}
	
public void addProductToCart(int userID,String productID,int quantity)
{
	Cart cart=cartDAO.getCart(userID);
	List<Product> productList=productDAO.getList();
	for(int i=0;i<productList.size();i++)
	{
		if(productList.get(i).getProductCode().equals(productID))
		{
			productList.get(i).setQuantity(quantity);
			cart.addProduct(productList.get(i));
			}
	}
	
	
}
public void deleteProductFromCart(int userID,String productID)
{
	List<Product> productList=productDAO.getList();
	Cart cart=cartDAO.getCart(userID);
	for(int i=0;i<productList.size();i++)
	{
		if(productList.get(i).getProductCode().equals(productID))
		{
			cart.removeProduct(productList.get(i));
			}
	}
}
public void updateCart(int userID,String productID,int quantity)
{
	Cart cart=cartDAO.getCart(userID);
	List<Product> productList=productDAO.getList();
	for(int i=0;i<productList.size();i++)
	{
		if(productList.get(i).getProductCode().equals(productID))
		{
			cart.removeProduct(productList.get(i));
			productList.get(i).setQuantity(quantity);
			cart.addProduct(productList.get(i));
			}
	}
	
}

public List<Product> getCartProduct(int userID)
{
	Cart cart=cartDAO.getCart(userID);
	return cart.cartItems();
}
	
	
}
