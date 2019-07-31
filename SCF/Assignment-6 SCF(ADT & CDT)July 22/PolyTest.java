import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import java.util.*;
public class PolyTest {
	@Test
	public void testEvaluateShouldReturn_Evaluation_Of_Polynomial_According_To_VariablePassed_1() {
		Map<Integer, Integer> polynomial1=new HashMap<Integer, Integer>();
		polynomial1.put(3,16);
		polynomial1.put(1,-7);
		polynomial1.put(0,-1);
		Poly object1=new Poly(polynomial1);
		assertEquals(8f,object1.evaluate(1f),0.0f);
	}	
	@Test
	public void  testEvaluateShouldReturn_Evaluation_Of_Polynomial_According_To_VariablePassed_2() {
		Map<Integer, Integer> polynomial1=new HashMap<Integer, Integer>();
		polynomial1.put(3,16);
		polynomial1.put(1,-7);
		polynomial1.put(0,-1);
		Poly object1=new Poly(polynomial1);
		assertEquals(113f,object1.evaluate(2f),0.0f);
	}
	@Test
	public void  testEvaluateDegreeShouldReturn_Degree_Of_Polynomial() {
		Map<Integer, Integer> polynomial1=new HashMap<Integer, Integer>();
		polynomial1.put(4,16);
		polynomial1.put(3,-7);
		polynomial1.put(5,-1);
		Poly object1=new Poly(polynomial1);
		assertEquals(5,object1.degree());
	}
	@Test
	public void testaddPolyShouldReturn_Addition_Of_Two_Polynomials_1() {
		//Map<Integer, Integer> polynomial1=new HashMap<Integer, Integer>();
		Map<Integer, Integer> polynomial1 = new HashMap<Integer, Integer>();
		polynomial1.put(4, 15);
		polynomial1.put(3, 5);
		polynomial1.put(2, 6);
		polynomial1.put(0, -1);
		Poly p1 = new Poly(polynomial1);
		Map<Integer, Integer> polynomial2 = new HashMap<Integer, Integer>();
		polynomial2.put(4, 10);
		polynomial2.put(3, -18);
		polynomial2.put(1, 7);
		polynomial2.put(0, 10);
		Poly p2 = new Poly(polynomial2);

		Map<Integer, Integer> h3 = new HashMap<Integer, Integer>();
		Poly p3 = new Poly(h3);
		p3.polynomial = p3.addPoly(p2, p1);
		Map<Integer, Integer> polynomial4 = new HashMap<Integer, Integer>();
		polynomial4.put(4, 25);
		polynomial4.put(3, -13);
		polynomial4.put(1, 7);
		polynomial4.put(0, 9);
		polynomial4.put(2, 6);
		Poly p4 = new Poly(polynomial4);
		assertEquals(p4.polynomial,p3.polynomial);
	
	}
	@Test
	public void testaddPolyShouldReturn_Addition_Of_Two_Polynomials_2() {
		//Map<Integer, Integer> polynomial1=new HashMap<Integer, Integer>();
		Map<Integer, Integer> polynomial1 = new HashMap<Integer, Integer>();
		polynomial1.put(3, 5);
		polynomial1.put(2, 6);
		polynomial1.put(0, -1);
		Poly p1 = new Poly(polynomial1);
		Map<Integer, Integer> polynomial2 = new HashMap<Integer, Integer>();
		polynomial2.put(4, 10);
     	        polynomial2.put(1, 7);
		polynomial2.put(0, 10);
		Poly p2 = new Poly(polynomial2);

		Map<Integer, Integer> h3 = new HashMap<Integer, Integer>();
		Poly p3 = new Poly(h3);
		p3.polynomial = p3.addPoly(p2, p1);
		Map<Integer, Integer> polynomial4 = new HashMap<Integer, Integer>();
		polynomial4.put(3, 5);
		polynomial4.put(1, 7);
		polynomial4.put(0, 9);
		polynomial4.put(2, 6);
		polynomial4.put(4, 10);
		Poly p4 = new Poly(polynomial4);
		assertEquals(p4.polynomial,p3.polynomial);
	}
	@Test
	public void testMultiplyPolynomialShouldReturn_Multiplication_Of_Two_Polynomial() {
		//Map<Integer, Integer> polynomial1=new HashMap<Integer, Integer>();
		Map<Integer, Integer> polynomial1 = new HashMap<Integer, Integer>();
		polynomial1.put(3, 16);
		polynomial1.put(1,-7);
		polynomial1.put(0, -1);
		Poly p1 = new Poly(polynomial1);
		Map<Integer, Integer> polynomial2 = new HashMap<Integer, Integer>();
		polynomial2.put(2, 2);
     	        polynomial2.put(1, 3);
		Poly p2 = new Poly(polynomial2);

		Map<Integer, Integer> h3 = new HashMap<Integer, Integer>();
		Poly p3 = new Poly(h3);
		p3.polynomial =p3.multiplyPolynomial(p1,p2);
		Map<Integer, Integer> polynomial4 = new HashMap<Integer, Integer>();

		polynomial4.put(5, 32);
		polynomial4.put(4, 48);
		polynomial4.put(3, -14);
		polynomial4.put(2, -23);
		polynomial4.put(1, -3);
		
		Poly p4 = new Poly(polynomial4);
		assertEquals(p4.polynomial,p3.polynomial);
	}
}
