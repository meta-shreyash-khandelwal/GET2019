import java.util.Scanner;
/* An interface is provided for generalizing the methods for any base */
interface conversion {
	int integerEquivalent(char value);
	char characterEquivalent(int decimalValue);
	int hexadecimalToDecimal(String hexNumber, int base);
	String decimalToHexadecimal(int decimal, int base);
	String additionOfHexadecimal(String firstNo, String secondNo, int base);
	String subtractionOfHexadecimal(String firstNo, String secondNo, int base);
	String multiplicationOfHexadecimal(String firstNo, String secondNo, int base);
	String divisionOfHexadecimal(String firstNo, String secondNo, int base);
	boolean comparinggreaterHexadecimal(String firstNo, String secondNo);
}
/*Class takes only positive number it is assumed */
public class HexCalc {
/* It finds the integer equivalent of any character
 * @param value takes the character to be converted
 * @return the integer value of char
 */
	public static int integerEquivalent(char value) {
		if (value >= '0' && value <= '9')
			return (int) (value) - '0';
		else
			return (int) (value) - 'A' + 10;

	}
/** It finds the character equivalent of an integer	
 * @param decimalValue takes the integer value to be converted
 * @return the character equivalent of the integer value
 */
	public static char characterEquivalent(int decimalValue) {
		if (decimalValue >= 0 && decimalValue <= 9)
			return (char) (decimalValue + '0');
		else
			return (char) (decimalValue - 10 + 'A');

	}
/**
 * This functions converts Hexadecimal number into equivalent Decimal number
 * @param hexNumber is the Hexadecimal String to be converted
 * @param base is the base of number , here it is 16
 * @return the equivalent decimal value of the hexadecimal number
 */
	public static int hexadecimalToDecimal(String hexNumber, int base) {
		int decimal = 0;
		for (int i = hexNumber.length() - 1; i >= 0; i--) {
					decimal += (int) (integerEquivalent(hexNumber.charAt(i))
					* Math.pow(base, hexNumber.length() - 1 - i));
			}
		return decimal;
	}
/**
 * This method converts the decimal number into a Hexadecimal string
 * @param decimal is the number to be converted into Hexadecimal number
 * @param base is the base of number in which it is converted , here 16
 * @return the equivalent Hexadecimal String of the decimal number
 */
	public static String decimalToHexadecimal(int decimal, int base) {
		String sample = "";
		while (decimal != 0) {
			sample = characterEquivalent(decimal % base) + sample;
			decimal = decimal / base;
		}
		return sample;
	}
/**
 * This method is responsible for adding two Hexadecimal numbers
 * @param first is the first number in String to be added
 * @param second is the second number in String to be added
 * @param base is the base in which the number are added
 * @return the addition value of first and second by converting them into decimal and vice-versa
 */
	public static String additionOfHexadecimal(String firstNo, String secondNo,
			int base) {
		int result = 0;
		int firstNumber = hexadecimalToDecimal(firstNo, base);
		int secondNumber = hexadecimalToDecimal(secondNo, base);
		result = firstNumber + secondNumber;
		return decimalToHexadecimal(result, 16);
	}
/**
 * This method is responsible for subtracting two Hexadecimal numbers
 * @param first is the first number in String to be subtracted
 * @param second is the second number in String to be subtracted
 * @param base is the base in which the number are subtracted
 * @return the difference value of first and second i.e. first -second
 */
	public static String subtractionOfHexadecimal(String firstNo, String secondNo,
			int base) {
		int result = 0;
		int firstNumber = hexadecimalToDecimal(firstNo, base);
		int secondNumber = hexadecimalToDecimal(secondNo, base);
		result = firstNumber - secondNumber;
		return decimalToHexadecimal(result, 16);
	}
/**
 * This method is responsible for multiplication two Hexadecimal numbers
 * @param first is the first number in String to be multiplied
 * @param second is the second number in String to be multiplied
 * @param base is the base in which the number are multiplied
 * @return the multiplication value of first and second by converting them into decimal and vice-versa
 */
	public static String multiplicationOfHexadecimal(String firstNo,
			String secondNo, int base) {
		int result = 0;
		int firstNumber = hexadecimalToDecimal(firstNo, base);
		int secondNumber = hexadecimalToDecimal(secondNo, base);
		result = firstNumber * secondNumber;
		return decimalToHexadecimal(result, 16);
	}
/**
 * This method is responsible for division of two Hexadecimal numbers
 * @param first is the first number in String to which is dividend
 * @param second is the second number in String to be divisor
 * @param base is the base in which the number are divided
 * @return the divisor value i.e first/second in Hexadecimal String
 */
	public static String divisionOfHexadecimal(String firstNo, String secondNo,
			int base) {
		int result = 0;
		int firstNumber = hexadecimalToDecimal(firstNo, base);
		int secondNumber = hexadecimalToDecimal(secondNo, base);
		try {
			result = firstNumber / secondNumber;
		} catch (ArithmeticException e) {
			System.out.println("Attempted to divide by 0 !!");
			main(args);
		}

		return decimalToHexadecimal(result, 16);
	}
	
/**
 * This method checks whether correct Hexadecimal String is added	
 * @param check is the String to be checked for Exception
 * @return the boolean true if correct String is added and false if incorrect Hexadecimal is passed
 */
public static boolean checking(String check)
	{
		int count=0;
		for(int i=0;i<check.length();i++)
		{
			if(check.charAt(i)>'F' || check.charAt(i)<'0')
			{
			count++;
			}
		}
		if(count==0)
			return true;
		else
			return false;
}
	
/**
 * This method checks the equality of two Hexadecimal Numbers
 * @param first is the first Hexadecimal number
 * @param second is the second Hexadecimal number
 * @return the boolean true if the numbers are equals otherwise it returns the value false.
 */
	public static boolean equalityOfHexadecimal(String firstNo, String secondNo) {
		if(firstNo==null && secondNo==null)
			return true;
		if(firstNo==null ||secondNo==null)
			return false;

		return firstNo.equals(secondNo);
	}
/**
 * This method is responsible for comparing two Hexadecimal numbers
 * @param first is the first Hexadecimal number
 * @param second is the second Hexadecimal number
 * @return the value true if first>second and false if first<second
 */
	public static boolean comparinggreaterHexadecimal(String firstNumber,
			String secondNumber) {
		int counter1 = 0;
		int counter2 = 0;
		if(firstNumber==null && secondNumber!=null)
			return false;
		if(secondNumber==null && firstNumber!=null)
		{
			//System.out.println("FEER");
			return true;
		}
		if (firstNumber.length() == secondNumber.length()) {
			for (int i = 0; i < firstNumber.length(); i++) {
				if (firstNumber.charAt(i) > secondNumber.charAt(i)) {
					counter1++;
				}
			}

			if (counter1 > 0) {
				return true;
			} else {
				return false;

			}

		} else {
		    /*This regular expression removes all the leading 0's from Hexadecimal number for unequal length comparision*/
		    
			firstNumber = firstNumber.replaceAll("^(\\s*0\\s*0\\s*)+", "");
			secondNumber = secondNumber.replaceAll("^(\\s*0\\s*0\\s*)+", "");
			if (firstNumber.length() > secondNumber.length()) {
				counter2++;
			}

		}
		if (counter2 > 0) {
			return true;
		} else {
			return false;
		}
	}

    public static void main(String[] args) {
		String firstNumber = "";
		String secondNumber = "";
		String firstNumber1 = "";
		String secondNumber1 = "";
		
		Scanner in = new Scanner(System.in);
		int option = 0;
		try
		{
		System.out.println("Please Enter 1 for Hexadecimal Arithmetic and 2 for Hexadecimal Comparision ");
		option = in.nextInt();
		
		switch (option) {
			    case 1 :
				System.out.println("Please Enter two positive Hexadecimal String ! first greater than second");
				firstNumber = in.next();
				secondNumber = in.next();
				if(checking(firstNumber)==false || checking(secondNumber)==false)
				{
			    throw new Exception("Invalid ");
			    }
				System.out.println("The decimal equivalent of first Hexadecimal number is "
								+ hexadecimalToDecimal(firstNumber, 16));
				System.out.println("The decimal equivalent of second Hexadecimal number is "
								+ hexadecimalToDecimal(secondNumber, 16));
				System.out.println("The addition of these two Hexadecimal number is "
								+ additionOfHexadecimal(firstNumber,
										secondNumber, 16));
				System.out.println("The subtraction of these two Hexadecimal number is "
								+ subtractionOfHexadecimal(firstNumber,
										secondNumber, 16));
				if(comparinggreaterHexadecimal(firstNumber,secondNumber)==false)
				{
					System.out.println("Further not possible");
					throw new Exception("Not Further");
				}
				System.out.println("The multiplication of these two Hexadecimal number is "
								+ multiplicationOfHexadecimal(firstNumber,
										secondNumber, 16));
				System.out.println("The division of these two Hexadecimal number is "
								+ divisionOfHexadecimal(firstNumber,
										secondNumber, 16));
				break;
       			case 2 :
				System.out.println("Please Enter two positive Hexadecimal String !");
				firstNumber1 = in.next();
				secondNumber1 = in.next();
				if(checking(firstNumber1)==false || checking(secondNumber1)==false)
				{
			        throw new Exception("Invalid ");
				}
				
				if (equalityOfHexadecimal(firstNumber1, secondNumber1)) {
					System.out.println("These two Hexadecimal numbers are equal !!");

				} else if (comparinggreaterHexadecimal(firstNumber1,
						secondNumber1)) {
					System.out.println("First Number is greater than Second number");

				} else {
					System.out.println("Second Number is greater than First number");

				}
				
				break;
			    default :
				System.out.println("Please choose the correct option !!");
				main(args);
		}
		}
		catch(Exception e)
		{
			System.out.println("Invalid input entered Try Again !!");
			main(args);
		}

	}
}
