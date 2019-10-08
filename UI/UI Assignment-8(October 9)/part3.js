class Queue 
{ 
    constructor() 
    { 
        this.items = []; 
    } 
//Add Queue
enqueue(element) 
{     
    this.items.push(element); 
}  
//Checks if empty
isEmpty() {
  return this.length == 0;
}
//Deletes Element
dequeue() 
{ 
	if(this.items.length === 0) 
	{return "Underflow";} 
	return this.items.shift(); 
} 
}

var queue = new Queue(); 


queue.enqueue(10); 
queue.enqueue(20); 
queue.enqueue(30); 
console.log(queue.dequeue());  //Returns 10
console.log(queue.dequeue()); //Returns 20
console.log(queue.dequeue()); //Returns 30
console.log(queue.dequeue()); //Returns underflow
 


