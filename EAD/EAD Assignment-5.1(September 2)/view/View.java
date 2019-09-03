package view;
import java.util.*;
import model.*;
import dao.*;
import facade.*;
import controller.*;
public class View {
	UserController userController =UserController.getInstance();
	ProductController productController =ProductController.getInstance();
	CartController cartController =CartController.getInstance();

	
	//show the general menu options 
		public static void showMenu()
		{
			System.out.println("Choose the option below");
			System.out.println("1. Add User");
			System.out.println("2. Choose user");
			System.out.println("Press any other key to exit");
		}
		
		//shows the cart menu options
		public static void showCartMenu()
		{
			System.out.println("Choose the below cart option");
			System.out.println("1. Add Product to cart");
			System.out.println("2. Update product to cart");
			System.out.println("3. Show Cart");
			System.out.println("4. Exit");
		}
		
		public static void main(String args[])
		{
			int userid=1;
			//displays the general menu
			//View menuView = new View();
			View.showMenu();
			
			UserController userController =UserController.getInstance();
			ProductController productController =ProductController.getInstance();
			CartController cartController =CartController.getInstance();
			Scanner in = new Scanner(System.in);
			int menuChoice,cartChoice;
			
			menuChoice =in.nextInt();
			
			while(menuChoice>0 && menuChoice<3)
			{
				switch(menuChoice)
				{
				//add user 
				case 1:
					//System.out.println("Enter the id of the user");
					//int newuserId = sc.nextInt();
					
					System.out.println("Enter the name of the user");
					String newname = in.next();
					try {
						userController.addUser(new User(userid, newname));
						System.out.println("Added");
						userid++;
					}
					catch (Exception e) 
					{
						System.out.println("Error: "+e.getMessage());
					}
					break;
					
				//login user
				case 2:
					System.out.println("Enter the id of the user");
					int userID = in.nextInt();
					User user = userController.getUserByID(userID);
					if(user!=null)
					{
						View.showCartMenu();
						cartChoice = in.nextInt();
						
						while(cartChoice>0 && cartChoice<5)
						{
							switch(cartChoice)
							{
							
							//add product to cart
							case 1:
								List<Product> store = productController.getStoreProduct();
								System.out.println("ProductCode\tProductName\tProductType\tPrice");
								for(int i=0;i<store.size();i++)
								{
									System.out.println(store.get(i).getProductCode()+" \t "+store.get(i).getProductName()+" \t "
											+store.get(i).getProductType()+" \t "+store.get(i).getPrice());
								}
								System.out.println("Enter the id of the product...");
								String productID = in.next();
								System.out.println("Enter the quantity of the product...");
								int productQuantity = in.nextInt();
								try {
									cartController.addProductToCart(userID, productID, productQuantity);
									System.out.println("Added the products");
								} 
								catch (Exception e) 
								{
									System.out.println(e.getMessage());
								}
								break;
								
							//update product to cart	
							case 2:
								List<Product> cartList = cartController.getCartList(userID);
								for(int i=0;i<cartList.size();i++)
								{
									//Product cartProduct = cartList.get(i);
									System.out.println(cartList.get(i).getProductCode()+"    "+cartList.get(i).getProductName()+"    "
											+cartList.get(i).getProductType()+"\t"+cartList.get(i).getPrice());
								}
								
								System.out.println("Enter the id of the product to update...");
								String productID1 = in.next();
								System.out.println("Enter the Quantity of the product...");
								int productQTY = in.nextInt();
								try {
									cartController.updateCartItem(userID, productID1, productQTY);
								} 
								catch (Exception e) 
								{
									System.out.println(e.getMessage());
								}
								
								break;
								
							//show the user cart
							case 3: 
								
								List<Product> cartList1 = cartController.getCartList(userID);
								int totalPrice=0;
								for(int i=0;i<cartList1.size();i++)
								{
									Product cartProduct = cartList1.get(i);
									totalPrice+=cartProduct.getQuantity()*cartProduct.getPrice();
									System.out.println(cartProduct.getProductCode()+" \t "+cartProduct.getProductName()+" \t "+cartProduct.getQuantity()+" \t "+
											+cartProduct.getPrice()*cartProduct.getQuantity());
								}
								System.out.println("The total to be paid  Rs"+totalPrice);
								break;
							case 4:
								break;
							default:
								System.out.println("Invalid Choice!!");
							}
							
							if(cartChoice == 4)
							{
								break;
							}
							
							View.showCartMenu();
							cartChoice = in.nextInt();
						}
					}
					else
					{
						System.out.println("User doesn't exist");
					}
					break;
				default:
					System.out.println("Invalid choice!!!");
				}
				System.out.println();
				
				View.showMenu();
				in.next();
				menuChoice = in.nextInt();
				//main(args);
			}
			
}

	
}
