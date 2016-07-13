<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request"
	class="de.tum.in.dbpra.model.bean.PerformanceListBean"></jsp:useBean>
<%@ page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="css/dbrocks_main.css" />
<title>AllPerformance</title>
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

		<h1>Line-up:</h1>

		<div class="box">
			<%
				SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
			%>


			<table id="primary" >
				<thead>
					<tr>
						<th>Stage</th>
						<th>Performers</th>
						<th>Begin</th>
						<th>End</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Stage</th>
						<th>Performers</th>
						<th>Begin</th>
						<th>End</th>
					</tr>
				</tfoot>
			</table>



			<script>
			$(document).ready(function() {
			    $('#primary').DataTable( {
			        "data": [
						<%String data = ""; //make a string representing all data in format for datatables
							for (int i = 0; i < bean.getList().size(); i++) {
								data += "[\"" + bean.getChild(i).getIsAt().getStageName() + "\",\"" + bean.getChild(i).getAllPerformers()
										+ "\",\"" + formatter.format(bean.getChild(i).getStartTime()) + "\",\""
										+ formatter.format(bean.getChild(i).getEndTime()) + "\"],";
							}
							data = data.substring(0, data.length() - 1);%>
						<%=data%>
				]
			    });
			
			
			    // Setup - add a text input to each footer cell
			    $('#primary tfoot th').each( function () {
			        var title = $(this).text();
			        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
			    } );
			
			    // DataTable
			    var table = $('#primary').DataTable();
			
			    // Apply the search
			    table.columns().every( function () {
			        var that = this;
			
			        $( 'input', this.footer() ).on( 'keyup change', function () {
			            if ( that.search() !== this.value ) {
			                that
			                    .search( this.value )
			                    .draw();
			            }
			        } );
			    } );
			
			} );
			</script>



		</div>
	</div>
	<%
		}
	%>
</body>
</html>