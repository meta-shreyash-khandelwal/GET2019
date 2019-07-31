package dataStructure;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QueueTest {
	/*@Test
	public void testIsQueueFull() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsQueueEmpty() {
		fail("Not yet implemented");
	}
*/
	@Test
	public void testEnqueue() {
		Queue object =new Queue(4);
		object.enQueue(10);
		object.enQueue(20);
		object.enQueue(30);
		object.enQueue(40);
		int expected[]=new int[]{10,20,30,40};
		assertArrayEquals(expected,object.queue);
	}
	@Test
	public void testDequeue() {
		Queue object =new Queue(4);
		object.enQueue(10);
		object.enQueue(20);
		object.enQueue(30);
		object.enQueue(40);
		object.deQueue();
		object.deQueue();
		int expected[]=new int[]{10,20,30,40};
		//object.display();
		assertArrayEquals(expected,object.queue);
		
		
	}
	@Test
	public void testIsQueueFull() {
		Queue object =new Queue(4);
		object.enQueue(10);
		object.enQueue(20);
		object.enQueue(30);
		object.enQueue(40);
	assertFalse(object.isQueueEmpty());
	object.enQueue(50);
	
	assertTrue(object.isQueueFull());

	}

	@Test
	public void testIsQueueEmpty() {
		Queue object =new Queue(3);
		object.enQueue(1);
		object.enQueue(2);
		object.enQueue(3);
		object.deQueue();
		object.deQueue();
		object.deQueue();
object.deQueue();
	assertTrue(object.isQueueEmpty());
	
		
	}
}
