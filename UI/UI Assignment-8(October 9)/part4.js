
class Stack { 
    constructor() 
    { 
        this.items = []; 
    } 
//Add Element
push(element) 
{ 
    this.items.push(element); 
} 
//Delete Element
pop() 
{ 

    if (this.items.length == 0) 
        return "Underflow"; 
    return this.items.pop(); 
} 
} 


var stack=new Stack();
stack.push(10);
stack.push(20);
stack.push(30);
console.log(stack.pop()); //Returns 30
console.log(stack.pop()); //Returns 20
console.log(stack.pop()); //Returns 10
console.log(stack.pop()); //Returns underflow




