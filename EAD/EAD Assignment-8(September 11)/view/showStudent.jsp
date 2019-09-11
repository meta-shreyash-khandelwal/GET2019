<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>      <%--Importing all the dependent classes--%>

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
<table>
<%
List<String> student=new ArrayList<String>();
student.add("Arjun");
student.add("Varun");
student.add("Shreyash");
student.add("Ray");
student.add("Jack");
for(int i=0;i<student.size();i++)
{
	%>
	
	<tr><td><%=student.get(i)%></td>
	 </tr>
	 <%
}
%>
</table>

</div>

</body>
</html>