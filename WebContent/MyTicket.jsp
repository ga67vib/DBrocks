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
<title>My Ticket</title>
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

		<h1>My Ticket:</h1>

		<div class="box">
			<table style="width: 100%">
				<caption>Personal Data</caption>
				<tr>
					<th>Firstname</th>
					<td><%=bean.getChild(0).getOwnedBy().getFirstName()%></td>
				</tr>
				
				<tr>
					<th>Lastname</th>
					<td><%=bean.getChild(0).getOwnedBy().getLastName()%></td>
				</tr>
				
				<tr>
					<th>Birthdate</th>
					<td><%=bean.getChild(0).getOwnedBy().getBirthdate()%></td>
				</tr>
				
				<tr>
					<th>Address</th>
					<td><%=bean.getChild(0).getOwnedBy().getAddress()%></td>
				</tr>
				
				<tr>
					<th>E-Mail</th>
					<td><%=bean.getChild(0).getOwnedBy().getMail()%></td>
				</tr>
				
				<tr>
					<th>Phonenumber</th>
					<td><%=bean.getChild(0).getOwnedBy().getPhonenumber()%></td>
				</tr>
			
			</table>
		</div>
		
		<div class="box">
			<table style="width: 100%">
				<caption>Ticket Data</caption>
				<tr>
					<th>Account Balance</th>
					<td><%=bean.getChild(0).getAcctBal()%></td>
				</tr>
				
				<tr>
					<th>Camper</th>
					<td><%=bean.getChild(0).isCamper()%></td>
				</tr>
				
				<tr>
					<th>VIP</th>
					<td><%=bean.getChild(0).isVIP()%></td>
				</tr>
				
				<tr>
					<th>Valid from</th>
					<td><%=bean.getChild(0).getValidFrom()%></td>
				</tr>
				
				<tr>
					<th>Valid Until</th>
					<td><%=bean.getChild(0).getValidUntil()%></td>
				</tr>
				
				<tr>
					<th>Purchase Date</th>
					<td><%=bean.getChild(0).getPurchaseDate()%></td>
				</tr>
				
								
				<tr>
					<th>Price</th>
					<td><%=bean.getChild(0).getPrice()%></td>
				</tr>
			
			</table>
		</div>
		

	<%
		}
	%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>