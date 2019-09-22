<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<body>
<div align="center">
	<h2>Spring Boot Spring MVC</h2>
	<hr>
	<br>
		<h3>${msg}</h3>
		
         <form:form action="/showemail" method="GET" modelAttribute="userforms">
                                        
                     
                     
                     <div class="form-group">
                    <label>Email:</label>
                    <form:input path="email" size="30" cssClass="form-control" placeholder="Enter email Address" />    
                       <font color="red"> <form:errors path="email"></form:errors></font><br/>       
                </div>
              
            
                     
                 <div class="form-group">
                    <button type="submit" class="btn btn-primary">Submit Email</button>
                 </div>
            </form:form>
</body>
</html>