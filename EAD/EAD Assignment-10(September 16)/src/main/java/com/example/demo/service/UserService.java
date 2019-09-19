package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;

public interface UserService {
	public boolean addEmployee(Employee user);
	boolean addVehicle(Vehicle user);
    boolean addPass(Pass user);
	Employee showEmployee1(String email);	
	public boolean updateEmployee(Employee user);
public List<Employee> getAll(String organ,String email);
public boolean updateImage(Employee user,String file);
		
		
}
