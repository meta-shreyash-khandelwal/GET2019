package dataStructure;

public interface PriorityQueueInterface {
	public void enqueue(int element, int priority);

	public int dequeue();

	public boolean isEmpty();

	public boolean isFull();
}