<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/dbrocks_main.css" />

<%
	String s = "";
%>
<%
	if (session.getAttribute("visitor") != null) {
		s = "visitor";
	} else if (session.getAttribute("staff") != null) {
		s = "staff";
	} else if (session.getAttribute("supplier") != null) {
		s = "supplier";
	} else {
		s = "person";
	}

	session.removeAttribute(s);
	
	s="";
%>

<title>Login/Register</title>
</head>

<body>

	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/DBrocks">DBRocks</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Location <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="area">Areas</a></li>
						<li><a href="stage">Stages</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">MusicAndMore <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="performance">Performances</a></li>
						<li><a href="band">Bands</a></li>
						<li><a href="sponsor">Sponsors</a></li>
					</ul></li>
				<%
					if (s.equals("visitor") || s.equals("staff")) {
				%>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Visitors Place <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="timetable">My Timetable</a></li>
						<li><a href="RFID_Ticket">My Ticket</a></li>
					</ul></li>
				<%
					}
				%>
				<%
					if (s.equals("supplier") || s.equals("staff")) {
				%>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Suppliers Place <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">(Maxi schreib sauber!)</a></li>
						<li><a href="booth">My Booths</a></li>
						<li><a href="advertising">My Advertisement</a></li>
						<li><a href="transaction">My Transactions</a></li>
						<li><a href="product">My Products</a></li>
						<li><a href="advertising">All Advertisements (per Area)</a></li>
					</ul></li>
				<%
					}
				%>
				<%
					if (s.equals("staff")) {
				%>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Organisation <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="sponsor">Sponsors</a></li>
						<li><a href="booth">Booths</a></li>
						<li><a href="transaction">Transactions</a></li>
						<li><a href="advertising">Advertising</a></li>
						<li><a href="staff">Staff</a></li>
						<li><a href="note">Notes</a></li>
					</ul></li>
				<%
					}
				%>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%
					if (session.getAttribute(s) == null) {
				%>
				<li><a href="Login">Login / Register</a></li>
				<%
					} else {
				%>
				<li><a href="Login">Logout</a></li>
				<%
					}
				%>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>
	
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
>>>>>>> branch 'master' of https://github.com/ga67vib/DBrocks.git
</html>