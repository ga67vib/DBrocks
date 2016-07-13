<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/dbrocks_main.css" />


<%@include file="navi.jsp"%>


<title>Login/Register</title>
</head>

<body>


	<div class="content container">

		<%
			if (request.getAttribute("error") != null) {
		%>
			<div class="box">
		
				<h1>An error occured!</h1>
				<%=request.getAttribute("error")%>
			</div>
		<%
			} else {
		%>

		<h1>Here you can log in:</h1>

		<div class="box">

			 <form method="POST">
			 	<input type="hidden" name="whoami" value="login">
			 	Mail address:<br>
			 	<input type="text" name="mail"><br>
			 	Password:<br>
			 	<input type="password" name="password">
			 	<input type="submit" value="Login">
			 </form> 

		</div>
		
		<h1>Here you can log in as Sponsor:</h1>

		<div class="box">

			 <form method="POST">
			 	<input type="hidden" name="whoami" value="login-sponsor">
			 	Sponsor ID:<br>
			 	<input type="text" name="id"><br>
			 	Password:<br>
			 	<input type="password" name="password-sponsor">
			 	<input type="submit" value="Login">
			 </form> 

		</div>

		<h1>Here you can register:</h1>

		<div class="box">
			 <form method="POST">
			 	<input type="hidden" name="whoami" value="register">
			 	First Name:<br>
			 	<input type="text" name="firstname"><br>
			 	Last Name:<br>
			 	<input type="text" name=lastname><br>
			 	Mail address:<br>
			 	<input type="text" name="email"><br>
			 	Password:<br>
			 	<input type="password" name="newPassword"><br>
			 	Birthday:<br>
			 	<input type="text" name="bday"><br>
			 	Gender:<br>
			 	<input type="radio" name="gender" value="m" checked> Male<br>
  				<input type="radio" name="gender" value="f"> Female<br>
  				Address:<br>
  				<input type="text" name="address"><br>
  				Phonenumber:<br>
  				<input type="text" name="phonenumber"><br>
  				<input type="radio" name="camper" value="camper"> Camper<br>
  				<input type="radio" name="vip" value="vip"> VIP<br>
  				<% //*Ticket valid from:<br>
  				//*<input type="date" name="valid_from" min="2016-08-19"><br>
  				//*Ticket valid until:<br>
  				//*<input type="date" name="valid_until" max="2016-08-21"><br> %>
  				Preferred Genre:<br>
  				<input type="text" name="prefGenre"><br>
  				<br>
  				Since today is a special day, your ticket costs only 9.99 for the whole festival!<br>
			 	<br>
			 	<input type="submit" value="Register">
			 </form> 
		</div>
	</div>
	<%
		}
	%>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>