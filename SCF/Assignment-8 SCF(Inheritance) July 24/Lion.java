public class Lion extends Mammal {
	public Lion(String uniqueName, int age, double weight, String category3,
	            String type) {
		super(uniqueName, age, weight, category3, type);//Calling super class constructor
	}
//Overriding to give the sound of lion when needed
	public String getSound() {
		return "roar";
	}
/* getter methods */
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
