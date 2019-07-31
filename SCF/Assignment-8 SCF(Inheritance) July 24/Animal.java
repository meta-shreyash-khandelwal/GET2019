public class Animal {
	String uniqueName;
	int age;
	double weight;
	String category;
	String type;
	String sound;
	public Animal(String uniqueName, int age, double weight, String category,
	String type) {
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		this.category = category;
		this.type = type;
	}
/**
 * This is getter method for sound
 * @return sound of animal
 */
	public String getSound() {
		return sound;
	}
/**
 * This is getter method for weight
 * @return weight of animal
 */
	public double getWeight() {
		return weight;
	}
/**
 * This is getter method for age
 * @return age of animal
 */
	public int getAge() {
		return age;
	}
/**
 * This method is getter for category like mammal,reptiles or bird
 * @return the category
 */
	public String getCategory() {
		return category;
	}
/**
 * This method is getter for type such as lion,crocodile or peacock
 * @return
 */
	public String getType() {
		return type;
	}
/**
 * This method is getter for name of Animal
 * @return the unique name of Animal
 */
	public String getName() {
		return uniqueName;
	}

}
