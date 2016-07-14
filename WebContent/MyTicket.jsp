<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>

<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.RFID_TicketListBean"></jsp:useBean>
<jsp:useBean id="transbean" scope="request"
	class="de.tum.in.dbpra.model.bean.TransactionListBean"></jsp:useBean>
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
				<th>First name</th>
				<td><%=bean.getChild(0).getOwnedBy().getFirstName()%></td>
			</tr>

			<tr>
				<th>Last name</th>
				<td><%=bean.getChild(0).getOwnedBy().getLastName()%></td>
			</tr>

			<tr>
				<th>Date of birth</th>
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
				<th>Phone number</th>
				<td><%=bean.getChild(0).getOwnedBy().getPhonenumber()%></td>
			</tr>

		</table>
	</div>

	<div class="box">
		<table style="width: 100%">
			<caption>Ticket Data</caption>
			<tr>
				<th>Account Balance in €</th>
				<td><%=bean.getChild(0).getAcctBal()%></td>
			</tr>

			<tr>
				<th>Camper</th>
				<td><%=bean.getChild(0).isCamper() ? "Yes" : "No"%></td>
			</tr>

			<tr>
				<th>VIP</th>
				<td><%=bean.getChild(0).isVIP() ? "Yes" : "No"%></td>
			</tr>

			<tr>
				<th>Valid from</th>
				<td><%=bean.getChild(0).getValidFrom()%></td>
			</tr>

			<tr>
				<th>Valid until</th>
				<td><%=bean.getChild(0).getValidUntil()%></td>
			</tr>

			<tr>
				<th>Purchase Date</th>
				<td><%=bean.getChild(0).getPurchaseDate()%></td>
			</tr>


			<tr>
				<th>Price in €</th>
				<td><%=bean.getChild(0).getPrice()%>.00</td>
			</tr>

		</table>
	</div>

	<div class="box">
		<table style="width: 100%">
			<caption>My Transactions</caption>
			<tr>
				<th>#</th>
				<th>Product</th>
				<th>Quantity</th>
				<th>Price in €</th>
				<th>Booth</th>
				<th>Time</th>
			</tr>
			<%
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

					for (int i = 0; i < bean.getList().size(); i++) {
			%>
			<tr>
				<td><%=i + 1%></td>
				<td><%=transbean.getChild(i).getProduct().getName()%></td>
				<td><%=transbean.getChild(i).getQuantity()%></td>
				<td><%=transbean.getChild(i).getProduct().getPrice()%></td>
				<td><%=transbean.getChild(i).getBooth().getName()%></td>
				<td><%=formatter.format(transbean.getChild(i).getTransactionTime())%></td>
			</tr>
			<%
				}
			%>
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