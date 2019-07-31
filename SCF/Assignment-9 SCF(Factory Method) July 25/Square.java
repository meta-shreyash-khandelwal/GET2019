package varunk;
import java.util.*;
public class Square implements Shape {
private double side;
Point   shapeOrigin;
Square(List<Integer> parameter,Point shapeOrigin)
{
	this.side=parameter.get(0);
	this.shapeOrigin=shapeOrigin;
}

public double getArea()
{
	return side*side;
}
public double getPerimeter()
{
return 4*side;	
}
public Point getOrigin()
{
	return shapeOrigin;
}
public Shape.ShapeType type()
{
	return Shape.ShapeType.SQUARE;
}
public boolean isPointEnclosed(Point toCheck)
{
	double xOrigin=shapeOrigin.getX();
	double yOrigin=shapeOrigin.getY();
	double xCheck=toCheck.getX();
	double yCheck=toCheck.getY();
	if(xCheck>= xOrigin && xCheck<=(xOrigin+side))
	{
		if(yCheck>= yOrigin && yCheck<=(yOrigin+side))
		{
			return true;
		}
			
	}
	return false;
}	
	
	
}
	

