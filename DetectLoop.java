package dataStructure;
import java.util.*;
public class DetectLoop {
	public static boolean detectLoopInList(LinkedList list)
	{
		Set <Node> referenceSet=new HashSet<Node>();
		Node traverse=list.head;
		while(traverse!=null)
		{
			if(referenceSet.contains(traverse))
			{
				return true;
			}
			referenceSet.add(traverse);
			traverse=traverse.next;
		
		}
	return false;	
	}

}
