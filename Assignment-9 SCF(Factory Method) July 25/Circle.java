import java.util.*;

public class Circle implements Shape {
	private double radius;
	private Point shapeOrigin;

	Circle(List<Integer> parameter, Point shapeOrigin) {
		radius = parameter.get(0);
		this.shapeOrigin = shapeOrigin;
	}
	/*Implementing all the methods implemented in Shape interface*/
	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	public Point getOrigin() {
		return shapeOrigin;
	}

	public Shape.ShapeType type() {
		return Shape.ShapeType.CIRCLE;
	}

	public boolean isPointEnclosed(Point toCheck) {
		double xCentre = shapeOrigin.getX();
		double yCentre = shapeOrigin.getY();
		double xCheck = toCheck.getX();
		double yCheck = toCheck.getY();
		double xDiff = Math.abs(xCentre - xCheck);
		double yDiff = Math.abs(yCentre - yCheck);

		double distance = Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
		if (distance <= radius)
			return true;
		else
			return false;
	}

}
