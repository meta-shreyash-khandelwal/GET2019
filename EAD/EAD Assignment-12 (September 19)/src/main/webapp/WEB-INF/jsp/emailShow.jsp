<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>
Form Details Submitted by User
</h1>
<hr>
<br>

 <h2>The searched Student details are as follows:</h2><br>
 <table>
 <tr>
 <th>
 First Name
 </th>
 <th>
 Last name
 </th>
 <th>
 Father's name
 </th>
 
 <th>
 Email
 </th>
 
  <th>
 class
 </th>
   <th>
age
 </th>
 </tr>
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
 ${user.email}
 </td>
 <td>
${user.className}
 </td>
  <td>
${user.age}
 </td>
  </tr>
 </table>

</div>
<a href="/index">Go to Home Page</a>
</body>
</html>