import static org.junit.Assert.*;
import java.util.*;
import java.util.List;
import org.junit.Test;
import org.junit.After;
import org.junit.*;
public class ScreenTest {
	static Screen object1 = new Screen();

	@Test
	/* Adding all the shapes and checking all their methods */
	public void testAddShape() {

		List<Integer> parameter = new ArrayList<Integer>();
		parameter.add(5);
		Point object2 = new Point(3, 5);
		object1.addShape(Shape.ShapeType.SQUARE, parameter, object2);

		List<Integer> parameter2 = new ArrayList<Integer>();
		parameter2.add(6);
		parameter2.add(8);
		Point object3 = new Point(2, 6);
		object1.addShape(Shape.ShapeType.RECTANGLE, parameter2, object3);

		List<Integer> parameter3 = new ArrayList<Integer>();
		parameter3.add(7);
		Point object4 = new Point(3, 8);
		object1.addShape(Shape.ShapeType.CIRCLE, parameter3, object4);

		List<Integer> parameter4 = new ArrayList<Integer>();
		parameter4.add(10);
		parameter4.add(8);
		parameter4.add(5);
        //Added all the shapes of specified type and their points
		Point object5 = new Point(4, 9);
		object1.addShape(Shape.ShapeType.TRIANGLE, parameter4, object5);

		System.out.println("Total number of shapes are "
				+ object1.listFigure.size());

		System.out.println("The area of square is "
				+ object1.listFigure.get(0).getArea());
		System.out.println("The area of rectangle is "
				+ object1.listFigure.get(1).getArea());
		System.out.println("The area of circle is "
				+ object1.listFigure.get(2).getArea());
		System.out.println("The area of triangle is "
				+ object1.listFigure.get(3).getArea());

		
		System.out.println();
		System.out.println("The perimeter of square is "
				+ object1.listFigure.get(0).getPerimeter());
		System.out.println("The perimeter of rectangle is "
				+ object1.listFigure.get(1).getPerimeter());
		System.out.println("The perimeter of circle is "
				+ object1.listFigure.get(2).getPerimeter());
		System.out.println("The perimeter of triangle is "
				+ object1.listFigure.get(3).getPerimeter());

				
		System.out.println();
		assertEquals(4, object1.listFigure.size());

	}
	@Test(expected = Exception.class)
	public void whenExceptionThrown_thenExpectationSatisfied() {
		object1.deleteShape(null);
	    
	}
	
	 @AfterClass
	 public static void testDeleteShape() {
	 System.out.println("Total number of shapes before deletion  "
	 +object1.listFigure.size());
	 
	  Point object6=new Point(3,5); object1.deleteShape(object6); Point
	 object7=new Point(3,8); object1.deleteShape(object7);
	  
	 //We have deleted shape present at (3,5) which is square
	 System.out.println("Total number of shapes after deletion "+object1.listFigure.size());
	 assertEquals(2,object1.listFigure.size());//Two shapes deleted out of four
 	 } 
	 
	 @AfterClass
	 public static void testDeleteAllShape() { object1.deleteAllShape();
	 System.out.println("Total number of shapes after deletion of all "+object1
	 .listFigure.size()); 
	 assertEquals(0,object1.listFigure.size());
	  }
	
	@After
	public void testSortedOrderOnBasisOfChoice() {
		List<Shape> sorted = new ArrayList<Shape>();
		sorted = object1.sortedOrder("Area");
		System.out.println("Sorted on basis of area ");
		for (int i = 0; i < sorted.size(); i++) {
			System.out.println(sorted.get(i).type() + " "
					+ sorted.get(i).getArea());
		}
		System.out.println();
		List<Shape> sortedPerimeter = new ArrayList<Shape>();
		sortedPerimeter = object1.sortedOrder("Perimeter");
		System.out.println("Sorted on basis of Perimeter ");
		for (int i = 0; i < sortedPerimeter.size(); i++) {
			System.out.println(sortedPerimeter.get(i).type() + " "
					+ sortedPerimeter.get(i).getPerimeter());
		}
	}
	@After
	public void testEnclosingShape_AllTheEclosingShapes() {
		List<Shape> enclosed = new ArrayList<Shape>();
		Point specified = new Point(3,2);
		enclosed = object1.enclosingShape(specified);
		System.out.println();
		System.out.println("Following are the shapes which cover the specified point");
        
		for (int i = 0; i < enclosed.size(); i++) {
			System.out.println(enclosed.get(i).type() + " x= "
					+ enclosed.get(i).getOrigin().getX() + " y= "
					+ enclosed.get(i).getOrigin().getY());
		}
		System.out.println();
	}
}
