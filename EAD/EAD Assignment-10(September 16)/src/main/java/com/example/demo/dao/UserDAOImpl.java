package com.example.demo.dao;

import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Employee;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
//import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper<Employee>


@Repository
public class UserDAOImpl implements UserDAO {

private JdbcTemplate jdbcTemplate;
	
private final String SQL_FIND_USER = "select * from detail where email = ?";
private final String SQL_UPDATE_USER = "update detail set fullName = ?,gender=?,password=?,contact=?,organisation=? where email= ?";
private final String SQL_GET_ALL = "select * from detail where organisation=? AND NOT email=?";
private final String SQL_INSERT_USER = "insert into detail(fullName, gender,email, password,contact,organisation) values(?,?,?,?,?,?)";
private final String SQL_INSERT_VEHICLE = "insert into vehicle(vname,type,number,employeeid,identification,email) values(?,?,?,?,?,?)";
private final String SQL_INSERT_PASS = "insert into pass(email,amount) values(?,?)";
private final String SQL_UPDATE_IMAGE = "update detail set url=? where email= ?";

private final String SQL_CON="set foreign_key_checks=0";

	@Autowired
	public UserDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean addEmployee(Employee user) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT_USER,Statement.RETURN_GENERATED_KEYS); 
                ps.setString(1, user.getFullName());
                ps.setString(2, user.getGender());
                ps.setString(3, user.getEmailID());
                ps.setString(4, user.getPassword());
                ps.setString(5, user.getContact());
                ps.setString(6, user.getOrganisation());
              return ps;
            }
        }, keyHolder);
		return row > 0 ?true : false;
	}
	@Override
	public boolean addVehicle(Vehicle vehicle) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
            	
            	PreparedStatement ps1 = connection.prepareStatement(SQL_CON,Statement.RETURN_GENERATED_KEYS); 
                ps1.executeUpdate();
            	
            	
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT_VEHICLE,Statement.RETURN_GENERATED_KEYS); 
                ps.setString(1, vehicle.getName());
                ps.setString(2, vehicle.getType());
                ps.setString(3, vehicle.getVehicleNumber());
                ps.setString(4, vehicle.getEmployeeID());
                ps.setString(5, vehicle.getIdentification());
                ps.setString(6, vehicle.getEmail());
              return ps;
            }
        }, keyHolder);
		return row > 0 ?true : false;
	}
	
	
	
	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPass(Pass user) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
            	
            	PreparedStatement ps1 = connection.prepareStatement(SQL_CON,Statement.RETURN_GENERATED_KEYS); 
                ps1.executeUpdate();
            	
            	
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT_PASS,Statement.RETURN_GENERATED_KEYS); 
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getAmount());
               
              return ps;
            }
        }, keyHolder);
		return row > 0 ?true : false;
	}

	@Override
	public Employee showEmployee(String email) {
			return jdbcTemplate.queryForObject(SQL_FIND_USER, new Object[] { email }, new EmployeeMapper());	
	}
	
	

	@Override
	public boolean update(Employee user) {
		System.out.println("USER EMAIL"+user.getContact());
		return jdbcTemplate.update(SQL_UPDATE_USER, user.getFullName(),user.getGender(),user.getPassword(),user.getContact(),user.getOrganisation(),user.getEmailID()) > 0;
	}

	@Override
	public List<Employee> getList(String organ,String email) {
		List<Map<String, Object>> list1=retrieveMultipleRowsColumns(organ,email);
		System.out.println("THERE R"+list1);
		List<Employee> employ=new ArrayList<Employee>();
		//List<Map<String, Object>> list = getMyMap();    
		for (Map<String, Object> map : list1) {
		   // for (Map.Entry<String, Object> entry : map.entrySet()) {
		       // System.out.println("KEY "+entry.getKey() + " - " + "VALUE "+entry.getValue());
		        String emailID=(String) map.get("email");
		        System.out.println("THE MAIL"+emailID);
		        employ.add(showEmployee(emailID));
		        
		        
		    //}
		}

		
		
		//System.out.println("THERE FINAL"+employ+" SIZE "+employ.size());
		return employ;
	}
	
	
	public List<Map<String, Object>> retrieveMultipleRowsColumns(String organ,String email){
		//System.out.println("I in 2"+jdbcTemplate.queryForList(SQL_GET_ALL, organ,email));
	    return jdbcTemplate.queryForList(SQL_GET_ALL, organ,email);
	}
	
	
	@Override
	public boolean updateImage(Employee user,String file) {
		System.out.println("USER EMAIL"+user.getContact());
		System.out.println("IN IMAGE UPDATE dao");
		return jdbcTemplate.update(SQL_UPDATE_IMAGE,"images/"+file,user.getEmailID()) > 0;
	}
	
	}


	
