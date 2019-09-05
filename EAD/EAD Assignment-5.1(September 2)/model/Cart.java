package model;
import java.util.*;
public class Cart {
private String cartID;
private List<Product> items;
private double totalPrice;

public Cart() {
	items=new ArrayList<Product>();
}
public String getCartID() {
	return cartID;
}
public void setCartID(String cartID) {
	this.cartID = cartID;
}
public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}

public List<Product> cartItems()
{
	return items;
}
public void addProduct(Product product)
{
	items.add(product);
}
public void removeProduct(Product product)
{
	items.remove(product);
}





}
