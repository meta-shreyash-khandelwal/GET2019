package varunk;

import java.util.*;

public class Zone {
	String category;
	List<Cage> objectCage;
	int limitOfCages;
	boolean hasPark;
	boolean hasCanteen;

	public Zone(int limitOfCages, boolean hasPark, boolean hasCanteen,
			String category) {
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
		this.limitOfCages = limitOfCages;
		this.category = category;

	}

	public List<Cage> addCages(String type, int capacity) {
		objectCage = new ArrayList<Cage>(capacity);
		for (int i = 0; i < limitOfCages; i++) {
			objectCage.add(new Cage(type, capacity));
		}
		return objectCage;
	}

	public void addAnimalToCage(List<Cage> cageObject) {
		int counter = 0;
		for (int i = 0; i < limitOfCages; i++) {
			if (cageObject.get(i).current < cageObject.get(i).capacity) {
				counter = 1;
				objectCage.get(i).current += 1;
				break;

			}
		}
		try{
		if (counter == 0) {
			throw new Exception("Full Capacity");
			//System.out.println("FULL Capacity");
		}}catch(Exception e)
		{
			System.out.println("FULL Capacity Not able to add");
		}
	}

	public void deathOfAnimal(List<Cage> cageObject) {
		int counter = 0;
		if (limitOfCages == 0) {
			System.out.println("No Cages to display");
		} else {
			for (int i = 0; i < limitOfCages; i++) {
				if (cageObject.get(i).current != 0) {
					counter = 1;
					objectCage.get(i).current -= 1;
					break;

				}
			}
			if (counter == 0) {
				System.out.println("No animals in Cages to delete");
			}

		}

	}

}
