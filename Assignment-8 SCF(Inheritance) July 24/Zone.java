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
/**
 * This method add the cages to the zones according to the specified call
 * @param type is the animal type like lion,peacock or crocodile
 * @param capacity is the number of animals of same type in a single cage
 * @return the list of objects of Cages in a specified zone
 */
	public List<Cage> addCages(String type, int capacity) {
		objectCage = new ArrayList<Cage>(capacity);
		for (int i = 0; i < limitOfCages; i++) {
			objectCage.add(new Cage(type, capacity));
		}
		return objectCage;
	}
/**
 * This method adds the animal to the cage in a particular zone
 * @param cageObject is the list containing the objects of cages
 */
	public void addAnimalToCage(List<Cage> cageObject) {
		int counter = 0;
		for (int i = 0; i < limitOfCages; i++) {
			if (cageObject.get(i).current < cageObject.get(i).capacity) {
				counter = 1;
				objectCage.get(i).current += 1;
				break;

			}
		}
		try {
			if (counter == 0) {
				throw new Exception("Full Capacity");
				// System.out.println("FULL Capacity");
			}
		} catch (Exception e) {
			System.out.println("FULL Capacity Not able to add animal !!");
		}
	}
/**
 * This method deletes the animal from the cage in a specified cage in a zone
 * @param cageObject is the list containing the cages after deleting the animal from cage 
 */
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
			try {
				if (counter == 0) {
					throw new Exception("No Animal");
				}
			} catch (Exception e) {
				System.out.println("No animals in Cages to delete");
			}

		}

	}

}
