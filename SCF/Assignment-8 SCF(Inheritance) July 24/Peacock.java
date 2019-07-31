public class Peacock extends Bird {
	String sound;
	public Peacock(String uniqueName, int age, double weight, String category,
		       String type) {
		super(uniqueName, age, weight, category, type);
	}
//Over-riding to show sound of specific animal's sound
	public String getSound() {
		return "chirp";
	}
/* Over-riding methods  */
	public double getWeight() {
		return weight;
	}

	public int getAge() {
		return age;
	}

	public String getCategory() {
		return category;
	}

	public String getName() {
		return uniqueName;
	}

	public String getType() {
		return type;
	}
}
