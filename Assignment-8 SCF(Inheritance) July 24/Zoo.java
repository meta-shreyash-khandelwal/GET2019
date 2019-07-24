import java.util.*;

public class Zoo {
	static List<Animal> animalList;
/**
 * This method helps in adding the animal to a particular cage
 * @param zoneList is the list of objects containing all zones
 * @param cageZone1 is the list of cage object in 1st zone mammal
 * @param cageZone2 is the list of cage object in 1st zone Bird
 * @param cageZone3 is the list of cage object in 2st zone Reptile
 * @param lastUpdate is updated position of animal list object
 */
	public static void addingAnimalToCage(List<Zone> zoneList,
			List<Cage> cageZone1, List<Cage> cageZone2, List<Cage> cageZone3,
			int lastUpdate) {
		for (int i = lastUpdate; i < animalList.size(); i++) {
			if ("Mammal".equals(animalList.get(i).getCategory())) {
				zoneList.get(0).addAnimalToCage(cageZone1);// Adding animal
															// related to Mammal
				System.out.println("Added Successfully");
			} else if ("Bird".equals(animalList.get(i).getCategory())) {
				zoneList.get(2).addAnimalToCage(cageZone2);// Adding animal
															// related to Bird
				System.out.println("Added Successfully");
			} else if ("Reptile".equals(animalList.get(i).getCategory()))// Adding animal related to Reptile
				{
				zoneList.get(1).addAnimalToCage(cageZone3);
				System.out.println("Added Successfully ");
			}
		}

	}
/**
 * This method deletes animals from the cage
 * @param name is the unique name of the Animal to be deleted
 * @param zoneList is the list of objects containing all zones
 * @param cageZone1 is the list of cage object in 1st zone mammal
 * @param cageZone2 is the list of cage object in 1st zone Bird
 * @param cageZone3 is the list of cage object in 2st zone Reptile
 * 
 */
	public static void deletingAnimalFromCage(String name, List<Zone> zoneList,
			List<Cage> cageZone1, List<Cage> cageZone2, List<Cage> cageZone3) {
		try {
			if (name == null) {
				throw new AssertionError("Null");
			}
		} catch (Error e) {
			System.out.println("Empty String passed");
		}
		String animalCategory = "";
		for (int k = 0; k < animalList.size(); k++) {
			if (name.equals(animalList.get(k).getName())) {
				animalCategory = animalList.get(k).getCategory();

			}
		}
		try {
			if (animalCategory.length() == 0) {
				throw new Exception("Animal with given name not present");
			}
		} catch (Exception e) {
			System.out.println("Animal with given name not present");
		}

		for (int i = 0; i < animalList.size(); i++) {
			if ("Mammal".equals(animalCategory)) {
				zoneList.get(0).deathOfAnimal(cageZone1);
				System.out.println("Successfully deleted");
				break;
			} else if ("Bird".equals(animalCategory)) {
				zoneList.get(2).deathOfAnimal(cageZone2);
				System.out.println("Successfully deleted");
				break;
			} else if ("Reptile".equals(animalCategory)) {
				zoneList.get(1).deathOfAnimal(cageZone3);
				System.out.println("Successfully deleted");
				break;
			}
		}

	}

	public static void main(String args[]) {
		// Creating Cages for each zone
		List<Cage> cageZone1 = new ArrayList<Cage>();
		List<Cage> cageZone2 = new ArrayList<Cage>();
		List<Cage> cageZone3 = new ArrayList<Cage>();

		// Adding zones with pre-specified
		List<Zone> zoneList = new ArrayList<Zone>();
		zoneList.add(new Zone(5, true, true, "Mammal"));// 5 cages , Park Present ,Canteen Present,Mammal category
		zoneList.add(new Zone(6, false, true, "Reptile"));// 6 cages , Park Absent ,Canteen Present,Reptile category
		zoneList.add(new Zone(3, true, false, "Bird"));// 3 cages , Park Present ,Canteen Absent,Bird category

		// Creating the list of animals objects representing the different animals
		animalList = new ArrayList<Animal>();
		
		// Adding animals with (uniqueName,Age,Weight,Category,Type)
		
		animalList.add(new Lion("L-11", 15, 80.45, "Mammal", "Lion"));
		animalList.add(new Lion("L-12", 10, 40.67, "Mammal", "Lion"));
		animalList.add(new Peacock("B-10", 15, 50.45, "Bird", "Peacock"));
		animalList.add(new Peacock("B-11", 15, 50.45, "Bird", "Peacock"));
		animalList.add(new Crocodile("C-10", 15, 280.45, "Reptile", "Crocodile"));
		animalList.add(new Crocodile("C-12", 1, 180.45, "Reptile", "Crocodile"));
		animalList.add(new Crocodile("C-13", 15, 280.45, "Reptile", "Crocodile"));

		// Adding cages to the zoneListones with capacity 2 of Type "Lion"
		cageZone1 = zoneList.get(0).addCages("Lion", 2);
		
		// Adding cages to the zones with capacity 6 of Type "Peacock"
		cageZone2 = zoneList.get(2).addCages("Peacock", 6);

		// Adding cages to the zones with capacity 2 of Type "Lion"
		cageZone3 = zoneList.get(1).addCages("Crocodile", 1);

		addingAnimalToCage(zoneList, cageZone1, cageZone2, cageZone3, 0);
		int previous = animalList.size();

		animalList.add(new Lion("L-13", 8, 140.67, "Mammal", "Lion"));
		animalList.add(new Crocodile("C-13", 5, 380.45, "Reptile", "Crocodile"));

		
		addingAnimalToCage(zoneList, cageZone1, cageZone2, cageZone3, previous);

		
		deletingAnimalFromCage("B-11", zoneList, cageZone1, cageZone2,cageZone3);
		deletingAnimalFromCage("C-13", zoneList, cageZone1, cageZone2,cageZone3);

		// List of zone with cages
		System.out.println("ZONES FOR MAMMAL");
		System.out.println("Current  Capacity");
		for (int k = 0; k < cageZone1.size(); k++) {
			System.out.println(cageZone1.get(k).current + "\t "
					+ cageZone1.get(k).capacity);
		}

		System.out.println("ZONES FOR BIRD");
		System.out.println("Current  Capacity");
		for (int k = 0; k < cageZone2.size(); k++) {
			System.out.println(cageZone2.get(k).current + "\t "
					+ cageZone2.get(k).capacity);
		}

		System.out.println("ZONES FOR REPTILES");
		System.out.println("Cuurent  Capacity");
		for (int k = 0; k < cageZone3.size(); k++) {
			System.out.println(cageZone3.get(k).current + "\t "
					+ cageZone3.get(k).capacity);
		}

	}

}
