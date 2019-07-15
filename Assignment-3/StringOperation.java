package varunk;

public class StringOperation {

	public static void main(String[] args) {
		
		Operation object=new Operation();
		
		
	System.out.println(object.stringCompare("ODAY", "TODAY"));
	System.out.println(object.reverseOfString("varun th"));
	System.out.println(object.changeCase("TodAY is TheE"));
	System.out.println(object.largestString("varun is dong goo"));
	}

}
class Operation
{
	public int stringCompare(String first,String second)
	{int count=0;
		if(first==null || second==null)
		{
			return 0;
		}
		else if(first.length()!=second.length())
		{
			return 0;
		}
		else
		{
			for(int i=0;i<first.length();i++)
			{
				if(first.charAt(i)==second.charAt(i))
				{
				count++;	
				}
			}
			
		if(count==first.length())
			return 1;
		else
			return 0;
		
		}
	
	}
	public String reverseOfString(String value)
	{
		String reversedValue="";
		for(int j=0;j<value.length();j++)
		{
			reversedValue=value.charAt(j)+reversedValue;	
		}
		
		
	return reversedValue;
		
	}
	
	public String changeCase(String value)
	{
		String result="";
	for(int i=0;i<value.length();i++)
		{
	if(value.charAt(i)>='A' && value.charAt(i)<='Z')
	{
	result+=(char)((int)value.charAt(i)+32);	
	}
	else if(value.charAt(i)>='a' && value.charAt(i)<='z')
	{
		result+=(char)((int)value.charAt(i)-32);
	}
	else
	{
		result+=" ";
	}
		
	}
	
return result;
	
}
	public String largestString(String value)
	{
		value=value+" ";
	String word="";
	String maximumString="";

		for(int k=0;k<value.length();k++)
	{
		word=word+value.charAt(k);
		//System.out.println("MAXX "+word);
		if(value.charAt(k)==' ')
		{
			if(word.length()>=maximumString.length())
			{
			
				maximumString=word;
			}
			word="";
		}
		
		
	}
		
		return maximumString;
		
	}
	
	
	
	
	
}