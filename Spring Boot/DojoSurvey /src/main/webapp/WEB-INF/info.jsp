<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/info.css">
</head>
<body>
<div class="content">
	<div class=main>
		<div class="title">
			<h2>Submited info:</h2>
		</div>
		<div class="info">	
			<p> Name: <span class="name"><c:out value="${name}"/></span></p>
			<p>Dojo Location: <span class="loc"><c:out value="${location}"/></span></p>
			<p>Favorite Language: <span class="lang"><c:out value="${language}"/></span></p>
			<p>Comment: <span class="comment"><c:out value="${comment}"/></span></p>
			
		</div>
	</div>
</div>


</body>
</html>