package dataStructure;
import java.util.*;
public class MultivariatePolynomial {
	Map<Integer, ArrayList<Integer>> polynomial;//The key represents the term number starting from 1,2,3..
												//The values contain coefficient of each terms like F(x,y,y,w) x^3*y^2*z^1*w^2 will be [3,2,1,2]
	//Constructor will initialize 
	public MultivariatePolynomial() {
		polynomial = new HashMap<Integer, ArrayList<Integer>>();
	}
/**
 * This method adds the terms of multi variable  polynomial
 * @param termNumber is integer starting from 1,2,3 representing the term number
 * @param coefficient is the array list The values contain coefficient of each terms like F(x,y,y,w) x^3*y^2*z^1*w^2 will be [3,2,1,2]
 */
	public void addterms(int termNumber, ArrayList<Integer> coefficient) {
		polynomial.put(termNumber, coefficient);
	}
/**
 * This method checks all the polynomial terms and further calculates degree
 * @return the integer containing the degree of the given polynomial
 */
	public int getDegree() {
		//List<Integer> checking = new ArrayList<Integer>();
		int sumOfSingleTerm = 0;
		int degree = Integer.MIN_VALUE;
		Iterator iterate = polynomial.entrySet().iterator();
		ArrayList<Integer> allCoeficient = new ArrayList<Integer>();
		while (iterate.hasNext()) {
			sumOfSingleTerm = 0;
			Map.Entry pair = (Map.Entry) iterate.next();
			allCoeficient = (ArrayList) pair.getValue();
			for (int i = 0; i < allCoeficient.size(); i++) {
				sumOfSingleTerm += allCoeficient.get(i);
			}
			if (sumOfSingleTerm > degree) {
				degree = sumOfSingleTerm;
			}
		}
		return degree;
	}

}