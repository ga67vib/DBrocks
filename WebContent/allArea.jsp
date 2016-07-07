<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.AreaListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="/BaseProject/css/ex7.css" />

<title>Areas of our cool festival</title>
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

		<h1>Our cool areas:</h1>

		<div class="box">
			<table style="width: 100%">
				<tr>
					<th>AreaID</th>
					<th>Size</th>
					<th>Location</th>
				</tr>
				<%
					for (int i = 0; i < bean.getList().size(); i++) {
				%>
				<tr>
					<td><%=bean.getChild(i).getAreaID()%></td>
					<td><%=bean.getChild(i).getSize()%></td>
					<td><%=bean.getChild(i).getLocation()%></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>

	</div>
</body>
</html>