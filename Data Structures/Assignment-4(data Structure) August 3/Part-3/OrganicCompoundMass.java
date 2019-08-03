package dataStructure;
import java.util.*;
public class OrganicCompoundMass {
private Map<Character,Integer> knownElement;
private Stack<Integer> operation;
private Stack<Integer> subOperate;
public OrganicCompoundMass()
{
	knownElement=new HashMap<Character,Integer>();
	knownElement.put('C', 12);
	knownElement.put('O', 16);
	knownElement.put('H', 1);
	
	operation=new Stack<Integer>();
	subOperate=new Stack<Integer>();
}

public int calculateMass(String compound)
{
	int sumOfMass=0;
	int sumBrace=0;
	int totalElements=0;
	int position=0;
	for(int i=0;i<compound.length();i++)
	{
		sumBrace=0;
		System.out.println("coming "+i);
		
		if(compound.charAt(i)=='(')
		{
		position=i;	
		operation.push(-1);
		}
	
	
		
		else if(compound.charAt(i)=='C'||compound.charAt(i)=='H'||compound.charAt(i)=='O')
		{
		System.out.println("inserting "+knownElement.get(compound.charAt(i)));
		operation.push(knownElement.get(compound.charAt(i)));
		
		}
		
		
		
		else if(compound.charAt(i)>='1' && compound.charAt(i)<='9')
		{
				StringBuffer digit = new StringBuffer();
				while (i < compound.length() && compound.charAt(i) >= '0'// There may be more than one digits in number
						&& compound.charAt(i) <= '9')
					digit.append(compound.charAt(i++));
				System.out.println("DIGIT "+digit);
				subOperate.push(Integer.parseInt(digit.toString()));
				int topElement=subOperate.pop();
				System.out.println("TOP --"+topElement);
				//i=i-2;
				System.out.println("PUSH at  pos11 --"+topElement);
				int topElement2=operation.pop();
				System.out.println("PUSH at  pos insdide --"+topElement2);
				operation.push(topElement2*topElement);
				System.out.println("PUSH at  pos --"+topElement2*topElement);
				//System.out.println("PUSH at  pos --"+topElement2*topElement);
				if(i>=compound.length())
					break;
				i--;
		}	
			
		
		/*
		if(compound.charAt(i)>='1' && compound.charAt(i)<='9')
		{
			StringBuffer digit = new StringBuffer();
			while (i < compound.length() && compound.charAt(i) >= '0'// There may be more than one digits in number
					&& compound.charAt(i) <= '9')
				digit.append(compound.charAt(i++));
			operation.push(knownElement.get(compound.charAt(i)));
			
			
			
			
			
			
			
			
		

		//System.out.println("PUSH ING in 2 --"+topElement*(compound.charAt(i)-'0'));
		}
		
		
		*/
		

		
		else if(compound.charAt(i)==')')
		{
			while(operation.peek()!=-1)
			{
				sumBrace+=operation.pop();
				
			}
			operation.pop();
			System.out.println("SUmbrace"+sumBrace);
			//operation.push(sumBrace*(compound.charAt(i+1)-'0'));
			operation.push(sumBrace);
			
			//i++;
		}
	
	
		}

	System.out.println("PUSH ING in 2 --"+operation.size());
	totalElements=operation.size();
		for(int i=0;i<totalElements;i++)
		{	System.out.println("PUSH ING in 2 --"+operation.peek());
			sumOfMass+=(operation.pop());
			
		}
		
	
	return sumOfMass;
	
	
}



}
