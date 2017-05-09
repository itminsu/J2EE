<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Board</title>
</head>
<body>
	<div class="container">
  		<h2>Board</h2>          
  		<table class="table table-hover">
    		<thead>
		    	<tr>
		        	<th>No.</th>
					<th>Name</th>
					<th>Title</th>
					<th>Date</th>
					<th>Hit</th>
		    	</tr>
		    </thead>
		    <tbody>
				<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.bId}</td>
					<td>${dto.bName}</td>
					<td><a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
					<td>${dto.bDate}</td>
					<td>${dto.bHit}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="write_view.do"><button type="button" class="btn btn-primary" >Write</button></a>
		<a href="sessionEnd.jsp"><button type="button" class="btn btn-primary" >Log Out</button></a>
	</div>
</body>
</html>