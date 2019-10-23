/*
 * Represents Item
 */
package model;

public class Item {
	private int id;
	private String title;
	private double price; 
	private String imageUrl;
	private String category;
	private int quantity;
	
	
	public Item() {
		super();
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Item(int id, String title, double price, String imageUrl, String category, int quantity) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.imageUrl = imageUrl;
		this.quantity = quantity;
		this.price = price;
	}
	
	
}
