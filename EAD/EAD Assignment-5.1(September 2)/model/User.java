package model;

public class User {
private String userID;
String userName;
private Cart userCart;
public User(String userID, String userName) {
	super();
	this.userID = userID;
	this.userName = userName;
}
public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
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
