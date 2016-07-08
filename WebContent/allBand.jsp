<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.BandListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Here are all the bands!</title>
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

		<h1>Our cool bands:</h1>

		<div class="box">
			<table style="width: 100%">
				<tr>
					<th>BandID</th>
					<th>Name</th>
					<th>Salary</th>
					<th>Songlist</th>
					<th>Instruction</th>
				</tr>
				<%
					for (int i = 0; i < bean.getList().size(); i++) {
				%>
				<tr>
					<td><%=bean.getChild(i).getBandID()%></td>
					<td><%=bean.getChild(i).getBandName()%></td>
					<td><%=bean.getChild(i).getSalary()%></td>
					<td><%=bean.getChild(i).getSonglist()%></td>
					<td><%=bean.getChild(i).getInstruction()%></td>
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