public class Mammal extends Animal {
	public Mammal(String uniqueName, int age, double weight, String category2,
			      String type) {
		super(uniqueName, age, weight, category2, type);
	}
/**
 * This method is getter for category like mammal,reptiles or bird
 * @return the category
 */
	//Override the superclass's functions
	public String getCategory() {
		return super.category;
	}
}
