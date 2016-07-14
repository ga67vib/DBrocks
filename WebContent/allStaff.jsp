<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.StaffListBean"></jsp:useBean>
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

		<h1>
			Our Staff
			<%=request.getAttribute("shiftId") != null ? "in shift " + request.getAttribute("shiftId") : ""%>:
		</h1>

		<div class="box">
			<form method="GET" action="noteCreate">
				<table style="width: 100%">
					<tr>
						<th>PersonID</th>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Gender</th>
						<th>Profession</th>
						<th>Phonenumber</th>
						<th>Shifts</th>
						<th>Select</th>
					</tr>

					<%
						for (int i = 0; i < bean.getList().size(); i++) {
					%>
					<tr>
						<td><%=bean.getChild(i).getPersonID()%></td>
						<td><%=bean.getChild(i).getPersonData().getFirstName()%></td>
						<td><%=bean.getChild(i).getPersonData().getLastName()%></td>
						<td><%=bean.getChild(i).getPersonData().getGender().equals("f") ? "female" : "male"%></td>
						<td><%=bean.getChild(i).getProfession()%></td>
						<td><%=bean.getChild(i).getPersonData().getPhonenumber()%></td>
						<td><a
							href="shift?staffId=<%=bean.getChild(i).getPersonID()%>">Shifts</a>
						<td><input type="checkbox" name="selected<%=i%>"
							value="<%=bean.getChild(i).getPersonID()%>" /></td>

					</tr>
					<%
						}
					%>
				</table>
				<input type="submit" value="Create Note for selected staff">
				<%
					if (request.getAttribute("shiftId") != null) {
				%>
					<br/>
					<a class="link-button" href="staff">Go to all Staff</a>
				<%
					}
				%>
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