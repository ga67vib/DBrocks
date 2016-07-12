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
<title>CreateNote</title>
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

		<h1>Create Note:</h1>

		<div class="box">
			<form method="POST">
			 	Enter all person_ids who shall receive the note.<br>
			 	Separate the ids by a comma.<br>
			 	<% String input_person_ids; //if there are person_ids included in the request, use them and pre-fill the person_ids field
			 	if (request.getAttribute("input_person_ids")!=null){
			 		input_person_ids = request.getAttribute("input_person_ids").toString();
			 	}
			 	else{
			 		input_person_ids = "";
			 	}
			 	%>
			 	
			 	<input type="text" name="person_ids" value=<%= input_person_ids %>><br>
			 	Content:<br>
			 	<input type="text" style="width:500px;" name="content"><br>
			 	<input type="submit" value="Post Note">
			 </form> 
		</div>
	</div>
	<%
		}
	%><script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
>>>>>>> branch 'master' of https://github.com/ga67vib/DBrocks.git
</html>