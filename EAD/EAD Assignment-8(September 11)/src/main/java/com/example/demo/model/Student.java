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

public class Student {
@NotBlank(message="{firstNameError}")
private String firstName;
@NotBlank(message="{lastNameError}")
private String lastName;
@NotBlank(message="{fatNameError}")
private String fatherName;

@NotBlank(message="{emailBlank}")
@Pattern(regexp = "^(.+)@(.+)$")
private String email;

@NotBlank(message="{classBlank}")
@Pattern(regexp = "\\d+")
String className;

@NotBlank(message="{ageBlank}")
@Pattern(regexp = "\\d+")
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
