import java.util.*;
/**
 * This program helps in performing tasks related to hopping carts namely adding
 * item,updating items list,generating bills and display carts
 */
public class ShoppingCart {
    static Item firstObject;
	static Scanner in = new Scanner(System.in);
	/**
	 * Helps to add the items in the cart by using the ArrayList itemList defined
	 * and comparing the user entered value
	 * @param itemList is the ArrayList containing items in cart
	 */
	public static void addToCart(ArrayList<Item> itemList) {
		int quantity;
		char serialNo;
		System.out.println("Enter the serial number from the item from the above list");
		serialNo = in.next().charAt(0);
		// It helps in tracking where the cart is empty or not
	try
	{
		if (checkIfCartEmpty(itemList, serialNo)) {
			System.out.println("Select a valid option please !!");
		} else {
			
			
			System.out.println("Enter quantity of the item");
			quantity = in.nextInt();
			
			for (int m = 0; m < itemList.size(); m++) {
				firstObject = itemList.get(m);
				if (firstObject.getSerialNo() == serialNo) {
					firstObject.setQuantity(quantity);
				}
			}}
    }
			catch(Exception e)
			{
				System.out.println("Please enter integer value !!");	
			}
			
			
			
		}
	

	/**
	 * This method displays all the contents present in the cart and shows a message
	 * if no items are present in cart
	 */
	public static void showCartItems(ArrayList<Item> itemList) {
		int check = 0;
		for (int j = 0; j < itemList.size(); j++) {
			firstObject = itemList.get(j);
			if (firstObject.getQuantity() != -1) {
				check = 1;
			}
		}
		if (check == 0) {
			System.out.println("Sorry!! No items  in cart!!");
		} else {
			System.out.println("Your item contents are as follows");
			System.out.println("Itemname" + "\t" + "Quantity" + "\t" + "Total Price");
			for (int j = 0; j < itemList.size(); j++) {
				firstObject = itemList.get(j);
				if (firstObject.getQuantity() != -1) {
					System.out.println(firstObject.getItem() + "\t\t" + firstObject.getQuantity() + "\t\t"
							+ firstObject.getQuantity() * firstObject.getPrice());
					check = 1;
				}
			}
		}
	}

	/**
	 * Helps in generation of the total bill incurred by the user
	 * @param itemList is the ArrayList containing items in cart
	 * @return sum which is the total cost of all items in cart
	 */
	public static double generatebill(ArrayList<Item> itemList) {
		double sum = 0;
		for (int a = 0; a < itemList.size(); a++) {
			firstObject = itemList.get(a);
			/* Displays only the items which are present in cart */
			if (firstObject.getQuantity() != -1) {
				sum += firstObject.getQuantity() * firstObject.getPrice();
			}
		}
		return sum;
	}

	/**
	 * @param itemListNew is the ArrayList containing items
	 * @param serialNo is the serial number of item
	 * @return true if serial no is correct and false if serial no is incorrect
	 */
	public static boolean checkIfCartEmpty(ArrayList<Item> itemListNew, char serialNo) {
		int counter = 0;
		for (int b = 0; b < itemListNew.size(); b++) {
			firstObject = itemListNew.get(b);
			if (firstObject.getSerialNo() == serialNo) {
				counter = 1;
			}
		}
		if (counter == 0)
			return true;
		else
			return false;
	}

	/**
	 * This method helps in updating the items present in cart This may include
	 * changing the quantity of items which are present in the cart
	 * @param itemList is the ArrayList containing items in cart
	 */
    public static void updateCartItems(ArrayList<Item> itemList) {
		int check = 0; // counter for checking if cart is empty
		char serialNo; // serial no of item
                for (int k = 0; k < itemList.size(); k++) {
			firstObject = itemList.get(k);
			if (firstObject.getQuantity() != -1) {
				check = 1;
			}
		}
		/* Condition to check whether cart is empty or not */
		if (check == 0) {
			System.out.println("Sorry!! Your cart is empty");
		} else {
            int quantity; // Quantity of item
			int counter = 0;
			System.out.println("Enter serial no of the item to update");
			serialNo = in.next().charAt(0);
			if (checkIfCartEmpty(itemList, serialNo)) {
				System.out.println("Select a valid option please !!");
			} else {
				System.out.println("Enter the new quantity of item and add 0 for complete removal");
				quantity = in.nextInt();
				for (int j1 = 0; j1 < itemList.size(); j1++) {
					firstObject = itemList.get(j1);
					if (firstObject.getSerialNo() == serialNo) {
						counter = 1; /* Helps to find only those items which are in cart */
						if (quantity == 0) {
							firstObject.removeQuantity(-1);
						} else if (firstObject.getQuantity() > quantity) {/*Checks if the entered quantity item is less than the original*/
							firstObject.removeQuantity(quantity);
						} else { // System.out.println("HELLO");
							firstObject.setQuantity(quantity);/*For the complete removal of the item from the cart*/
						}
					}
				}
				if (counter == 0) {
					System.out.println("Please select the items from those in the cart !!");
				}
			}
		}
	}

	/*
	 * The main method adds the predefined items in the cart using ArrayList
	 * itemList and displays the menu to the user and calls appropriate methods
	 * @param args is unused
	 */
	public static void main(String args[]) {
		int choiceNumber;
		double totalCartValue = 0;
		char serialNoList[] = { 'a', 'b', 'c', 'd', 'e' };
		String itemNameList[] = { "Bags", "Shoes", "Watches", "Shirts", "Mobile" };
		double price[] = { 2500.89, 1000, 1500, 5000.78, 20000.50 };
		ArrayList<Item> itemList = new ArrayList<Item>();
		for (int i = 0; i < itemNameList.length; i++) {
			itemList.add(new Item(serialNoList[i], itemNameList[i], price[i], -1));
		}
		Scanner in = new Scanner(System.in);
		System.out.println("The menu list is as follows :");
		System.out.println("Serial No   " + " ItemName	" + "        Price ");
		for (int j = 0; j < itemList.size(); j++) {
			firstObject = itemList.get(j);
			System.out.println(firstObject.getSerialNo() + "         " + "    " + firstObject.getItem() + "\t\t"
					+ firstObject.getPrice());
		}
		try {
			System.out.println("Please Choose the option from the following");
			System.out.println("1 - Add Items ");
			System.out.println("2 - Remove/Update Items ");
			System.out.println("3 - Generate Bills ");
			System.out.println("4 - Display Items ");
			System.out.println("5 - Stop");
			while (true) {
				System.out.println("Please enter your choice from the list given from 1-5");
				choiceNumber = in.nextInt();
				switch (choiceNumber) {
				case 1:
					addToCart(itemList);
					break;
				case 2:
					updateCartItems(itemList);
					System.out.println("Item Updated Successfully");
					break;
				case 3:
					totalCartValue = generatebill(itemList);
					showCartItems(itemList);
					System.out.println("The total bill as of now is Rs." + totalCartValue);
					break;
				case 4:
					showCartItems(itemList);
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("Please choose a correct option from the given list");
				}
			}
		} catch (Exception e) {
			System.out.println("Please enter the specified format only !!");
		}
	}
}

/**
 * This class is defined to be used as custom ArrayList itemList 
 *It contains different data types and use the getters and setters method
 */
class Item {
	private char serialNo;
	private String itemName;
	private double price;
	private int quantity;

	Item(char serialNo, String itemName, double price, int quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
		this.serialNo = serialNo;
	}

	public String getItem() {
		return itemName;
	}

	public char getSerialNo() {
		return serialNo;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantityOfItem) {
		if (quantity == -1) {
			quantity = quantity + quantityOfItem + 1;
		} else {
			quantity = quantity + quantityOfItem;
		}
	}

	public void removeQuantity(int quantityToRemove) {
		quantity = quantityToRemove;
	}

}
