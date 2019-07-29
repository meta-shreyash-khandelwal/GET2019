package varunk;
import java.util.*;
public class Triangle implements Shape {
private double sideFirst;
private double sideSecond;
private double sideThird;

Point   shapeOrigin;
Triangle(List<Integer> parameter,Point shapeOrigin)
{
	sideFirst=parameter.get(0);
	sideSecond=parameter.get(1);
	sideThird=parameter.get(2);
	this.shapeOrigin=shapeOrigin;
}

public double getArea()
{
	double sideMean=(getPerimeter())/2;
	return Math.sqrt(sideMean*(sideMean-sideFirst)*(sideMean-sideSecond)*(sideMean-sideThird));
}
public double getPerimeter()
{
return (sideFirst+sideSecond+sideThird);	
}
public Point getOrigin()
{
	return shapeOrigin;
}
public Shape.ShapeType type()
{
	return Shape.ShapeType.TRIANGLE;
}

private double calculateArea(double xFirst,double yFirst,double xSecond,double ySecond,double xThird,double yThird)
{
	 return Math.abs((xFirst*(ySecond-yThird))+(xSecond*(yThird-yFirst))+(xThird*(yFirst-ySecond)))/2;	
	
	
}



public boolean isPointEnclosed(Point toCheck)
{
double xCheck=toCheck.getX();
double yCheck=toCheck.getY();

double leftX=shapeOrigin.getX();
double leftY=shapeOrigin.getY();

double rightX =sideThird+leftX;
double rightY =leftY;

double topX=(leftX+rightX)/2;

double angle=Math.acos((sideFirst*sideFirst)+(sideThird*sideThird)-(sideSecond*sideSecond)/(2*sideFirst*sideThird));
double  height=Math.sin(angle)*sideFirst;

double topY=leftY+height;


double areaFirst=calculateArea(xCheck,yCheck,rightX,rightY,topX,topY);
double areaSecond=calculateArea(leftX,leftY,xCheck,yCheck,rightX,rightY);
double areaThird=calculateArea(leftX,leftY,rightX,rightY,xCheck,yCheck);

double sum=areaFirst+areaSecond+areaThird;
if(sum==getArea())
	return true;
else
	return false;
	
	
}
	
	
	
	

}
