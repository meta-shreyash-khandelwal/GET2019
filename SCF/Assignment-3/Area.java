import java.util.*;
/*This class calculates the area of different shapes*/
public class Area {
/**
 * This method calculates the total area of a Triangle using appropriate formula	
 * @param width is the double value of base of triangle 
 * @param height is the value of height of triangle in double 
 * @return the total area of triangle 
 */
	public static double areaOfTriange(double width,double height)
	{
		return 0.5*width*height;
		
	}
/**
* This method calculates the total area of a Rectangle using appropriate formula	
* @param width is the value of breadth of Rectangle
* @param length is the value of length of Rectangle 
* @return the total area of Rectangle  
*/	
	public static double areaOfRectangle(double width,double height)
	{
		return width*height;
		
	}
/**
 * This method calculates the total area of a Rectangle using appropriate formula		
 * @param width is the side of Square
 * @return the total area of the square
 */
	public static double areaOfSquare(double width)
	{
		return width*width;
		
	}
/**
 * This method calculates the total area of a Circle	
 * @param radius is the radius of any Circle
 * @return the total area of Circle
 */
	public static double areaOfCircle(double radius)
	{
		return Math.PI*radius*radius;
		
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		double height=0,width=0,radius=0;
		int choice=0;
		try
		{
		while(true){
		System.out.println("Enter the choice from followong ");
		System.out.println("1 for calcuating area of Triangle ");
		System.out.println("2 for calcuating area of Rectangle ");
		System.out.println("3 for calcuating area of Square ");
		System.out.println("4 for calcuating area of Circle");
		System.out.println("5 for Exit");
	    choice=in.nextInt();
        if(choice==1)  {
		System.out.println("Enter the base ");
		width=in.nextDouble();
		if(width <=0)/*Custom Exception thrown*/
		{
			System.out.println("Width cannot be negative or zero!! ");
			throw new Exception("Invalid Input ");
		}
		System.out.println("Enter the height ");
		height=in.nextDouble();
		if(height <=0)
		{
			System.out.println("Height cannot be negative or zero!! ");
			throw new Exception("Invalid Input ");
		}
		System.out.println("The area of the triangle is "+areaOfTriange(width,height)+" units");}
		else if(choice==2) {
		System.out.println("Enter the breadth ");
		width=in.nextDouble();
		if(width <=0)
		{
			System.out.println("Width cannot be negative or zero!! ");
			throw new Exception("Invalid Input ");
		}
		System.out.println("Enter the length ");
		height=in.nextDouble();
		if(height <=0)
		{
			System.out.println("Height cannot be negative or zero!! ");
			throw new Exception("Invalid Input ");
		}
		System.out.println("The area of the rectangle is "+areaOfRectangle(width,height)+" units");	}
		else if(choice ==3) {
		System.out.println("Enter the side ");
		width=in.nextDouble();
		if(width <=0)
		{
			System.out.println("Height cannot be negative or zero!! ");
			throw new Exception("Invalid Input ");
		}
		System.out.println("The area of the square is "+areaOfSquare(width)+" units");}
		else if(choice ==4) {
		System.out.println("Enter the radius ");
		radius=in.nextDouble();
		if(radius <0)
		{
			System.out.println("Radius cannot be negative or zero!! ");
			throw new Exception("Invalid Input ");
		}
		System.out.println("The area of the circle is "+areaOfCircle(radius)+" units");
        }
        else if(choice==5){
		System.exit(0);
        }
        else {
		System.out.println("Please choose the correct option");
        main(args);
        }
		}}
		catch(Exception e)
		{
		System.out.println("Invalid Input entered !! Try Again");
		main(args);
		}
	}

}
