package dataStructure;

import java.util.*;

public class UniqueEmployee {
	Map<Integer, Employee> unique;

	public UniqueEmployee() {
		unique = new HashMap<Integer, Employee>();
	}

	public boolean addEmployees(Employee newEntry) {
		try {
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
			System.out
					.println("Employee Id repeatition encountered !! Try Again");
			return false;
		}

	}
}
