package varun;

import java.util.*;
/**
 *This program helps in performing tasks related to 
 *shopping carts namely adding item,updating items list ,generating bills
 *display carts
 */
public class ShoppingCart {
	static Item obj;
	static Scanner in = new Scanner(System.in);

	/**
	 * Helps to add the items in the cart by using the ArrayList i1 defined and
	 * comparing the user entered value
	 * @param i1 is the ArrayList containing items in cart
	 */
	public static void add(ArrayList<Item> i1) {
		
		int q;// quantity
			char c;

		System.out.println("Enter the serial number from the item from the above list");
		c = in.next().charAt(0);
/*
 * It helps in tracking where the cart is
 * empty or not
 * 
 */
		if(empty(i1,c))
		{

			System.out.println("Select a valid option please !!");
		}
		
		
		else
		{
		
			
			System.out.println("Enter quantity of the item");
			q = in.nextInt();
			for (int m = 0; m < i1.size(); m++) {

				obj = i1.get(m);
				if (obj.getserialno() == c) {
					obj.setquantity(q);
				}

			}
		
		
		
		}

	}

	/**
	 * This method displays all the contents present in the cart and shows a
	 * message if no items are present in cart
	 */
	public static void showCart(ArrayList<Item> i1) {
		int check = 0;

		for (int j = 0; j < i1.size(); j++) {

			obj = i1.get(j);
			if (obj.getquantity() != -1) {
				check = 1;
			}
		}

		if (check == 0) {
			System.out.println("Sorry!! No items  in cart!!");
		} else {

			System.out.println("Your item contents are as follows");
			System.out.println("Itemname" + "\t" + "Quantity" + "\t"
					+ "Total Price");

			for (int j = 0; j < i1.size(); j++) {

				obj = i1.get(j);
				if (obj.getquantity() != -1) {
					System.out.println(obj.getitem() + "\t\t"
							+ obj.getquantity() + "\t\t" + obj.getquantity()
							* obj.getprice());
					check = 1;
				}
			}

		}
	}

	/**
	 * Helps in generation of the total bill incurred by the user
	 *  @param i1 is the ArrayList containing items in cart
	 * @return sum which is the total cost of all items in cart
	 */
	public static double generatebill(ArrayList<Item> i1) {
		double sum = 0;

		for (int a = 0; a < i1.size(); a++) {

			obj = i1.get(a);
			/* Displays only the items which are present in cart */
			if (obj.getquantity() != -1) {
				sum += obj.getquantity() * obj.getprice();
			}

		}

		return sum;

	}
/**
*@param i2 is the ArrayList containing items
*@param ch is the serial number of item
*@return true if serial no is correct and false if serial no is incorrect
*/

	public static boolean empty(ArrayList<Item> i2,char ch)
	{
		int k=0;
	for (int b = 0; b < i2.size(); b++) {

		obj = i2.get(b);
		if (obj.getserialno() == ch) {
			k=1;
		}
		
	}
	/* It tells the user about wrong entered item 
	if (counter == 0) {
		System.out.println("Please select the valid format for items from the given list only !!");

	} else {
		
		*/
		if(k==0)
			return true;
		else
			return false;
		
		
	}
	/**
	 * This method helps in updating the items present 
	 * in cart This may include
	 * changing the quantity of items which are present in the cart
	 *  @param i1 is the ArrayList containing items in cart
	 */
		
	public static void updateitems(ArrayList<Item> i1) {
		int check = 0;// counter for checking if cart is empty
		char ch;// serial no of item
		for (int k = 0; k < i1.size(); k++) {

			obj = i1.get(k);
			if (obj.getquantity() != -1) {
				check = 1;
			}
		}
/*Condition to check whether cart is empty or not*/
		if (check == 0) {
			System.out.println("Sorry!! Your cart is empty");
		} else {

			int qt;// Quantity of item
			int counter = 0;
			System.out.println("Enter serial no of the item to update");

			ch = in.next().charAt(0);
				
			if(empty(i1,ch))
			{

				System.out.println("Select a valid option please !!");
			}
			
			
			else
			{
			
			System.out.println("Enter quantity");
			qt = in.nextInt();

			for (int j1 = 0; j1 < i1.size(); j1++) {
				obj = i1.get(j1);
				if (obj.getserialno() == ch) {
					counter = 1; /* Helps to find only items in cart */
					obj.setquantity(qt);

					if (obj.getquantity() == 0) {
						obj.setquantity(-1);
					}

				}

			}
			if (counter == 0) {
				System.out
						.println("Please select the items from those in the cart !!");

			}
		}}
	}

	/*
	 * The main method adds the predefined items in the cart using ArrayList i1
	 * and displays the menu to the user and calls appropriate methods
	 *  @param args is unused
	 */
	public static void main(String args[]) {
		int n;
		double total = 0;
		char sno[] = { 'a', 'b', 'c', 'd', 'e' };
		String itemname[] = { "Bags", "Shoes", "Watches", "Shirts", "Mobile" };
		double price[] = { 2500.89, 1000, 1500, 5000.78, 20000.50 };
		ArrayList<Item> i1 = new ArrayList<Item>();
		for (int i = 0; i < itemname.length; i++) {
			i1.add(new Item(sno[i], itemname[i], price[i], -1));

		}

		Scanner in = new Scanner(System.in);
		System.out.println("The menu list is as follows :");
		System.out.println("Serial No   " + " ItemName	" + "       Price ");
		for (int j = 0; j < i1.size(); j++) {

			obj = i1.get(j);

			System.out.println(obj.getserialno() + "         " + "    "
					+ obj.getitem() + "\t\t"+obj.getprice());
		}
		System.out.println("Please Choose the option from the following");
		System.out.println("1 - Add Items ");
		System.out.println("2 - Remove/Update Items ");
		System.out.println("3 - Generate Bills ");
		System.out.println("4 - Display Items ");
		System.out.println("5 - Stop");

		while (true) {
			System.out.println("Enter your choice please");
			n = in.nextInt();

			switch (n) {
			case 1:
				add(i1);
				break;

			case 2:
				updateitems(i1);
				break;

			case 3:
				total = generatebill(i1);
				showCart(i1);
				System.out.println("The total bill as of now is Rs." + total);
				break;

			case 4:
				showCart(i1);
				break;

			case 5:
				System.exit(0);
				break;

			default:
				System.out
						.println("Please choose a correct option from the given list");
			}

		}

	}
}

/**
 * This class is defined to be used as custom ArrayList i1 It contains different
 * data types and use the getters and setters method
 */
class Item {
	private char serialno;
	private String Itemname;
	private double price;
	private int quantity;

	Item(char serialno, String Itemname, double price, int quantity) {

		this.Itemname = Itemname;
		this.price = price;
		this.quantity = quantity;
		this.serialno = serialno;
	}

	public String getitem() {
		return Itemname;
	}

	public char getserialno() {
		return serialno;
	}

	public double getprice() {

		return price;

	}

	public int getquantity() {
		return quantity;
	}

	public void setquantity(int q) {
		quantity = q;
	}

}