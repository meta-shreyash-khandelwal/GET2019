package varunk;
import java.util.*;
public class Polygon implements Shape {
private double side;
private double noOfSides;
Point  shapeOrigin;
Polygon(List<Integer> parameter,Point shapeOrigin)
{
	noOfSides=parameter.get(0);
	side=parameter.get(1);
	this.shapeOrigin=shapeOrigin;
}

public double getArea()
{
	return (side*side*noOfSides)/(4*Math.tan(Math.PI/noOfSides));
}
public double getPerimeter()
{
return noOfSides*side;	
}
public Point getOrigin()
{
	return shapeOrigin;
}
public Shape.ShapeType type()
{
	return Shape.ShapeType.POLYGON;
}
public boolean isPointEnclosed(Point toCheck)
{	double xOrigin=shapeOrigin.getX();
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
