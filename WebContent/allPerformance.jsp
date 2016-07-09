<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.PerformanceListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>AllPerformance</title>
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

		<h1>Our cool Performances:</h1>

		<div class="box">
			<table style="width: 100%">
				<tr>
					<th>PerformanceID</th>
					<th>Stage</th>
					<th>Build Up</th>
					<th>Begin</th>
					<th>End</th>
					<th>End Removal</th>
				</tr>
				<%
					for (int i = 0; i < bean.getList().size(); i++) {
				%>
				<tr>
					<td><%=bean.getChild(i).getPerformanceID()%></td>
					<td><%=bean.getChild(i).getIsAt().getStageName()%></td>
					<td><%=bean.getChild(i).getStartBuildUp()%></td>
					<td><%=bean.getChild(i).getStartTime()%></td>
					<td><%=bean.getChild(i).getEndTime()%></td>
					<td><%=bean.getChild(i).getEndRemoval()%></td>
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