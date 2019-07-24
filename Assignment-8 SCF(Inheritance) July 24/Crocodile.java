package varunk;

public class Crocodile extends Reptile {

	public Crocodile(String uniqueName, int age, double weight,
			String category, String type) {
		super(uniqueName, age, weight, category, type);
	}

	public String getSound() {
		return "hiss";
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
