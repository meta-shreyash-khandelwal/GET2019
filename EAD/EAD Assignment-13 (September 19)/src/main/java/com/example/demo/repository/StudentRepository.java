package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;

import java.util.*;
import com.example.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

	 //@Query("SELECT * FROM detail AS c WHERE c.email =email")
	  Student findByEmail(String email);
	
	  	}
