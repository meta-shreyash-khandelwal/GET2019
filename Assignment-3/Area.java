package varunk;
import java.util.*;
public class Area {

	
	public static double areaOfTriange(double width,double height)
	{
		return 0.5*width*height;
		
	}
	public static double areaOfRectangle(double width,double height)
	{
		return width*height;
		
	}
	public static double areaOfSquare(double width)
	{
		return width*width;
		
	}
	public static double areaOfCircle(double radius)
	{
		return Math.PI*radius*radius;
		
	}
	
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		double height=0,width=0,radius=0;
		int choice=0;
		System.out.println("Enter the choice from followong ");
		System.out.println("1 for calcuating area of Triangle ");
		System.out.println("2 for calcuating area of Rectangle ");
		System.out.println("3 for calcuating area of Square ");
		System.out.println("4 for calcuating area of Circle");
choice=in.nextInt();
switch(choice)
{
	case 1:
		System.out.println("Enter the base ");
width=in.nextDouble();
		System.out.println("Enter the height ");
height=in.nextDouble();
System.out.println("The area of the triangle is "+areaOfTriange(width,height));
		break;
	case 2:
		System.out.println("Enter the breadth ");
		width=in.nextDouble();
				System.out.println("Enter the length ");
		height=in.nextDouble();
		System.out.println("The area of the rectangle is "+areaOfRectangle(width,height));
					
		break;
	case 3:
		System.out.println("Enter the side ");
		width=in.nextDouble();
		System.out.println("The area of the square is "+areaOfSquare(width));
		break;
	case 4:
		System.out.println("Enter the radius ");
		radius=in.nextDouble();
		System.out.println("The area of the circle is "+areaOfCircle(radius));
	
		break;
	
	
	default:
		System.out.println("Please choose the correct option");

}
		
		
		
	}

}
