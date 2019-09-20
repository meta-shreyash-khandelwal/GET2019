package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;


public interface UserDao {
    public void addStudent(Student user);
    public List<Student> getStudent();
    public Student findById(int id);

}