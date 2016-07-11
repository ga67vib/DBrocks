<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.AdvertisingListBean"></jsp:useBean>
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
%>

<title>Ads of our cool festival</title>
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

	
		<h1>Our cool advertisements:</h1>

		<div class="box">
			<table style="width: 100%">
				<tr>
					<th>Sponsor Name</th>
					<th>Sponsor ID</th>
					<th>Area Name</th>
					<th>Area ID</th>
					<th>Area Size</th>
					<th>Advertising Type</th>
				</tr>
				<%
					for (int i = 0; i < bean.getList().size(); i++) {
				%>
				<tr>
					<td><%=bean.getChild(i).getSponsor().getName() %></td>
					<td><%=bean.getChild(i).getSponsor().getSponsorID() %></td>
					<td><%=bean.getChild(i).getArea().getName()%></td>
					<td><%=bean.getChild(i).getArea().getAreaID()%></td>
					<td><%=bean.getChild(i).getArea().getSize()%></td>
					<td><%=bean.getChild(i).getType()%></td>
				</tr>
				<%
					}
				%>
			</table>
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