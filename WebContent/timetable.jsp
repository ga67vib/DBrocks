<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import='de.tum.in.dbpra.model.bean.BandBean'%>



<jsp:useBean id="bean19" scope="request"
	class="de.tum.in.dbpra.model.bean.PerformanceListBean"></jsp:useBean>
<jsp:useBean id="bean20" scope="request"
	class="de.tum.in.dbpra.model.bean.PerformanceListBean"></jsp:useBean>

<jsp:useBean id="bean19own" scope="request"
	class="de.tum.in.dbpra.model.bean.PerformanceListBean"></jsp:useBean>
<jsp:useBean id="bean20own" scope="request"
	class="de.tum.in.dbpra.model.bean.PerformanceListBean"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/dbrocks_main.css" />
<title>AllPerson</title>
</head>

<body>
	<%@include file="navi.jsp"%>

	<%
		if (request.getAttribute("error") != null) {
	%>
	<h1>An error occured!</h1>
	<%=request.getAttribute("error")%>

	<%
		} else {
	%>
	<div class="content container">

	<%
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");
		if (request.getSession().getAttribute("visitor") != null) { //only display "My Timetable" if user is a visitor
	%>

		<h1>My Timetable:</h1>
		<div class="col-box row">
			<div class="col-md-6">
				<table style="width: 100%">
					<tr>
						<th colspan=4 class="table-head">August 19th</th>
					</tr>
					<tr>
						<th>Stage</th>
						<th>Band(s)</th>
						<th>Begin</th>
						<th>End</th>
					</tr>
					<%
						//System.out.println(bean19own.getList().size());
						for (int i = 0; i < bean19own.getList().size(); i++) {

					%>

					<tr>
						<td><%=bean19own.getChild(i).getIsAt().getStageName()%></td>
						<td><%=bean19own.getChild(i).getAllPerformers()%></td>
						<td><%=formatter.format(bean19own.getChild(i).getStartTime())%></td>
						<td><%=formatter.format(bean19own.getChild(i).getEndTime())%></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
			<div class="col-md-6">
				<table style="width: 100%">
					<tr>
						<th colspan=4 class="table-head">August 20th</th>
					</tr>
					<tr>
						<th>Stage</th>
						<th>Band(s)</th>
						<th>Begin</th>
						<th>End</th>
					</tr>
					<%
						for (int i = 0; i < bean20own.getList().size(); i++) {
					%>
					<tr>
						<td><%=bean20own.getChild(i).getIsAt().getStageName()%></td>
						<td><%=bean20own.getChild(i).getAllPerformers()%></td>
						<td><%=formatter.format(bean20own.getChild(i).getStartTime())%></td>
						<td><%=formatter.format(bean20own.getChild(i).getEndTime())%></td>
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


		<% int colspan; 
		if (request.getSession().getAttribute("visitor") != null) {
			colspan = 5; 
		%>
		<h1>Other Performances:</h1>
		<%} else {
			colspan = 4;
		%>
		<h1>All Performances:</h1>
		<%}%>
		<div class="col-box row">
		<%if (request.getSession().getAttribute("visitor") != null) { //only provide form for visitors%>
		<form method="POST">
		<%}%>
			<div class="col-md-6">
				<table style="width: 100%">
					<tr>
						<th colspan=<%=colspan %> class="table-head">August 19th</th>
					</tr>
					<tr>
						<th>Stage</th>
						<th>Band(s)</th>
						<th>Begin</th>
						<th>End</th>
						<%if (request.getSession().getAttribute("visitor") != null) { //only display Select column for visitors%>
						<th>Select</th>
						<%}%>
					</tr>
					<%
						for (int i = 0; i < bean19.getList().size(); i++) {
					%>

					<tr>
						<td><%=bean19.getChild(i).getIsAt().getStageName()%></td>
						<td><%=bean19.getChild(i).getAllPerformers()%></td>
						<td><%=formatter.format(bean19.getChild(i).getStartTime())%></td>
						<td><%=formatter.format(bean19.getChild(i).getEndTime())%></td>
						<%if (request.getSession().getAttribute("visitor") != null) { //only display Select column for visitors%>
						<td><input type="checkbox" name="selected19<%=i %>" value="<%=bean19.getChild(i).getPerformanceID()%>" /></td>
						<%}%>
					</tr>
					<%
						}
					%>
				</table>
			</div>
			<div class="col-md-6">
				<table style="width: 100%">
					<tr>
						<th colspan=<%=colspan %> class="table-head">August 20th</th>
					</tr>
					<tr>
						<th>Stage</th>
						<th>Band(s)</th>
						<th>Begin</th>
						<th>End</th>
						<%if (request.getSession().getAttribute("visitor") != null) { //only display Select column for visitors%>
						<th>Select</th>
						<%}%>
					</tr>
					<%
						for (int i = 0; i < bean20.getList().size(); i++) {
					%>
					<tr>
						<td><%=bean20.getChild(i).getIsAt().getStageName()%></td>
						<td><%=bean20.getChild(i).getAllPerformers()%></td>
						<td><%=formatter.format(bean20.getChild(i).getStartTime())%></td>
						<td><%=formatter.format(bean20.getChild(i).getEndTime())%></td>
						<%if (request.getSession().getAttribute("visitor") != null) { //only display Select column for visitors%>
						<td><input type="checkbox" name="selected20<%=i %>" value="<%=bean20.getChild(i).getPerformanceID()%>" /></td>
						<%}%>
					</tr>
					<%
						}
					%>
				</table>
			</div>
		<%if (request.getSession().getAttribute("visitor") != null) { //only provide form for visitors%>
		<input type="submit" value="Add selected performances to timetable">
		</form>
		<%}%>
		</div>
	</div>
	<%
		}
	%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>