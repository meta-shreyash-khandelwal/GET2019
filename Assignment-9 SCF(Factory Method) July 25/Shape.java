public interface Shape {
	enum ShapeType {
		SQUARE, RECTANGLE, CIRCLE, TRIANGLE, POLYGON
	}

	Shape.ShapeType type();
	double getArea();
	double getPerimeter();
	Point getOrigin();
	boolean isPointEnclosed(Point enclose);
}
