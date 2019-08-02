package dataStructure;

public class PriorityQueueArray implements PriorityQueueInterface {
	int priorQueue[][];
	int front;
	int rear;
	int capacity;
	int counter;
	public PriorityQueueArray(int capacity) {
		priorQueue = new int[2][capacity];
		front = -1;
		rear = -1;
		this.capacity = capacity;
	}
/**
 * This method checks whether queue is full or not
 * @return true if queue is full otherwise returns false
 */
	public boolean isFull() {
		if (front == rear + 1 || (front == 0 && rear == capacity - 1)) {
			return true;
		} else {
			return false;
		}
	}
/**
 * This method checks whether queue is full or not
 * @return true if queue is full otherwise returns false
 */
	
	public boolean isEmpty() {
		if (counter == capacity)
			return true;
		else
			return false;
	}
/**
 * This method adds the element in the queue according to the order of priority as entered by user
 * @param element is the integer value to be added
 * @param priority is the element's priority in between 1<=priority<=capacity
 */
	public void enqueue(int element, int priority) {
		try {
			if (isFull() || priority>capacity) {
				throw new Exception("Queue Full");

			} else {
				if (front == -1 && rear == -1) {
					front = 0;
					rear = 0;
				} else {
					rear++;
				}
				priorQueue[0][rear] = element;
				priorQueue[1][rear] = priority;
			}
		} catch (Exception e) {
			System.out.println("Queue is Full");
		}
	}
/**
 * This method deletes the element in queue according to the priorities
 * @return the integer element dequeued 
 */
	public int dequeue() {
		int data = 0;
		try {
			if (!isEmpty()) {
				outer: for (int j = 1; j <= capacity; j++) {
					for (int i = front; i <= rear; i++) {
						if (j == priorQueue[1][i]) {
							data = priorQueue[0][i];
							priorQueue[1][i] = -1;
							counter++;
							break outer;
						}
					}
				}
			} else {
				throw new Exception("Empty Queue");
			}
		} catch (Exception e) {
			System.out.println("Empty queue");
		}
		return data;

	}

}
