import java.util.*;

public class Screen {
	List<Shape> listFigure;

	public Screen() {
		listFigure = new ArrayList<Shape>();
	}
/**
 * This method adds the shapes of specified object to list of shape
 * @param type is the shape type on the basis of interface
 * @param parameter is the no of parameter which is given on basis of shape type like 2 for rectangle, 1 for square
 * @param object is the points of origin in which object starts
 */
	public void addShape(Shape.ShapeType type, List<Integer> parameter,
			Point object) {
		Shape figure;
		figure = Factory.createShape(type, parameter, object);
		try{
		if(figure == null)
		{
			throw new Exception("Empty object");
		}}catch(Exception e)
		{
			System.out.println("The object is empty");
		}
		listFigure.add(figure);
	}
/**
 * This method deletes the shape object of specified type on basis of origin
 * @param object is the x and y coordinates of object
 */
	public void deleteShape(Point object) {
		try{
			if(object == null)
			{
				throw new Exception("Empty object");
			}}catch(Exception e)
			{
				System.out.println("The object is empty");
			}
		for (int i = 0; i < listFigure.size(); i++) {
			if (listFigure.get(i).getOrigin().getX() == object.getX()
					&& listFigure.get(i).getOrigin().getY() == object.getY()) {
				listFigure.remove(i);
				break;
			}
		}

	}
/**
 * This method deletes all the objects of shape created
 */
	public void deleteAllShape() {
		listFigure.clear();
	}
/**
 * This method sorts the shape objects on the basis of the choice like perimeter and area
 * @param choice is String containing the choice on which sorting needs to be done
 * @return the list of shape object sorted according to choice
 */
	public List<Shape> sortedOrder(String choice) {
		
		if ("Area".equals(choice)) {
			Collections.sort(listFigure, new Comparator<Shape>() {
				@Override
				public int compare(Shape firstObject, Shape secondObject) {
					return Double.compare(firstObject.getArea(),
							secondObject.getArea());
				}
			});
			return listFigure;
		} else if ("Perimeter".equals(choice)) {
			Collections.sort(listFigure, new Comparator<Shape>() {
				@Override
				public int compare(Shape firstObject, Shape secondObject) {
					return Double.compare(firstObject.getPerimeter(),
							secondObject.getPerimeter());
				}
			});
			return listFigure;
		}
		return null;
	}
/**
 * This method returns the list of objects in a way that they lie in the specified point region
 * @param specified is the point which contain the coordinates required for checking enclosed figure
 * @return the answer which is list of shape objects which encloses the specifies point
 */
	public List<Shape> enclosingShape(Point specified) {
		List<Shape> answer = new ArrayList<Shape>();
		try{
			if(specified == null)
			{
				throw new Exception("Empty object");
			}}catch(Exception e)
			{
				System.out.println("The object is empty");
			}
		for (int i = 0; i < listFigure.size(); i++) {
			if (listFigure.get(i).isPointEnclosed(specified)) {
				answer.add(listFigure.get(i));
			}

		}
		return answer;
	}

}
