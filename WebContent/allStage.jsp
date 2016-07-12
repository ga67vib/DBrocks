<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.StageListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/dbrocks_main.css" />
<title>AllStage</title>
</head>
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
		
		<h1>Our cool Stages:</h1>

		<div class="box">
			<table style="width: 100%">
				<tr>
					<th>StageID</th>
					<th>Area</th>
					<th>Name</th>
					<th>Auditorium Size</th>
					<th>Stage Size</th>
					<th>Description</th>
				</tr>
				<%
					for (int i = 0; i < bean.getList().size(); i++) {
				%>
				<tr>
					<td><%=bean.getChild(i).getStageID()%></td>
					<td><%=bean.getChild(i).getIsin().getAreaID()%></td>
					<td><%=bean.getChild(i).getStageName()%></td>
					<td><%=bean.getChild(i).getAuditSize()%></td>
					<td><%=bean.getChild(i).getStageSize()%></td>
					<td><%=bean.getChild(i).getDescription()%></td>
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