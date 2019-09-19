package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.Employee;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;
@Service 
public class UserServiceImpl implements UserService  {
	@Autowired
	private UserDAO userDAO;
	
	
				@Override
		public boolean addEmployee(Employee user) {
			System.out.println("In user service");
			return userDAO.addEmployee(user);
		}

				@Override
		public boolean addVehicle(Vehicle user) {
			System.out.println("In vehicle service");
			return userDAO.addVehicle(user);
		}

				@Override
				public boolean addPass(Pass user) {
					System.out.println("In pass service");
					return userDAO.addPass(user);
					
				}

				@Override
				public Employee showEmployee1(String email) {
					System.out.println("In show service");
					return userDAO.showEmployee(email);
				}

				@Override
				public boolean updateEmployee(Employee user) {
				
					System.out.println("In Update");
					
					return userDAO.update(user);
				}

				@Override
				public List<Employee> getAll(String organ,String email) {
					//System.out.println("In GET ALL");
List<Employee> empList=new ArrayList<Employee>();
empList=userDAO.getList(organ,email);
					
					return empList;
				}

				@Override
				public boolean updateImage(Employee user,String file) {
					System.out.println("IN IMAGE UPDATE service");
					System.out.println(userDAO.updateImage(user,file));
					return userDAO.updateImage(user,file);
				}

		
				
				
}
