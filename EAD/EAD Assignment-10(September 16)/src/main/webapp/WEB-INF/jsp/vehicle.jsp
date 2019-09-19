<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
 <head>
   <link href="css/park2.css" rel="stylesheet" type="text/css">
  <link href="css/park1.css" rel="stylesheet" type="text/css">
         <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <style type="text/css">
            .errormsg {
                color: red;
            }
            
            
        </style>
    </head>
    <body>
  
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!-- Navigation -->
  <header class="topbar">
      <div class="container">
        <div class="row">
          <!-- social icon-->
          <div class="col-sm-12">
            <ul class="social-network">
              <li><a class="waves-effect waves-dark" href="#"><i class="fa fa-facebook"></i></a></li>
              <li><a class="waves-effect waves-dark" href="#"><i class="fa fa-twitter"></i></a></li>
              <li><a class="waves-effect waves-dark" href="#"><i class="fa fa-linkedin"></i></a></li>
              <li><a class="waves-effect waves-dark" href="#"><i class="fa fa-pinterest"></i></a></li>
              <li><a class="waves-effect waves-dark" href="#"><i class="fa fa-google-plus"></i></a></li>
            </ul>
          </div>

        </div>
      </div>
  </header>
  <nav class="navbar navbar-expand-lg navbar-dark mx-background-top-linear">
    <div class="container">
      <a class="navbar-brand" href="index.html" style="text-transform: uppercase;">Metacube Parking</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">

        <ul class="navbar-nav ml-auto">

          <li class="nav-item">
            <a class="nav-link" href="#">Home
            </a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="#">Login</a>
              <span class="sr-only">(current)</span>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="#">Vehicle Registration</a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="#">Vehicle Pass Form</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>


 <h1>${vehicleform.type}</h1>



<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
                        <h3>Vehicle Registration Form</h3>
                             </div>
                    <div class="col-md-9 register-right">
                         <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Vehicle Pass Form</h3>
                                <div class="row register-form">
                                <form:form action="/addVehicle" method="GET" modelAttribute="vehicleform">
                                                   <div class="form-group">
                                         <form:input path="name" size="30" cssClass="form-control" placeholder="Enter Full Name" />
                                        </div>
                                                <div class="form-group">
                                                                              
                                                 <form:select path="type" name="type">

                <form:option value="cycle">Cycle</form:option>
                <form:option value="motorcycle">MotorCycle</form:option>
                <form:option value="four">Four Wheeler</form:option>
            </form:select>
                                                  </div>
                                          <div class="form-group">
                                             <form:input path="vehicleNumber" size="30" cssClass="form-control" placeholder="Enter Vehicle Number" />
                                        </div>
                                         <div class="form-group">
                                         <form:hidden path="email" value='<%= session.getAttribute("email") %>'  />
                                        </div>
                                        
                                                                                <div class="form-group">
                                         <form:input path="employeeID" size="30" cssClass="form-control" placeholder="Enter EmployeeID" />
                                        </div>
                                        
                                        <div class="form-group">
                                        	<form:textarea cssClass="form-control rounded-0" path="identification" rows="5" cols="25" placeholder="Please Enter the vehicle description"/>
                           
                                    </div>
                                  
                                      <input type="submit" class="btnRegister"  value="Register Vehicle"/>
                                    </form:form>
                                    
                                </div>
                            </div>
                       </div>
                    </div>
                </div>

            </div>
    </body>
</html>