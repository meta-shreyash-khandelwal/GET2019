/*It is assumed that all the numbers are positive integers*/
public class HCFAndLCM {
/**
 * This method returns the HCF or GCD of two numbers
 * @param firstNumber is the integer having first Number
 * @param secondNumber is the integer of second number
 * @return the integer value containing the HCF of firstNumber and  secondNumber otherwise returns -1
 */
	public int hcfOfTwoNumber(int firstNumber,int secondNumber)
	{
		if(firstNumber==0)
		{
			return secondNumber;
		}
		else
		{
			return hcfOfTwoNumber(secondNumber%firstNumber,firstNumber);
		}
	}
/**
 * This method returns the LCM of two numbers 
 * @param firstNumber is the integer having first Number
 * @param secondNumber is the integer of second number
 * @return the LCM integer of firstNumber and  secondNumber
 */
public int lcmOfTwoNumber(int firstNumber,int secondNumber)
	{
	    try{
		if(firstNumber==0 || secondNumber==0)
		{
		throw new ArithmeticException();
		}
	    }catch(Error e){System.out.println("Number cannot be zero !!");}
		int productOfTwoNumber=firstNumber*secondNumber;
		int gcdOfTwoNumber=hcfOfTwoNumber(firstNumber,secondNumber);
		return productOfTwoNumber/gcdOfTwoNumber;
		}
}
