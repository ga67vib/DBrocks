<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.BandListBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>AllBand</title>
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/dbrocks_main.css" />
<title>Here are all the bands!</title>
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

		<h1>Our cool bands:</h1>

		<%
			for (int i = 0; i < bean.getList().size(); i++) {
		%>
		<div class="row box">
			<div class="col-md-4">
				<img src="media/note<%=i%5%>.png">
			</div>
			<div class="col-md-8">
				<h2><%=bean.getChild(i).getBandName()%></h2>
				<%String songs = bean.getChild(i).getSonglist().toString();
				songs = songs.substring(1,songs.length()-1).replace("|",", ");%>
				<h3>Songs:</h3><%=songs%>
				<h3>Annotations:</h3>
				<p><%=bean.getChild(i).getInstruction()%></p>
			</div>

		</div>
		<%
			}
		%>
		<%
			}
		%>
	</div>




	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>