package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Student;

@Service
@Transactional
public class UserServiceImpl implements UserService  {
    @Autowired
    UserDao userDao;

   
    public List<Student> getUser() {
        return userDao.getStudent();
    }

    public Student findById(int id) {
        return userDao.findById(id);
    }

    public void createUser(Student user) {
        userDao.addStudent(user);
    }




}
