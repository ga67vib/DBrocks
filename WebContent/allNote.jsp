<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.NoteListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/dbrocks_main.css" />
<title>AllNote</title>
</head>

<body>
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

		<%if (request.getAttribute("singleStaff") != null)  { //if we want to display the notes for only a single staff%>
		<h1>The notes which are attached to you: </h1>
		<%}else{%>
		<h1>Our cool notes:</h1>
		<%}%>
		<div class="box">
			<table style="width: 100%">
				<tr>
					<th>NoteID</th>
					<th>Assigned To</th>
					<th>Content</th>
					<th>Creation Time</th>
					<th>Done?</th>
				</tr>
				<%
					for (int i = 0; i < bean.getList().size(); i++) {
						String personsForNotei="";
						for (int j = 0; j<bean.getChild(i).getAttachedto().getList().size(); j++){ //concatenate all names of the persons the note is assigned to
							personsForNotei += bean.getChild(i).getAttachedto().getChild(j).getFirstName() + " " + bean.getChild(i).getAttachedto().getChild(j).getLastName() + "<br>";
						}
				%>
				<tr>
					<td><%=bean.getChild(i).getNoteID()%></td>
					<td><%=personsForNotei%></td>
					<td><%=bean.getChild(i).getContent()%></td>
					<td><%=bean.getChild(i).getCreationTime()%></td>
					<td><%=bean.getChild(i).isDone()%></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>		
		<div class="box">
			<a href="noteCreate">Create a new Note</a>
		</div>
		
	</div>
	<%
		}
	%><script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>