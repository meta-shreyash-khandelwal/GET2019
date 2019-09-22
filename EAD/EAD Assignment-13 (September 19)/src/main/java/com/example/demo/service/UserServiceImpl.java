package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService  {
	
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void createUser(Student user) {
		studentRepository.save(user);
		
	}

	@Override
	public List<Student> getUser() {
		return studentRepository.findAll();
	}

	@Override
	public Student getByEmail(String email) {
				return studentRepository.findByEmail(email);
	}





}
