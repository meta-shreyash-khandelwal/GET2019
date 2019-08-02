package dataStructure;

import java.util.*;
/**
 *This class implements comparator interface and overwrite the compare function
 */
class ComparatorClass implements Comparator<Bowler> {
	@Override
	public int compare(Bowler object1, Bowler object2) {
		if (object1.quota < object2.quota)
			return 1;
		else if (object1.quota > object2.quota)
			return -1;
		return 0;
	}
}

public class CricketClass {
	static Queue<Bowler> queue = new PriorityQueue<Bowler>(new ComparatorClass()); //Using priority queue so that the order is maintained in descending order as asked in question
/**
 * This method updates the each bowler's ball by decrementing 1
 * @param viratBall is the total number of balls to be faced by Virat Kohli
 * @return the String array containing order of bowler
 */
	public static String[] getBowled(int viratBall) {
		int index = 0;
		String array[] = new String[viratBall];
		while (viratBall != 0) {
			int updatedQuota = queue.peek().quota - 1;
			String bowlerName = queue.peek().name;
			array[index++] = bowlerName;
			queue.remove();
			if (updatedQuota != 0) {
				queue.add(new Bowler(bowlerName, updatedQuota));
			}
			viratBall--;
		}
		return array;
	}
/*
	public static void main(String[] args) {
		int ballByVirat = 10;
		int noOfBowler = 5;
		String nameOfBowler[] = { "Irfan", "Malinga", "Bumrah", "Chahal",
				"Shami" };
		int quotaOfBowler[] = { 6, 5, 7, 8, 2 };
		for (int i = 0; i < nameOfBowler.length; i++) {
			queue.add(new Bowler(nameOfBowler[i], quotaOfBowler[i]));
		}
		String check[] = getBowled(ballByVirat);
		// System.out.println(queue.remove());
		// queue.add(new Bowler(queue.peek().name,(queue.peek().quota)-1));
		// queue.remove();
		System.out.println("ORDER of Bowler ");
		for (int k = 0; k < check.length; k++) {
			System.out.println(check[k]);
		}
		System.out.println("Remaining quota of Bowler Summary");
		while (!queue.isEmpty()) {
			System.out.println("NAme " + queue.peek().name + " Quota = "
					+ queue.peek().quota);
			queue.remove();
		}
	}
	*/
}
