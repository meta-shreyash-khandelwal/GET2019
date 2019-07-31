import java.util.*;
//Class performing polynomial operation
public class Poly {
	Map<Integer, Integer> polynomial;//HashMap containing key and value pair where key = Exponent and value = Coefficient in polynomial
//Constructor initializing Map 
	public Poly(Map<Integer, Integer> polynomial) {
		this.polynomial = polynomial;
	}
/**
 * This method helps in evaluating the  polynomial for the given value of the variable
 * @param coefficient is the variable value
 * @return double value containing the result of evaluation
 */
	double evaluate(float coefficient) {
		double result = 0;
		for (Integer key : polynomial.keySet()) {
			result += Math.pow(coefficient, key) * polynomial.get(key);
		}
		return result;
	}
/**
 * This method helps in calculating degree of the polynomial
 * @return the integer value containing the degree of polynomial
 */
	int degree() {
		int maximumDegree = -1;
		for (Integer key : polynomial.keySet()) {
			if (key > maximumDegree)
				maximumDegree = key;
		}
		return maximumDegree;
	}
/**
 * This method performs the addition of two polynomial 
 * @param firstPolynomial is the object containing first Polynomial to be added 
 * @param secondPolynomial is the object containing second Polynomial to be added 
 * @return the Map containing the addition of first and second polynomial
 */
	Map<Integer, Integer> addPoly(Poly firstPolynomial, Poly secondPolynomial) {
		try{if(firstPolynomial.polynomial==null || secondPolynomial.polynomial==null)
		{
			throw new Exception("Empty Polynomial");
		}}
		catch(Exception e)
		{
			System.out.println("Empty Polynomial Passed");
		}
		int firstDegree = firstPolynomial.degree();
		int secondDegree = secondPolynomial.degree();
		//For the First Polynomial Addition
		for (Integer key : firstPolynomial.polynomial.keySet()) {
				if (firstPolynomial.polynomial.get(key) == null) {
				 System.out.println("HERE"+key);
				firstPolynomial.polynomial.put(key, 0);
				polynomial.put(key, firstPolynomial.polynomial.get(key)
						+ secondPolynomial.polynomial.get(key));}

				else if (secondPolynomial.polynomial.get(key) == null) {
					
					secondPolynomial.polynomial.put(key, 0);
					polynomial.put(key, firstPolynomial.polynomial.get(key)
							+ secondPolynomial.polynomial.get(key));

				} else { 
					polynomial.put(key, firstPolynomial.polynomial.get(key)
							+ secondPolynomial.polynomial.get(key));
				}
			}
		//For the second Polynomial Addition
		for (Integer key : secondPolynomial.polynomial.keySet()) {
				if (firstPolynomial.polynomial.get(key) == null) {
				firstPolynomial.polynomial.put(key, 0);
				polynomial.put(key, firstPolynomial.polynomial.get(key)
						+ secondPolynomial.polynomial.get(key));}

				else if (secondPolynomial.polynomial.get(key) == null) {
					secondPolynomial.polynomial.put(key, 0);
					polynomial.put(key, firstPolynomial.polynomial.get(key)
							+ secondPolynomial.polynomial.get(key));

				} else {
					polynomial.put(key, firstPolynomial.polynomial.get(key)
							+ secondPolynomial.polynomial.get(key));
				}
			}

		return polynomial;
	}
/**
 * This method multiplies two polynomial and returns the result
 * @param firstPolynomial is the object containing first Polynomial to be multiplied
 * @param secondPolynomial is the object containing second Polynomial to be multiplied 
 * @return the HashMap containing the multiplication result of first polynomial and second polynomial 
 */
	Map<Integer, Integer> multiplyPolynomial(Poly firstPolynomial,
			Poly secondPolynomial) {
		try{if(firstPolynomial.polynomial==null || secondPolynomial.polynomial==null)
		{
			throw new Exception("Empty Polynomial");
		}}
		catch(Exception e)
		{
			System.out.println("Empty Polynomial Passed");
			System.exit(0);
		}
		int exponentFirst[] = new int[firstPolynomial.polynomial.size()];
		int exponentSecond[] = new int[secondPolynomial.polynomial.size()];
		Map<Integer, Integer> resultMultiply = new HashMap<Integer, Integer>();
		int index1 = 0;
		int index2 = 0;
		for (Integer key : firstPolynomial.polynomial.keySet()) {
			exponentFirst[index1] = key;
			index1++;
		}
		for (Integer key : secondPolynomial.polynomial.keySet()) {
			exponentSecond[index2] = key;
			index2++;
		}
		// System.out.println(":INDEX1+INDEXX2 "+exponentFirst[2]+" EDFD"+exponentSecond[1]);

		for (int i = 0; i < index1; i++) {
			for (int j = 0; j < index2; j++) {
				if (resultMultiply.get(exponentFirst[i] + exponentSecond[j]) == null) {
					// System.out.println("WE ARE  "+exponentFirst[i]+" EDFD"+exponentSecond[j]);
					resultMultiply.put(
							exponentFirst[i] + exponentSecond[j],
							firstPolynomial.polynomial.get(exponentFirst[i])
									* secondPolynomial.polynomial
											.get(exponentSecond[j]));
				} else {
					int previousValue = resultMultiply.get(exponentFirst[i]
							+ exponentSecond[j]);
					resultMultiply.put(
							exponentFirst[i] + exponentSecond[j],
							previousValue
									+ firstPolynomial.polynomial
											.get(exponentFirst[i])
									* secondPolynomial.polynomial
											.get(exponentSecond[j]));
					// System.out.println(":INDEX1+INDEXX2 in here "+exponentFirst[i]+"ER ER"+exponentSecond[j]);

				}
			}
		}
		return resultMultiply;
	}
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> h1 = new HashMap<Integer, Integer>();
		h1.put(4, 15);
		h1.put(3, 5);
		h1.put(2, 6);
		h1.put(0, -1);
		Poly p1 = new Poly(h1);
		System.out.println(" Evalute "+p1.evaluate(1f));
		System.out.println(" Degree "+p1.degree());
		Map<Integer, Integer> h2 = new HashMap<Integer, Integer>();
		h2.put(4, 10);
		h2.put(3, -18);
		h2.put(1, 7);
		h2.put(0, 10);
		Poly p2 = new Poly(h2);

		Map<Integer, Integer> h3 = new HashMap<Integer, Integer>();
		Poly p3 = new Poly(h3);
		p3.polynomial = p3.addPoly(p2, p1);
		System.out.println("ADDITION");

		for (Integer key : p3.polynomial.keySet()) {
			System.out.println("KEY = " + key + " VALUE "
					+ p3.polynomial.get(key));

			// result+=h1.get(key);
		}
		Map<Integer, Integer> h4 = new HashMap<Integer, Integer>();
		h4.put(3, 16);
		h4.put(1, -7);
		h4.put(0, -1);
		Poly p4 = new Poly(h4);
		Map<Integer, Integer> h5 = new HashMap<Integer, Integer>();

		h5.put(2, 2);
		h5.put(1, 3);

		Poly p5 = new Poly(h5);

		Map<Integer, Integer> h6 = new HashMap<Integer, Integer>();
		Poly p6 = new Poly(h6);
		p6.polynomial = p6.multiplyPolynomial(p4, p5);

		System.out.println("MULTIPLICATION");

		for (Integer key : p6.polynomial.keySet()) {
			System.out.println("KEY = " + key + " VALUE "
					+ p6.polynomial.get(key));

			// result+=h1.get(key);
		}

	}
*/
}
