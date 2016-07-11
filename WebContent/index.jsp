<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN"
   "http://www.w3.org/TR/html4/frameset.dtd">
<HTML>
<HEAD>
<TITLE>DBRocks</TITLE>

<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/dbrocks_main.css" />
</HEAD>
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
<nav class="navbar navbar-default navbar-fixed-top">
<div class="container">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#navbar" aria-expanded="false"
			aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
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
			<li><a href="login">Login / Register</a></li>
			<%
					} else {
				%>
			<li><a href="login">Logout</a></li>
			<%
					}
				%>
		</ul>
	</div>
	<!--/.nav-collapse -->
</div>
</nav>
<div class="content container">
	<div class="box">
		<p>Hello together!</p>
	</div>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</HTML>

