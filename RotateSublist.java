package dataStructure;

public class RotateSublist {
 public static void main(String args[])
 {
	 LinkedList obj=new LinkedList();
	 LinkedList newList=new LinkedList();
	 obj.insertList(newList, 2);
	 obj.insertList(newList, 3);
	 obj.insertList(newList, 4);
	 obj.insertList(newList, 5);
	 obj.insertList(newList, 6);
	 obj.insertList(newList, 7);
	 obj.insertList(newList, 8);
	 obj.insertList(newList, 9);
	 //obj.insertList(newList, 70);
     obj.printLinkedList(newList);
 
// System.out.println("HEAD "+newList.head);  
 //System.out.println("1 node "+newList);
 //LinkedList newList2=new LinkedList();
 //newList2.head.next=newList2.head.next.next;
//newList2=obj.rotateSubList(newList, 1, 4, 3);
 //obj.printLinkedList(newList2);
 //System.out.println(obj.checkReference(newList, 1));
 //System.out.println(obj.checkReference(newList, 6));
 obj.rotateSubList(newList,2,6,2);
 obj.printLinkedList(newList);
 
 
 
 
 
 LinkedList newList2=new LinkedList();
 obj.insertList(newList2, 15);
 obj.insertList(newList2, 20);
 obj.insertList(newList2, 25);
 obj.insertList(newList2, 30);
 obj.insertList(newList2, 40);
Node position1=obj.checkReference(newList2, 5);
Node position2=obj.checkReference(newList2, 2);
position1.next=position2;
System.out.println(DetectLoop.detectLoopInList(newList));
System.out.println(DetectLoop.detectLoopInList(newList2));
		
	
	
}
	
	
	
}
