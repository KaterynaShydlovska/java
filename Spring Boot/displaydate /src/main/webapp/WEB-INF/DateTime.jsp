<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"  href="/css/date.css">
<title>Local Date</title>
</head>
<body onload="dateAlert()">
	<div class="date">
		<h1><c:out value="${date}"/></h1>
	</div>
</body>
<script defer type="text/javascript" src="js/index.js"></script>
</html>