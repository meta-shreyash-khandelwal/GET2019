package varunk;
import java.util.*;
public class Poly {
Map<Integer,Integer> polynomial;
public Poly()
{
	polynomial=new HashMap<Integer,Integer>();
}
double evaluate(float coefficient)
{
double result=0;
for(Integer key:polynomial.keySet())
{
	result+=Math.pow(coefficient, key)*polynomial.get(key);
}
return result;
}

int degree()
{
	int maximumDegree=-1;
	for(Integer key:polynomial.keySet())
	{
		if(key>maximumDegree)
			maximumDegree=key;
	}
	return maximumDegree;
}

Map<Integer,Integer> addPoly(Poly firstPolynomial, Poly secondPolynomial)
{
	int firstDegree=firstPolynomial.degree();
	int secondDegree=secondPolynomial.degree();
polynomial
		
}

Map<Integer,Integer> multiplyPoly(Poly firstPolynomial, Poly secondPolynomial) 
{
	
}


	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
