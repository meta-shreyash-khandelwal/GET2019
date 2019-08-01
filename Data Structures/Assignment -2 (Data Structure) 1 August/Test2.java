package dataStructure;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test2 {
	@Test
	public void testEnqueue() {
		QueueClass object = new QueueClass(4);
		object.enQueue(10);
		object.enQueue(20);
		object.enQueue(30);
		object.enQueue(40);
		int expected[] = new int[] { 10, 20, 30, 40 };
		assertArrayEquals(expected, object.queue);
	}
	
	@Test
	public void testDequeue() {
		QueueClass object = new QueueClass(4);
		object.enQueue(10);
		object.enQueue(20);
		object.enQueue(30);
		object.enQueue(40);
		object.deQueue();
		object.deQueue();
		object.display();
		int expected[] = new int[] { 10, 20, 30, 40 };
		for (int i = 0; i < object.size; i++) {
			System.out.println(object.queue[i]);
		}
		// object.display();
		assertArrayEquals(expected, object.queue);
	}
	
	@Test
	public void testIsQueueFull() {
		QueueClass object = new QueueClass(4);
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
		QueueClass object = new QueueClass(3);
		object.enQueue(1);
		object.enQueue(2);
		object.enQueue(3);
		object.deQueue();
		object.deQueue();
		object.deQueue();
		object.deQueue();
		assertTrue(object.isQueueEmpty());

	}

	@Test
	public void testEvaluateInfix1() {
		int actual = InfixEvaluation.evaluateInfix("( 5 + ( 8 < 6 ) )");
		int expected = 6;
		assertEquals(expected, actual);

	}

	@Test
	public void testEvaluateInfix2() {
		int actual = InfixEvaluation.evaluateInfix("100 * 2 + 12");
		int expected = 212;
		assertEquals(expected, actual);

	}

	@Test
	public void testEvaluateInfix3() {
		int actual = InfixEvaluation.evaluateInfix("( 100 * ( 2 + 12 ) / 14 )");
		int expected = 100;
		assertEquals(expected, actual);

	}

}
