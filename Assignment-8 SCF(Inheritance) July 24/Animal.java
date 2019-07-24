package varunk;
public class Animal {
	String uniqueName;
	int age;
	double weight;
	String category;
	String type;
	String sound;

	// String id;
	public Animal(String uniqueName, int age, double weight, String category,
			String type) {
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		this.category = category;
		this.type = type;
	}

	public String getSound() {
		return sound;
	}

	public double getWeight() {
		return weight;
	}

	public int getAge() {
		return age;
	}

	public String getCategory() {
		return category;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return uniqueName;
	}

}
