<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>${content_view.bTitle}</title>
</head>
<body>
	<div class="container">
		<div class="form-group">
		    <h2><label>No. ${content_view.bId}</label></h2>
		</div>
		<form action="modify.do" method="post">
			<input type="hidden" name="bId" value="${content_view.bId}">
			<div class="form-group">
			    <label for="bName">Name</label>
			    <input type="text" class="form-control" name="bName" value="${content_view.bName}">
 	   	    </div>
 	   	    <div class="form-group">
			    <label for="bTitle">Title</label>
			    <input type="text" class="form-control" name="bTitle" value="${content_view.bTitle}">
 	   	    </div>
 	   	    <div class="form-group">
			    <label for="bContent">Content</label>
			    <textarea class="form-control" rows="5" name="bContent">${content_view.bContent}</textarea>
 	   	    </div>
 	   	    <button type="submit" class="btn btn-primary">Edit</button>
 	   	    <a href="list.do"><button type="button" class="btn btn-default" >List</button></a>
 	   	    <a href="delete.do?bId=${content_view.bId}"><button type="button" class="btn btn-default" >Delete</button></a>
		</form>
	</div>
</body>
</html>