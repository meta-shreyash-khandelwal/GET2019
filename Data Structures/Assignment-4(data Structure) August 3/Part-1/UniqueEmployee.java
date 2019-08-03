package dataStructure;
import java.util.*;
public class UniqueEmployee {
	Map<Integer, Employee> unique;
//Constructor
	public UniqueEmployee() {
		unique = new HashMap<Integer, Employee>();
	}
/**
 * This method checks for duplicate entries of the Employee 
 * @param newEntry is the new Employee to be added
 * @return true if no duplicate exists otherwise return false
 */
	public boolean addEmployees(Employee newEntry) {
		try {//If Invalid entered
			if (newEntry.getName().length() == 0
					|| newEntry.getAddress().length() == 0
					|| newEntry.getEmployeeId() < 0) {
				throw new Exception("Invalid Input encountered ");
			}
		} catch (Exception e) {
			System.out.println("Invalid Input encountered . Try Again||");
		}

		if (!unique.containsKey(newEntry.getEmployeeId())) {
			unique.put(newEntry.getEmployeeId(), newEntry);
			return true;
		} else {
			System.out.println("Employee Id repeatition encountered !! Try Again");
			return false;
		}

	}
}
