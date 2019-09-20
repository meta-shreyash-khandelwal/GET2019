package com.example.demo.service;


import java.util.List;


import com.example.demo.model.Student;


public interface UserService {
    public void createUser(Student user);
    public List<Student> getUser();
    public Student findById(int id);
  
}