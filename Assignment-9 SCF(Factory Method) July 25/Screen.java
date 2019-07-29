package varunk;
import java.util.*;

public class Screen {
	List<Shape> listFigure;
	public Screen()
	{
		listFigure=new ArrayList<Shape>();
	}
	public void addShape(Shape.ShapeType type,List<Integer> parameter, Point object)
	{
		Shape figure;
		figure=Factory.createShape(type, parameter, object);
		listFigure.add(figure);
	}
	public void deleteShape(Point object)
	{
		for(int i=0;i<listFigure.size();i++)
		{	if(listFigure.get(i).getOrigin().getX()==object.getX() && listFigure.get(i).getOrigin().getY()==object.getY())
			{	listFigure.remove(i);
			break;
		}
		}
		
	}
	public void deleteAllShape()
	{listFigure.clear();
	}
	
	
	
		public List<Shape> sortedOrder(String choice)
	{
	if("Area".equals(choice))
	{
		Collections.sort(listFigure, new Comparator<Shape>() {
			  @Override
			  public int compare(Shape firstObject, Shape secondObject) {
			    return Double.compare(firstObject.getArea(),secondObject.getArea());
			  }
			});
	return listFigure;
	}
	else if("Perimeter".equals(choice))
	{
		Collections.sort(listFigure, new Comparator<Shape>() {
			  @Override
			  public int compare(Shape firstObject, Shape secondObject) {
			    return Double.compare(firstObject.getPerimeter(),secondObject.getPerimeter());
			  }
			});
		return listFigure;	
	}
	
	return null;	
			
		}
	

	
	
	public List<Shape> enclosingShape(Point specified)
	{
		List<Shape> answer=new ArrayList<Shape>();
		for(int i=0;i<listFigure.size();i++)
		{
			if(listFigure.get(i).isPointEnclosed(specified))
			{
				answer.add(listFigure.get(i));
			}
			
		}
		return answer;
	}
	
	

}
