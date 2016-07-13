
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
	if (request.getRequestURI().equals("/DBrocks/login.jsp")) {

		session.removeAttribute(s);

		s = "";
	}
%>


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
						<li><a href="myTicket">My Ticket</a></li>
					</ul></li>
				<%
					}
				%>
				<%
					if (s.equals("supplier")) {
				%>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Suppliers Place <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="myBooth">My Booths</a></li>
						<li><a href="myAdvertising">My Advertisement</a></li>
						<li><a href="myTransaction">My Transactions</a></li>
						<li><a href="myProduct">My Products</a></li>
						<li><a href="advertising">All Advertisements</a></li>
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
						<li><a href="Organization">My Profile</a></li>
						<li><a href="RFID_Ticket">Tickets</a></li>
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