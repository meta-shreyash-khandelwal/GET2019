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

          <li class="nav-item active">
            <a class="nav-link" href="#">Home Page
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/friendEmp">Friends</a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="/destroy">Logout</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
                        <h3>Welcome</h3>
                      
                    </div>
                    <div class="col-md-9 register-right">
                         <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Friend Details</h3>
                                <div class="row register-form">
                              
                                                                    <div class="col-md-8">
                             
                             <table border="1">
                                 <tr>
                             <td>
                             Profile
                             </td>
                             <td>
                            
  <img src=${friendsh.url} height="50px" width="50px"/>
                             </td>
                             </tr>
                         <tr>
                             <td>
                             Name
                             </td>
                             <td>
                            ${friendsh.fullName}
                             </td>
                             </tr>
                             
                                   <tr>
                             <td>
                             Email
                             </td>
                             <td>
                            ${friendsh.emailID}
                             </td>
                             </tr>
                             
                             
                                   <tr>
                             <td>
                             Gender
                             </td>
                             <td>
                            ${friendsh.gender}
                             </td>
                             </tr>
                             
                             
                                   <tr>
                             <td>
                            Contact
                             </td>
                             <td>
                            ${friendsh.contact}
                             </td>
                             </tr>
                             
                             
                             
                                   <tr>
                             <td>
                             Organisation
                             </td>
                             <td>
                            ${friendsh.organisation}
                             </td>
                             </tr>
                  
                           </table>
                  <a href="/loginedit">Go back </a>           
                                </div>
                                </div>
                            </div>
                       </div>
                    </div>
                </div>

            </div>


</body>
</html>