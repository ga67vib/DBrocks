<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.PerformanceListBean"></jsp:useBean>
<%@ page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/dbrocks_main.css" />
<title>AllPerformance</title>
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

		<h1>Line-up:</h1>

		<div class="box">
			<table style="width: 100%">
				<tr>
					<th>Stage</th>
					<th>Performers</th>
					<th>Begin</th>
					<th>End</th>
				</tr>
				<%
					for (int i = 0; i < bean.getList().size(); i++) {
							SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
				%>
				<tr>
					<td><%=bean.getChild(i).getIsAt().getStageName()%></td>
					<td><%=bean.getChild(i).getAllPerformers()%></td>
					<td><%=formatter.format(bean.getChild(i).getStartTime())%></td>
					<td><%=formatter.format(bean.getChild(i).getEndTime())%></td>
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