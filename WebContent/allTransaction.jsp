<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.TransactionListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/dbrocks_main.css" />
<%
	if (session.getAttribute("supplier") != null) {
%>
<title>My Transactions</title>
<%
	} else {
%>
<title>All Transactions</title>
<%
	}
%>
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

			if (session.getAttribute("supplier") != null) {
	%>
	<h1>My Transactions</h1>
	<%
			} else {
	%>
	<h1>All Transactions</h1>
	<%
			}
	%>
	<div class="box">
		<table style="width: 100%">
			<tr>
				<th>TransactionID</th>
				<th>Product</th>
				<th>Quantity</th>
				<th>Ticket</th>
				<th>Booth</th>
				<th>Time</th>
			</tr>
			<%
				for (int i = 0; i < bean.getList().size(); i++) {
			%>
			<tr>
				<td><%=bean.getChild(i).getTransactionID()%></td>
				<td><%=bean.getChild(i).getProduct().getName()%></td>
				<td><%=bean.getChild(i).getQuantity()%></td>
				<td><%=bean.getChild(i).getTicket().getTicketID()%></td>
				<td><%=bean.getChild(i).getBooth().getName()%></td>
				<td><%=bean.getChild(i).getTransactionTime()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</div>
<%
	}
%><script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>