<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<body>
<div align="center">
	<h2>Spring Boot Spring MVC</h2>
	<hr>
	<br>
		<h3>${msg}</h3>
		
        <h3>${error} </h3>
    
		<strong><a href="addStudent">Add Student Detail</a></strong><br><br>
		<strong><a href="showStudent">Show All Student</a></strong><br><br>
	</div>

</body>
</html>