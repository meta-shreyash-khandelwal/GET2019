package dataStructure;

import static org.junit.Assert.*;

import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;
/*Considering 1 being the highest priority*/
public class Test3 {
	
	@Test
	public void testEnqueue() {
		PriorityQueueArray object1=new PriorityQueueArray(5);
		object1.enqueue(20, 4);
		object1.enqueue(25, 2);
		object1.enqueue(30, 1);
		assertEquals(2,object1.rear);
	
		object1.enqueue(40, 3);
		object1.enqueue(50, 1);
		assertEquals(4,object1.rear);
	
	}
	@Test
	public void testDequeue1() {
		PriorityQueueArray object1=new PriorityQueueArray(5);
		object1.enqueue(20, 4);
		object1.enqueue(25, 2);
		object1.enqueue(30, 1);
		assertEquals(30,object1.dequeue());
		
	}
	@Test
	public void testDequeue2() {
		PriorityQueueArray object1=new PriorityQueueArray(5);
		object1.enqueue(100, 1);
		object1.enqueue(25, 2);
		object1.enqueue(30, 1);
		assertEquals(100,object1.dequeue());
		assertEquals(30,object1.dequeue());
	}

	@Test
	public void testDequeue3() {
		PriorityQueueArray object1=new PriorityQueueArray(5);
		object1.enqueue(100, 2);
		object1.enqueue(25, 1);
		object1.enqueue(30, 3);
		assertEquals(25,object1.dequeue());
		assertEquals(100,object1.dequeue());
		assertEquals(30,object1.dequeue());

	}

	
	@Test
	public void testGetBowledShould_Give_Order1()
	{
		//Asssuming sum of quota of each bowler is greater than ballByVirat
		int ballByVirat = 10;
		int noOfBowler = 5;
		String nameOfBowler[] = { "Irfan", "Malinga", "Bumrah", "Chahal",
				"Shami" };
		int quotaOfBowler[] = { 6, 5, 7, 8, 2 };
		for (int i = 0; i < nameOfBowler.length; i++) {
			CricketClass.queue.add(new Bowler(nameOfBowler[i], quotaOfBowler[i]));
		}
		String check[] = CricketClass.getBowled(ballByVirat);
	String actual[]={"Chahal","Bumrah","Chahal","Bumrah","Chahal","Irfan","Chahal","Irfan","Malinga","Bumrah"};
	assertArrayEquals(check,actual);
}
	
	@Test
	public void testGetBowledShould_Give_Order2()
	{
		int ballByVirat = 8;
		int noOfBowler = 3;
		String nameOfBowler[] = {"Malinga", "Bumrah", "Shami" };
		int quotaOfBowler[] = { 3, 2, 3};
		for (int i = 0; i < nameOfBowler.length; i++) {
			CricketClass.queue.add(new Bowler(nameOfBowler[i], quotaOfBowler[i]));
		}
		String check[] = CricketClass.getBowled(ballByVirat);
	String actual[]={"Malinga","Chahal","Bumrah","Irfan","Bumrah","Irfan","Malinga","Shami"};
	assertArrayEquals(check,actual);
}
}