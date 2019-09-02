package dao;
import java.util.*;
import model.Product;
public class ProductDAO {
private static ProductDAO productdao;
private List<Product> productList;
private ProductDAO()
{
	
}
public static ProductDAO getInstance()
{
	if(productdao==null)
		productdao=new ProductDAO();
	return productdao;
}
public void addProduct(Product newProduct)
{
	productList.add(newProduct);
}
public void deleteProduct(Product existingProduct)
{
	productList.remove(existingProduct);
}
public List<Product> getAllProducts()
{
	return productList;
}


}






