package varunk;

public class Lion extends Mammal {
	public Lion(String uniqueName, int age, double weight, String category3,
			String type) {
		super(uniqueName, age, weight, category3, type);
	}

	public String getSound() {
		return "roar";
	}

	public double getWeight() {
		return weight;
	}

	public int getAge() {
		return age;
	}

	public String getCategory() {

		return super.category;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return uniqueName;
	}

}
