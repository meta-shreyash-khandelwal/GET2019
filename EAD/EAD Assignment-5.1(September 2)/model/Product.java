package model;

public class Product {
	private String productCode;
	private String productName;
	private String productType;
	private double price;
	private int quantity;
	public Product(String productCode, String productName, String productType,
			double price,int quantity) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productType = productType;
		this.price = price;
		this.quantity=quantity;
		
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
