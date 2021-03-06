<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.ShiftListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/dbrocks_main.css" />
<title>AllStaff</title>
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

		<h1>Shifts of Staffmember: <%= request.getAttribute("staffname") %>:</h1>


		<div class="box">
			<table style="width: 100%">
				<tr>
					<th>ShiftID</th>
					<th>Start Time</th>
					<th>End Time</th>
					<th>Workers</th>

				</tr>
				<%
					for (int i = 0; i < bean.getList().size(); i++) {
				%>
				<tr>
					<td><%=bean.getChild(i).getShiftID()%></td>
					<td><%=bean.getChild(i).getStartTime()%></td>
					<td><%=bean.getChild(i).getEndTime()%></td>
					<td><a href="staff?shiftId=<%=bean.getChild(i).getShiftID()%>"><%=bean.getChild(i).getWorkers()%></a></td>
		

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