<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.RFID_TicketListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/dbrocks_main.css" />
<title>All Tickets</title>
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

		<h1>All Tickets:</h1>

		<div class="box">
			<table style="width: 100%">
				<tr>
					<th style="width: 10%">Ticket ID</th>
					<th style="width: 10%">Owned By</th>
					<th style="width: 10%">Acc Balance</th>
					<th style="width: 10%">Is Camper</th>
					<th style="width: 10%">Is VIP</th>
					<th style="width:10%">Purchase Price</th>
					<th style="width:10%">Purchase Date</th>
					<th style="width:10%">Valid From</th>
					<th style="width:10%">Valid To</th>

				</tr>
				<%
					for (int i = 0; i < bean.getList().size(); i++) {
				%>
				<tr>
					<td><%=bean.getChild(i).getTicketID()%></td>
					<td><%=bean.getChild(i).getOwnedBy().getFirstName() + " "
							+ bean.getChild(i).getOwnedBy().getLastName()%></td>
					<td><%=bean.getChild(i).getAcctBal()%></td>
					<td><%=bean.getChild(i).isCamper() ? "Yes" : "No"%></td>
					<td><%=bean.getChild(i).isVIP() ? "Yes" : "No"%></td>
					<td><%=bean.getChild(i).getPrice()%></td>
					<td><%=bean.getChild(i).getPurchaseDate()%></td>
					<td><%=bean.getChild(i).getValidFrom()%></td>
					<td><%=bean.getChild(i).getValidFrom()%></td>


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
>>>>>>> branch 'master' of https://github.com/ga67vib/DBrocks.git
</html>