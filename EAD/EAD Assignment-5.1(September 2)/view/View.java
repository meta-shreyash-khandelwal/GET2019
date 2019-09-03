package view;
import model.*;
import dao.*;
import facade.*;
import controller.*;
public class View {
	//show the general menu options 
		public static void showMenu()
		{
			System.out.println("Choose the option below");
			System.out.println("1. Add User");
			System.out.println("2. Login");
			System.out.println("Press any other key to exit");
		}
		
		//shows the cart menu options
		public static void showCartMenu()
		{
			System.out.println("Choose the below cart option");
			System.out.println("1. Add Product to cart");
			System.out.println("2. Update product to cart");
			System.out.println("3. Show Cart");

		}
		
		public static void main(String args[])
		{
			//displays the general menu
			View menuView = new View();
			View.showMenu();
			
			UserController userController = new UserController();
			ProductController productController = new ProductController();
			CartController cartController = new CartController();
			
			Scanner sc = new Scanner(System.in);
			int menuChoice,cartChoice;
			
			menuChoice = sc.nextInt();
			
			while(menuChoice>0 && menuChoice<3)
			{
				switch(menuChoice)
				{
				//add user 
				case 1:
					System.out.println("Enter the id of the user");
					int newuserId = sc.nextInt();
					System.out.println("Enter the name of the user");
					String newname = sc.next();
					try {
						userController.addUser(new User(newuserId, newname));
						System.out.println("Added");
					}
					catch (Exception e) 
					{
						System.out.println("Error: "+e.getMessage());
					}
					break;
					
				//login user
				case 2:
					System.out.println("Enter the id of the user");
					int userID = sc.nextInt();
					User user = userController.getUserByID(userID);
					if(user!=null)
					{
						menuView.showCartMenu();
						cartChoice = sc.nextInt();
						
						while(cartChoice>0 && cartChoice<5)
						{
							switch(cartChoice)
							{
							
							//add product to cart
							case 1:
								List<Product> store = productController.getStoreProduct();
								for(int i=0;i<store.size();i++)
								{
									System.out.println(store.get(i).getProduct_code()+"\t"+store.get(i).getProduct_name()+"\t"
											+store.get(i).getProduct_price()+"\t"+store.get(i).getProduct_type()+"\t"+store.get(i).getProduct_qty());
								}
								System.out.println("Enter the id of the product...");
								int proID = sc.nextInt();
								System.out.println("Enter the quantity of the product...");
								int proQty = sc.nextInt();
								try {
									cartController.addProductToCart(userID, proID, proQty);System.out.println("Added");
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
									Product cartProduct = cartList.get(i);
									System.out.println(cartProduct.getProduct_code()+"\t"+cartProduct.getProduct_name()+"\t"
											+cartProduct.getProduct_price()+"\t"+cartProduct.getProduct_type()+"\t"+cartProduct.getProduct_qty());
								}
								
								System.out.println("Enter the id of the product to update...");
								int productID = sc.nextInt();
								System.out.println("Enter the Quantity of the product...");
								int productQTY = sc.nextInt();
								try {
									cartController.deleteProductFromCart(userID, productID, productQTY);
								} 
								catch (Exception e) 
								{
									System.out.println(e.getMessage());
								}
								
								break;
								
							//show the user cart
							case 3: 
								
								List<Product> cartL = cartController.getCartList(userID);
								
								for(int i=0;i<cartL.size();i++)
								{
									Product cartProduct = cartL.get(i);
									System.out.println(cartProduct.getProduct_code()+"\t"+cartProduct.getProduct_name()+"\t"
											+cartProduct.getProduct_price()+"\t"+cartProduct.getProduct_type()+"\t"+cartProduct.getProduct_qty());
								}
								
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
							
							menuView.showCartMenu();
							cartChoice = sc.nextInt();
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
				menuView.showMenu();
				menuChoice = sc.nextInt();
				
			}
			
			sc.close();
		}

	
}
