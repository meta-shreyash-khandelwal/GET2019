<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Parking</title>
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
            <h2 align="center" class="text-primary">Spring Security</h2>
            <hr />
            <div> </div>
 <c:if test="${not empty errorMessge}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div></c:if>
           
           
           
           
            <form action="/index" method="POST">
            
              
                
                 <div class="form-group">
                    <label>UserName</label><input name="username" type="text" placeholder="Enter Username"/>
                   
                  </div>
                 <div class="form-group">
                    <label>Password</label><input name="password"  type="password" placeholder="Enter Password" />
                   
                  </div>
                
                 <div class="form-group">
                
                    <input name="submit" type="submit" value="Submit" class="btn btn-primary">
                 </div>
            </form>
        </div>
    </body>
</html>