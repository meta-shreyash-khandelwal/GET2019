package qs;

public class Main {
	public static void main(String args[])
	{
		LinkedListOperation l1=new LinkedListOperation();
		l1.addNode(l1, new Employee(3,"Man",1202,33));
		l1.addNode(l1, new Employee(1,"Raj",6122,21));
		l1.addNode(l1, new Employee(5,"ShaVa",1223,32));
		l1.addNode(l1, new Employee(14,"Va",145,32));
		l1.addNode(l1, new Employee(2,"Ajay",2333,23));
		l1.addNode(l1, new Employee(14,"Va",1202,32));
		l1.addNode(l1, new Employee(2,"Ajay",112352,23));
		l1.printList(l1);
		System.out.println("After");
		l1.head = l1.quickSort(l1.head);
		l1.printList(l1);
		
		}

}


