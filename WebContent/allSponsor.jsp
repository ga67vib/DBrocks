<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.SponsorListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/dbrocks_main.css" />
<title>AllSponsor</title>
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

	<h1>Our cool Sponsors:</h1>


	<%
		if (session.getAttribute("staff") != null
					&& request.getAttribute("javax.servlet.forward.request_uri").equals("/DBrocks/sponsorlist")) {
	%>
	<div class="box">
		<table style="width: 100%">
			<tr>
				<th>Company</th>
				<th>Address</th>
				<th>Payment</th>
				<th>Required Booths</th>
				<th>Assigned Booths</th>
			</tr>
			<%
				for (int i = 0; i < bean.getList().size(); i++) {
			%>
			<tr>
				<td><%=bean.getChild(i).getName()%></td>
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

	<%
		} else {

				for (int i = 0; i < bean.getList().size(); i++) {
	%>
	<div class="box">
		<h1><%=bean.getChild(i).getName()%></h1>
		<h3>
			Address:
			<%=bean.getChild(i).getAddress()%>
		</h3>
		<h4>
			Booths on Festival:
			<%=bean.getChild(i).getNumAssBooths()%></h4>
	</div>
	<%
		}

			}
	%>
</div>
<%
	}
%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>