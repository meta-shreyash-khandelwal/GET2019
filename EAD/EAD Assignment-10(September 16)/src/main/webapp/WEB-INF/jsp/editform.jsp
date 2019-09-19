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
            <a class="nav-link" href="/index">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="/login">Login</a>
          </li>
     
          <li class="nav-item active">
            <a class="nav-link" href="#">Edit</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>







<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
                        <h3>Edit Form</h3>
                    </div>
                    <div class="col-md-9 register-right">
                         <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Employee Edit Form</h3>
                                <div class="row register-form">
                              
                                                                    <div class="col-md-8">
                                                                  <form:form action="/editing?qid=${editfm.emailID}" method="GET" modelAttribute="editfm">
                                        <div class="form-group">
                                            <form:input path="fullName" size="30" cssClass="form-control" value="${editfm.fullName}" />
                                        </div>
                                        <div class="form-group">
                                            <form:input path="password" size="30" cssClass="form-control" value="${editfm.password}" />
                                        </div>
                                        <div class="form-group">
                                        <form:input path="confirm" size="30" cssClass="form-control" value="${editfm.password}" />
                                        </div>
                                          <div class="form-group">
                                         <form:hidden path="emailID" value='<%= session.getAttribute("email") %>'  />
                                        </div>
                                        <div class="form-group">
                                            <div class="maxl">
                                                <label class="radio inline"> 
                                                    <input type="radio" name="gender" value="male" checked>
                                                    <span> Male </span> 
                                                </label>
                                                <label class="radio inline"> 
                                                    <input type="radio" name="gender" value="female">
                                                    <span>Female </span> 
                                                </label>
                                            </div>
                                        </div>
                                   
                                        <div class="form-group">
                                             <form:input path="contact" size="30" cssClass="form-control" value="${editfm.contact}"/>
                                        </div>
                                        <div class="form-group">
                                         
                                                 <form:select path="organisation">
                <label>Organisation</label><br>
                <form:option value="metacube">Metacube</form:option>
                <form:option value="google">Google</form:option>
                <form:option value="facebook">Facebook</form:option>
                <form:option value="microsoft">Microsoft</form:option>
            </form:select>
               
                                        </div>
                             
                                     <input type="submit" class="btnRegister"  value="Update Detail"/>
                                     </form:form>
                                    </div>
                                </div>
                            </div>
                       </div>
                    </div>
                </div>

            </div>
    </body>
</html>