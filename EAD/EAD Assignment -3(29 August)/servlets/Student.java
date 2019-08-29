package svk;

public class Student {
String firstName;
String lastName;
String fatherName;
String email;
int className;
int age;
public Student(String firstName, String lastName, String fatherName,
		String email, int className, int age) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.fatherName = fatherName;
	this.email = email;
	this.className = className;
	this.age = age;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public void setFatherName(String fatherName) {
	this.fatherName = fatherName;
}
public void setEmail(String email) {
	this.email = email;
}
public void setClassName(int className) {
	this.className = className;
}
public void setAge(int age) {
	this.age = age;
}
public String getFirstName() {
	return firstName;
}
public String getLastName() {
	return lastName;
}
public String getFatherName() {
	return fatherName;
}
public String getEmail() {
	return email;
}
public int getClassName() {
	return className;
}
public int getAge() {
	return age;
}

}
