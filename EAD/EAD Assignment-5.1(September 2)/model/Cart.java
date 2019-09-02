package model;
import java.util.*;
public class Cart {
private String cartID;
private List<Product> items;
private double totalPrice;

public Cart(String cartID,double totalPrice) {
	this.cartID = cartID;
	items=new ArrayList<Product>();
	this.totalPrice = totalPrice;
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



}
