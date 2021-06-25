<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/idea.css">
</head>
<body>
<div class="main">
	<div>
		<h1>Welcome, ${loggetdUser.name}</h1>
		<h3>Ideas:</h3>
		<table>
		  <tr>
		    <th>Idea</th>
		    <th>Created by: ${loggetdUser.name}</th>
		  </tr>
		   <c:forEach items='${ allIdeas }' var='idea'>
		  <tr>
		    <td><a href="/idea/${idea.id}">${idea.content}</a></td>
		    <td>${idea.creator.name}</td>
		  </tr>
		     </c:forEach>
	  </table>
  <div class="button">
   	<a href="/addNewIdea" class="a" >Create an Idea</a>
  </div>
 
</div>
	<div class="logout">
		<a href="/logout" class="a">LogOut</a>
	</div>

</div>


</body>
</html>