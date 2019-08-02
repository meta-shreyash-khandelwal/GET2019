package dataStructure;

public class Bowler {
	String name;
	int quota;

	public Bowler(String name, int quota) {
		this.name = name;
		this.quota = quota;
	}
	//Getter methods 
	public int quotaOfBowler() {
		return quota;
	}

	public String nameOfBowler() {
		return name;
	}

}
