package qs;

public class Employee {
	private int employeeId;
	private String name;
	private int salary;
	private int age;

	public Employee(int employeeId, String name, int salary, int age) {
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	// Getters
	public int getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public int getAge() {
		return age;
	}
}