class Node { 
    constructor(element) 
    { 
        this.element = element; 
        this.next = null
    } 
} 
class LinkedList { 
    constructor() 
    { 
        this.head = null; 
        this.size = 0; 
    } 
// adds an element 
add(element) 
{ 
    // creates a new node 
    var node = new Node(element); 
    var current; 
    if (this.head == null) 
        this.head = node; 
    else { 
        current = this.head; 
        while (current.next) { 
            current = current.next; 
        } 
        current.next = node; 
    } 
    this.size++; 
} 
//Removes element
removeElement(element) 
{ 
	var current = this.head; 
	var previous = null; 
	while (current != null) { 
		// comparing element with current 
		// element if found then remove the 
		// and return true 
		if (current.element === element) { 
			if (previous == null) { 
				this.head = current.next; 
			} else { 
				previous.next = current.next; 
			} 
			this.size--; 
			return current.element; 
		} 
		previous = current; 
		current = current.next; 
	} 
	return -1; 
} 
//Check empty
isEmpty() 
{ 
	return this.size == 0; 
} 
// gives the size of the list 
size_of_list() 
{ 
	console.log(this.size); 
} 
//Prints list
printList() 
{ 
	var current = this.head; 
	var Finalstring = ""; 
	while (current) { 
		Finalstring += current.element + " "; 
		current = current.next; 
	} 
	console.log(Finalstring); 
} 

} 





var singly = new LinkedList(); 
// returns true 
console.log(singly.isEmpty()); 
// adding element to the list 
singly.add(10); 
singly.add(20); 
singly.add(30);   

singly.printList(); // prints 10 ,20 ,30

console.log(singly.size_of_list()); // prints 3

singly.removeElement(20); //Removes 20 from Linked list
  

singly.printList();  // prints 10 ,30

