package com.example.demo.model;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="detail")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Student {
	    

	
	
@NotBlank(message="{firstNameError}")
@Column(name="firstName")
private String firstName;



@NotBlank(message="{lastNameError}")
@Column(name="lastName")
private String lastName;


@NotBlank(message="{fatNameError}")
@Column(name="fatherName")
private String fatherName;

@Id
@NotBlank(message="{emailBlank}")
@Pattern(regexp = "^(.+)@(.+)$")
@Column(name="email")
private String email;

@NotBlank(message="{classBlank}")
@Pattern(regexp = "\\d+")
@Column(name="class")
String className;

@NotBlank(message="{ageBlank}")
@Pattern(regexp = "\\d+")
@Column(name="age")
String age;

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getFatherName() {
	return fatherName;
}
public void setFatherName(String fatherName) {
	this.fatherName = fatherName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}


}
