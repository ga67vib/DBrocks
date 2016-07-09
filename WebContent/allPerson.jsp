<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.PersonListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>AllPerson</title>
</head>

<body>


	<a id="home" href="../">Back to Home</a>
	<%
		if (request.getAttribute("error") != null) {
	%>
	<h1>An error occured!</h1>
	<%=request.getAttribute("error")%>

	<%
		} else {
	%>
	<div class="container">

		<h1>Our cool Persons:</h1>

		<div class="box">
			<table style="width: 100%">
				<tr>
					<th>PersonID</th>
					<th>Birthdate</th>
					<th>Gender</th>
					<th>Mail </th>
					<th>Address</th>
					<th>First_name</th>
					<th>Last_name</th>
					<th>Phone_number</th>
					<th>Do notify?</th>
					<th>Password</th>
				<%
					for (int i = 0; i < bean.getList().size(); i++) {
				%>
				<tr>
					<td><%=bean.getChild(i).getPersonID()%></td>
					<td><%=bean.getChild(i).getBirthdate()%></td>
					<td><%=bean.getChild(i).getGender()%></td>
					<td><%=bean.getChild(i).getMail()%></td>
					<td><%=bean.getChild(i).getAddress()%></td>
					<td><%=bean.getChild(i).getFirstName()%></td>
					<td><%=bean.getChild(i).getLastName()%></td>
					<td><%=bean.getChild(i).getPhonenumber()%></td>
					<td><%=bean.getChild(i).isDoNotify()%></td>
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
</body>
</html>