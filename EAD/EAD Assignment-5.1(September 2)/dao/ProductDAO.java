package dao;
import java.util.*;
import model.Product;
public class ProductDAO {
private static ProductDAO productdao;
private List<Product> productList=new ArrayList<Product>();
public static ProductDAO getInstance()
{
	if(productdao==null)
		
		{
		//System.out.println("I AM HERE");
		return new ProductDAO();
		
		}
	else
	{
	return productdao;
}}
private ProductDAO()
{
productList.add(new Product("p1","Mobile","Electronics",25000,15));
productList.add(new Product("p2","Shirt","Clothing",1250,50));
productList.add(new Product("p3","T-shirt","Clothing",250,50));
productList.add(new Product("p4","Calculator","Electronics",2500,10));
productList.add(new Product("p5","Sport Shoes","Shoes",5000,60));
productList.add(new Product("p6","Samsung TV","TV",50000,10));
}

public List<Product> getList()
{
	return productList;
}
}






