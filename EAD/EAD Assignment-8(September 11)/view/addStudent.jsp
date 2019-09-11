<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <style type="text/css">
            .errormsg {
                color: red;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2 align="center" class="text-primary">Spring MVC Form Validation Example</h2>
            <hr />
            <div> </div>
 
            <form:form action="/show" method="POST" modelAttribute="userform">
            
              
                
                 <div class="form-group">
                    <label>First Name</label><form:input path="firstName" size="30" cssClass="form-control" placeholder="Enter First Name" />
                    <font color="red"> <form:errors path="firstName"></form:errors></font><br/>
                  </div>
                 <div class="form-group">
                    <label>Last Name</label><form:input path="lastName" size="30" cssClass="form-control" placeholder="Enter Last Name" />
                    <font color="red"> <form:errors path="lastName"></form:errors></font><br/>
                  </div>
                     <div class="form-group">
                    <label>Father's Name</label><form:input path="fatherName" size="30" cssClass="form-control" placeholder="Enter Father's Name" />
                    <font color="red"> <form:errors path="fatherName"></form:errors></font><br/>
                  </div>
                               
                     
                     
                     <div class="form-group">
                    <label>Email:</label><form:input path="email" size="30" cssClass="form-control" placeholder="Enter email Address" />    
                       <font color="red"> <form:errors path="email"></form:errors></font><br/>       
                </div>
              
                 <div class="form-group">
                    <label>Age:</label><form:input path="age" size="30" cssClass="form-control" placeholder="Enter Age in number" />    
                       <font color="red"> <form:errors path="age"></form:errors></font><br/>       
                </div>
              
                 <div class="form-group">
                    <label>Class:</label><form:input path="className" size="30" cssClass="form-control" placeholder="Enter class between 1 to 12" />    
                       <font color="red"> <form:errors path="className"></form:errors></font><br/>       
                </div>
                     
                 <div class="form-group">
                    <button type="submit" class="btn btn-primary">Submit</button>
                 </div>
            </form:form>
        </div>
    </body>
</html>