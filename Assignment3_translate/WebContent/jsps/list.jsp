<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
table, td, th {
    border: 1px solid #dddddd;
    border-collapse: collapse;
    padding: 10px;
}

img{
	position: absolute;
	top: 50px;
	left: 400px;
}
</style>
<title>Insert title here</title>
</head>
<body style="background-color: #A9A9A9">
<table>
	<c:if test="${param['dictionary'] eq 'french'}">
		<tr>
			<th><b>Index</b></th>
			<th><b>English</b></th>
			<th><b>French</b></th>
			<th><b>Button</b></th>
		</tr>
		<c:forEach var="dic" items="${dics}" varStatus="myIndex">
			<c:choose>
				<c:when test="${myIndex.count%2==1}">
						<tr style="background-color: green">
							<td>${myIndex.count}</td>
							<td>${dic.key}</td>
							<td>${dic.value}</td>
							<td><button onclick="document.getElementById('number').src='pics/${myIndex.count}.jpg'">Image</button></td>
						</tr>
				</c:when>
				<c:otherwise>
						<tr>
							<td>${myIndex.count}</td>
							<td>${dic.key}</td>
							<td>${dic.value}</td>
							<td><button onclick="document.getElementById('number').src='pics/${myIndex.count}.jpg'">Image</button></td>
						</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</c:if>
	<c:if test="${param['dictionary'] eq 'russian'}">
		<tr>
			<th><b>Index</b></th>
			<th><b>English</b></th>
			<th><b>Russian</b></th>
			<th><b>Button</b></th>
		</tr>
		<c:forEach var="dic" items="${dics}" varStatus="myIndex">
			<c:choose>
				<c:when test="${myIndex.count%2==1}">
						<tr style="background-color: red">
							<td>${myIndex.count}</td>
							<td>${dic.key}</td>
							<td>${dic.value}</td>
							<td><button onclick="document.getElementById('number').src='pics/${myIndex.count}.jpg'">Image</button></td>
						</tr>
				</c:when>
				<c:otherwise>
						<tr>
							<td>${myIndex.count}</td>
							<td>${dic.key}</td>
							<td>${dic.value}</td>
							<td><button onclick="document.getElementById('number').src='pics/${myIndex.count}.jpg'">Image</button></td>
						</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</c:if>
</table>
<img id="number" src="pics/question.jpg" style="width:400px">
</body>
</html>