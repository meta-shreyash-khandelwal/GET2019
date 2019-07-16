import java.util.*;
/*Assuming String to be not null and case sensitive*/
public class StringOperation {
	public static void main(String[] args) {
		String firstString="";
		String secondString="";
		String value="";
		Scanner in=new Scanner(System.in);
		Operation object = new Operation();
		System.out.println("Enter the choice for String operation ");
		System.out.println("Enter 1 for comparing two String  ");
		System.out.println("Enter 2 for reversing a String ");
		System.out.println("Enter 3 for changing the case of a String ");
		System.out.println("Enter 4 for finding the largest word from a String ");
		System.out.println("Enter 5 for Exit ");
		        try
		        {
				int choice=in.nextInt();
				in.nextLine();
		         if(choice==1) {
		        System.out.println("Enter the first String");
				firstString=in.next();
				System.out.println("Enter the second String");
				secondString=in.next();
				if(object.stringCompare(firstString,secondString)==1)
				{
					System.out.println("The entered Strings are equal");
				}
				else
				{
					System.out.println("The entered Strings are not equal");
				}}
				else if(choice==2) {
				System.out.println("Enter the String to be reversed");
			    value=in.next();
			    System.out.println("The reversed String is : "+object.reverseOfString(value));
			   	}
				else if(choice==3) {
				System.out.println("Enter the String whose case is to be changed from lowercase to uppercase and vice-versa");
				value=in.next();
				System.out.println("The changed case of String is : "+object.changeCase(value));
			   	}
				else if(choice==4) {
				System.out.println("Enter the Sentence for finding the largest String");
				value=in.nextLine();
				System.out.println("The largest word of sentence is : "+object.largestString(value));
			   	}
				else if(choice==5)
				{
				System.exit(0);
				}
				else {
				System.out.println("Please choose the correct options only!! ");
			    main(args);
				}}
		        catch(Exception e)
		        {
		        System.out.println("Please choose valid values only!! ");
				main(args);
		        }
	}

}
class Operation {
/**
 * This method is used to compare two Strings
 * @param first is the first String to be compared
 * @param second is the second String to be compared
 * @return 1 if the two Strings are equals and 0 if the Strings are not equal
 */
	
public int stringCompare(String first, String second) {
		int count = 0;
		if (first == null || second == null) {
			return 0;
		} else if (first.length() != second.length()) {
			return 0;
		} else {
			for (int i = 0; i < first.length(); i++) {
				if (first.charAt(i) == second.charAt(i)) {
					count++;
				}
			}
			if (count == first.length())
				return 1;
			else
				return 0;

		}
	}
/**
 * This method is used to calculate the reverse of any String 
 * @param value is the String to be reversed
 * @return the reversed String of the given String
 */
public String reverseOfString(String value) {
		String reversedValue = "";
		for (int j = 0; j < value.length(); j++) {
			reversedValue = value.charAt(j) + reversedValue;
		}
		return reversedValue;
	}
/**
 * This method is used to change lowerCase into upperCase and vice-versa
 * @param value is the String whose case is to be changed
 * @return the String with its case changed
 */
	public String changeCase(String value) {
		String result = "";
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) >= 'A' && value.charAt(i) <= 'Z') {
				result += (char) ((int) value.charAt(i) + 32);
			} else if (value.charAt(i) >= 'a' && value.charAt(i) <= 'z') {
				result += (char) ((int) value.charAt(i) - 32);
			} else {
				result += " ";
			}

		}
		return result;
	}
/**
 * This method calculates the largest word in the given String	
 * @param value is the String containing the complete sentence
 * @return is the String containing the largest word
 */
	public String largestString(String value) {
		value = value + " ";
		String word = "";
		String maximumString = "";
		for (int k = 0; k < value.length(); k++) {
			word = word + value.charAt(k);
			// System.out.println("MAXX "+word);
			if (value.charAt(k) == ' ') {
				if (word.length() >= maximumString.length()) {

					maximumString = word;
				}
				word = "";
			}
		}
		return maximumString;
	}
}
