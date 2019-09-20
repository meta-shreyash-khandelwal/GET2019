package com.example.demo.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;


@Repository
public class UserDaoImpl implements UserDao{
    
	
	@Autowired
	HibernateTemplate template;
	@Autowired
	public void setTemplate(HibernateTemplate template){
	this.template = template;
	}
	
		
	@Override
	public void addStudent(Student user) {
		  template.save(user);
		
	}


	@Override
	public List<Student> getStudent() {
		return template.loadAll(Student.class);
		
	}


	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Student> getStudent() {
//		 Session session = sessionFactory.openSession();
//	        @SuppressWarnings("unchecked")
//	        List<Student> list= session.createCriteria(Student.class).list();
//	        return list;
//	
//	}
//
//	@Override
//	public Student findById(int id) {
//		 Session session = sessionFactory.openSession();
//	        Student user=(Student) session.get(Student.class,id);
//	        return user;
//	}

	
}