<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.AreaListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/dbrocks_main.css" />


<title>Welcome to our festival</title>
</head>

<body>
		<%@include file="navi.jsp"%>

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
	<div class="content container">

	
		<h1>Welcome, dear <%=s %> with number <%=session.getAttribute(s) %></h1>

	</div>
	<%
		}
	%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>