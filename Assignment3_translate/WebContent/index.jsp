<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "com.minsu.translate.model.Word" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Translator</title>
</head>
<body>
<h1>Welcome to Translator</h1>
<form action="translator" method="GET">
  <select name="dictionary">
    <option value="french">List French Dictionary</option>
    <option value="russian">List Russian Dictionary</option>
  </select>
  <input type="submit" value="go">
</form>

<form action="translator" method="POST">
	<p><input type="radio" name="language" value="french" checked> French
 	   <input type="radio" name="language" value="russian"> Russian</p>
	   <label>Word: </label> <input type="text" name="word">
	   <input type="submit" value="Translate">
</form>
<%
if(session.getAttribute("displayWord") == null)
{
%>
	<p style="color:red">There is not data in dictionary</p>
<%
}
else
{
%>
	<p>Translated to <%=session.getAttribute("displayWord")%></p>
<%
}
%>
</body>
</html>