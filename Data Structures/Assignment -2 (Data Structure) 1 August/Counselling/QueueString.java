package varunk;
public class QueueString {
	int front, rear, size;
	String queue[];//Integer based implementation of queue

	QueueString(int size) {
		this.size = size;
		queue = new String[size];
		front = rear = -1;
		}
/**
 * This method checks whether the queue is full i.e.for overflow condition
 * @return true if queue is full else returns false
 */
	public boolean isQueueFull() {
		if (front == 0 && rear == size - 1) {
			return true;

		} else if (front == rear + 1) {
			return true;
		} else {
			return false;
		}
	}
/**
 * This method checks whether the queue is empty i.e.for underflow condition
 * @return true if queue is full else returns false
 */
	public boolean isQueueEmpty() {
		if (front == -1)
			return true;
		else
			return false;
	}
/**
 * This method is used to insert element into the queue
 * @param element is the integer element to be inserted in queue
 */
	public String peek()
	{
		if(isQueueEmpty())
		{
			return "";
		}
		return queue[front];
	}
	
/**
 * This method adds the String element to the queue	
 */
	public void enQueue(String element) {
		if (!isQueueFull()) {
			if (front == -1 && rear == -1) {
					front = rear = 0;
			} else {
					rear++;
			}
			queue[rear] = element;
		}
	}
/**
 * This method deletes the element from the queue using FIFO
 */
	public void deQueue() {
		String element="";
		if (!isQueueEmpty()) {
		 element = queue[front];
			if (front == rear) {
				front = -1;
				rear = -1;
			} else {
						front++;
			}
		}
	}
/**
 * This method displays the contents of queue
 */
	public String display() {
		System.out.println("Queue contents are !");
		String result="";
		try {
			if (front >= 0 && rear >= 0) {
				for (int x = front; x <= rear; x++) {
					result+=queue[x]+" ";
				}
			} else {
				throw new Exception("Not possible");
			}
		} catch (Exception e) {
			System.out.println("Not able to display");

		}
		return result;
	}
/*
	public static void main(String[] args) {

		QueueInterface q = new Queue(5);
		q.enQueue(10);
		q.enQueue(10);
		q.enQueue(20);
		q.enQueue(30);
		q.enQueue(40);
		// q.enQueue(50);
		q.display();
		q.deQueue();
		q.deQueue();
		q.display();

	}
*/
}