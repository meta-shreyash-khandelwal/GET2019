package model;

public class User {
private int userID;
String userName;
private Cart userCart;
public User(int userID, String userName) {
	super();
	this.userID = userID;
	this.userName = userName;
	userCart=new Cart();
}
public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public Cart getUserCart() {
	return userCart;
}
public void setUserCart(Cart userCart) {
	this.userCart = userCart;
}



	
	
	
}
