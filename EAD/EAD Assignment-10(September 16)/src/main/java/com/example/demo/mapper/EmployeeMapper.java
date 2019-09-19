package com.example.demo.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

		Employee user = new Employee();
		
		
		user.setFullName(resultSet.getString("fullName"));
		user.setContact(resultSet.getString("contact"));
		user.setEmailID(resultSet.getString("email"));
		user.setGender(resultSet.getString("gender"));
		user.setOrganisation(resultSet.getString("organisation"));
		user.setPassword(resultSet.getString("password"));
		user.setUrl(resultSet.getString("url"));
				return user;
	}
}

