<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
            #cyclepassyen,#cyclepassus,#motorpassus,#motorpassyen,#fourpassyen,#fourpassus
            {
            display:none;
            }
               
        </style>
<script type="text/javascript" src="js/parking.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="show2('${vehicleform.type}')">

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
            </a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="/login">Login</a>
              <span class="sr-only">(current)</span>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Vehicle Registration</a>
          </li>

          <li class="nav-item active">
            <a class="nav-link" href="#">Vehicle Pass Form</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
                            <h3 class="register-heading">Vehicle Pass Form</h3>
                       </div> 
                    <div class="col-md-9 register-right">
                         <div class="tab-content" id="myTabContent">
        <div class="row register-form">
     
                                <form:form action="/addPass" method="GET" modelAttribute="passform">                         
                               <div class="form-group">
                                         <form:hidden path="email" value='<%= session.getAttribute("email") %>'  />
                                        </div>
                                        
                                        <%System.out.println("IN SESSON "+session.getAttribute("email")); %>
  
<div id="cyclepass">
<h3>The pass prices for the Cycle are as follows</h3><br>
<h4>Select any one of the following </h4>


<div id="cyclepassr">
<label class="btn btn-default">
<form:radiobutton path = "amount"  name="cyclepass" value="Rs.5" />Daily - Rs.5  <br><br>
</label>

<label class="btn btn-default">
<form:radiobutton path = "amount"  name="cyclepass" value="Rs.100"/>Monthly - Rs.100  <br><br>
</label>

<label class="btn btn-default">
<form:radiobutton path = "amount"  name="cyclepass" value="Rs.500"/>Yearly - Rs.500  <br><br>
</label>
</div>

<div id="cyclepassus">
<label>
<form:radiobutton path = "amount"  name="cyclepass" value="0.069 $"/>Daily - 0.069 $ <br><br>
</label>

<label class="btn btn-default">
<form:radiobutton path = "amount"  name="cyclepass" value="1.39$"/>Monthly - 1.39$ <br><br>
</label>
<label class="btn btn-default">
<form:radiobutton path = "amount"  name="cyclepass" value="6.95$"/>Yearly - 6.95$ <br><br>
</label>
</div>



<div id="cyclepassyen" >
<label class="btn btn-default">
<form:radiobutton path = "amount"   name="cyclepass" value="7.35 ¥"/>Daily - 7.35 ¥ <br><br>
</label>

<label class="btn btn-default">
<form:radiobutton path = "amount"   name="cyclepass" value="147.08 ¥"/>Monthly - 147.08 ¥  <br><br>
</label>


<label class="btn btn-default">
<form:radiobutton path = "amount"   name="cyclepass" value="735.42 ¥"/>Monthly - 735.42 ¥<br><br>
</label>
</div>



<label><b>Currency</b></label>
<select onchange="showCurrencyCycle()" id="currency" name="cry">
<option value="inr"  selected>INR</option>
<option value="usd">USD</option>
<option  value="yen" >YEN</option>
</select>
<br><br>

<button id="btn" onclick="showT()"> Get Pass </button>

</div>


<div id="motorpass" >
<h3>The pass prices for the MotorCycle are as follows</h3><br>
<h4>Select any one of the following </h4>
<div id="motorpassr" align="center">
<label class="btn btn-default">
<form:radiobutton path = "amount"  name="motorpass" value="Rs.10"/>Daily - Rs.10  <br><br>
</label>
<label class="btn btn-default">
<form:radiobutton path = "amount"  name="motorpass" value="Rs.200"/>Monthly - Rs.200  <br><br>
</label>

<label class="btn btn-default">
<form:radiobutton path = "amount"  name="motorpass" value="Rs.1000"/>Yearly - Rs.1000  <br><br>
</label>
</div>

<div id="motorpassus">
<label class="btn btn-default">
<form:radiobutton path = "amount"  name="motorpass" value="0.14 $"/>Daily - 0.14 $ <br><br>
</label>

<label class="btn btn-default">
<form:radiobutton path = "amount"  name="motorpass" value="2.78 $"/>Monthly - 2.78$ <br><br>
</label>
<label class="btn btn-default">
<form:radiobutton path = "amount"  name="motorpass" value="13.88 $"/>Yearly - 13.88$ <br><br>
</label>
</div>



<div id="motorpassyen" >
<label class="btn btn-default">
<form:radiobutton path = "amount"  name="motorpass" value="14.69 ¥"/>Daily - 14.69 ¥ <br><br>
</label>

<label class="btn btn-default">
<form:radiobutton path = "amount"  name="motorpass" value="293.89 ¥"/>Monthly - 293.89 ¥  <br><br>
</label>


<label class="btn btn-default">
<form:radiobutton path = "amount"  name="motorpass" value="1469.45 ¥"/>Yearly - 1469.45 ¥<br><br>
</label>
</div>



<label><b>Currency</b></label>
<select onchange="showCurrencyMotor()" id="currency1" name="cry1">
<option value="inr"  selected>INR</option>
<option value="usd">USD</option>
<option  value="yen" >YEN</option>
</select>
<br><br>
<button id="btn" onclick="showT()"> Get Pass </button>
</div>



<div id="fourpass" >
<h3>The pass prices for the Four-Wheeler are as follows</h3><br>
<h4>Select any one of the following </h4>
<div id="fourpassr" align="center">
<label class="btn btn-default">
<form:radiobutton path = "amount"  name="fourpass" value="Rs.20"/>Daily - Rs.20  <br><br>
</label>

<label class="btn btn-default">
<form:radiobutton path = "amount" name="fourpass" value="Rs.500"/>Monthly - Rs.500  <br><br>
</label>

<label class="btn btn-default">
<form:radiobutton path = "amount"  name="fourpass" value="Rs.3500"/>Yearly - Rs.3500  <br><br>
</label>
</div>

<div id="fourpassus" >
<label class="btn btn-default">
<form:radiobutton path = "amount"  name="fourpass" value="0.28$"/>Daily - 0.28 $ <br><br>
</label>

<label class="btn btn-default">
<form:radiobutton path = "amount"  name="fourpass" value="6.94$"/>Monthly - 6.94$ <br><br>
</label>
<label class="btn btn-default">
<form:radiobutton path = "amount"  name="fourpass" value="48.60$"/>Yearly - 48.60 <br><br>
</label>
</div>



<div id="fourpassyen" >
<label class="btn btn-default">
<form:radiobutton path = "amount"  name="fourpass" value="29.39¥"/>Daily - 29.39 ¥ <br><br>
</label>

<label class="btn btn-default">
<form:radiobutton path = "amount"  name="fourpass" value="734.72 ¥"/>Monthly - 734.72 ¥  <br><br>
</label>

<label class="btn btn-default">
<form:radiobutton path = "amount"  name="fourpass" value="5143.07 ¥"/>Yearly - 5143.07 ¥<br><br>
</label>
</div>



<label><b>Currency</b></label>
<select onchange="showCurrencyFour()" id="currency2" name="cry2">
<option value="inr"  selected>INR</option>
<option value="usd">USD</option>
<option  value="yen" >YEN</option>
</select>
<br><br>
<button id="btn" onclick="showT()"> Get Pass </button>
</div>
<p id="showTicket"></p>        
 
                                </form:form>
                                     </div>
                                </div>
                            </div>
                       </div>
                  </div>
            
</body>
</html>