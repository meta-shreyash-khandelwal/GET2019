package facade;
import dao.ProductDAO;
import model.Product;
import java.util.*;
public class ProductFacade {
static private ProductFacade productFacade;
private ProductDAO productDAO;
private ProductFacade()
{
	productDAO=ProductDAO.getInstance();
}
public static ProductFacade getInstance()
{
	if(productFacade==null)
		return new ProductFacade();
	return productFacade;
}

public List<Product> getProducts()
{
	return productDAO.getList();
}

public Product getproductByID(String productID)
{
	int i=0;
	List<Product> listProduct=new ArrayList<Product>();
	listProduct=getProducts();
	for(i=0;i<listProduct.size();i++)
	{
		if(listProduct.get(i).getProductCode().equals(productID))
			break;

	}
	return listProduct.get(i);
}


	
	
}
