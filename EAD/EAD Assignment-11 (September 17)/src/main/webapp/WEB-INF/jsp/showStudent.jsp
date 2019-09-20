<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>      <%--Importing all the dependent classes--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page import="java.util.Iterator"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>
Show Student Form
</h1>
<hr>
<br>
<table border=1 style="padding: 15px;">
				<tr>
							<th>
							First Name
							</th>
							<th>
							Last Name
							</th>
							<th>
							Father's Name
							</th>
							<th>
							Age
							</th>
							<th>
							Class
							</th>
							<th>
							Email
							</th>
							</tr>
 	<c:forEach items="${users}" var="user">
						<tr>
						<td>
                 ${user.firstName}     
                 </td>   
                 <td>
                 ${user.lastName}   
                 </td>
                 
                   <td>
                 ${user.fatherName}   
                 </td>
                   <td>
                 ${user.age}   
                 </td>
                   <td>
                 ${user.className}   
                 </td>
                   <td>
                 ${user.email}   
                 </td>
			</tr>
					</c:forEach>
</table>
<a href="/index">Go to Home Page</a>
</div>

</body>
</html>