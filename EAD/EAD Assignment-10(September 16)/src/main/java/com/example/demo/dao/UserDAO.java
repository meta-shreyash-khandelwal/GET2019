package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Employee;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;

public interface UserDAO {

	public boolean addEmployee(Employee user);

		public boolean delete(Integer id);

		boolean addVehicle(Vehicle vehicle);

		boolean addPass(Pass user);

		Employee showEmployee(String email);
		
		public boolean update(Employee user);
		
		public List<Employee> getList(String organ,String email);
		
		public boolean updateImage(Employee user,String file);
}