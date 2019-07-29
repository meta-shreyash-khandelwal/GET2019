import java.util.*;

public class Factory {
	public static Shape createShape(Shape.ShapeType type,
			List<Integer> parameter, Point object) {
		switch (type) {//Using the factory design pattern to return the object of the specified type only on basis of user
		case SQUARE:
			return new Square(parameter, object);
		case RECTANGLE:
			return new Rectangle(parameter, object);
		case POLYGON:
			return new Polygon(parameter, object);
		case CIRCLE:
			return new Circle(parameter, object);
		case TRIANGLE:
			return new Triangle(parameter, object);
		default:
			return null;
		}

	}
}
