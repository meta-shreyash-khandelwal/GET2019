class Node {
	constructor( data ) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}
}

class DoublyLinkedList {
	constructor() {
		this.head = null;
		this.tail = null;	
	}
// adds an item to doubly linked list 
	add( item ) {
		var node = new Node( item );

		if(!this.head) {
			this.head = node;
			this.tail = node;
		} else {
			node.previous = this.tail;
			this.tail.next = node;
			this.tail = node
		}
	}
	
// Removes an item from doubly linked list 
	remove( item ) {
		var current = this.head;
		while( current ) {
			if( current.data === item ) {
				if( current == this.head && current == this.tail ) {
					this.head = null;
					this.tail = null;
				} else if ( current == this.head ) {
					this.head = this.head.next
					this.head.previous = null
				} else if ( current == this.tail ) {
					this.tail = this.tail.previous;
					this.tail.next = null;
				} else {
					current.previous.next = current.next;
					current.next.previous = current.previous;
				}
			}
			current = current.next
		}
	}

	//Prints list
printList() 
{ 
	var current = this.head; 
	var Finalstring = ""; 
	while (current) { 
		Finalstring += current.data + " "; 
		current = current.next; 
	} 
	console.log(Finalstring); 
} 


//Check empty
isEmpty() 
{ 
	return this.size == 0; 
} 
}


var doublyList=new DoublyLinkedList();
// returns true 
console.log(doublyList.isEmpty()); 

// adding element to the list 
doublyList.add(10); 
doublyList.add(20); 
doublyList.add(30);   

doublyList.printList(); // prints 10 ,20 ,30

doublyList.remove(20); //Removes 20 from Linked list
  

doublyList.printList();  // prints 10 ,30
