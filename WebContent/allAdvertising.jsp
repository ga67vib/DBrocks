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
	if (session.getAttribute("supplier") != null  && !request.getAttribute("javax.servlet.forward.request_uri").equals("/DBrocks/advertising")) {
	
%>
<title>My Advertisements</title>
<%
	} else {
%>
<title>All Advertisements</title>
<%
	}
%>
</head>

<body>
	<%@include file="navi.jsp"%>

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


		<%
			if (session.getAttribute("supplier") != null && !request.getAttribute("javax.servlet.forward.request_uri").equals("/DBrocks/advertising")) {
		%>
		<h1>My Advertisements</h1>
		<%
			} else {
		%>
		<h1>All Advertisements</h1>
		<%
			}
		%>
		<div class="box">
			<table style="width: 100%">
				<tr>
					<th>Sponsor Name</th>
					<th>Area Name</th>
					<th>Area Size in m²</th>
					<th>Advertising Type</th>
				</tr>
				<%
					for (int i = 0; i < bean.getList().size(); i++) {
				%>
				<tr>
					<td><%=bean.getChild(i).getSponsor().getName()%></td>
					<td><%=bean.getChild(i).getArea().getName()%></td>
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