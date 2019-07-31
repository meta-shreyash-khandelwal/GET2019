package varunk;
import java.util.*;
public class Rectangle implements Shape {
private double length;
private double breadth;
Point   shapeOrigin;
Rectangle(List<Integer> parameter,Point shapeOrigin)
{
	length=parameter.get(0);
	breadth=parameter.get(1);
	this.shapeOrigin=shapeOrigin;
}

public double getArea()
{
	return length*breadth;
}
public double getPerimeter()
{
return 2*(length+breadth);	
}
public Point getOrigin()
{
	return shapeOrigin;
}
public Shape.ShapeType type()
{
	return Shape.ShapeType.RECTANGLE;
}
public boolean isPointEnclosed(Point toCheck)
{
	double xOrigin=shapeOrigin.getX();
	double yOrigin=shapeOrigin.getY();
	double xCheck=toCheck.getX();
	double yCheck=toCheck.getY();
	if(xCheck>= xOrigin && xCheck<=(xOrigin+length))
	{
		if(yCheck>= yOrigin && yCheck<=(yOrigin+breadth))
		{
			return true;
		}
			
	}
	return false;
}	
	
	
	

}
