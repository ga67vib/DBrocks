<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.SponsorListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>AllSponsor</title>
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

		<h1>Our cool Sponsors:</h1>

		<div class="box">
			<table style="width: 100%">
				<tr>
					<th>SponsorID</th>
					<th>Address</th>
					<th>Payment</th>
					<th>Required Booths</th>
					<th>Assigned Booths</th>
				</tr>
				<%
					for (int i = 0; i < bean.getList().size(); i++) {
				%>
				<tr>
					<td><%=bean.getChild(i).getSponsorID()%></td>
					<td><%=bean.getChild(i).getAddress()%></td>
					<td><%=bean.getChild(i).getPayment()%></td>
					<td><%=bean.getChild(i).getNumReqBooths()%></td>
					<td><%=bean.getChild(i).getNumAssBooths()%></td>
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