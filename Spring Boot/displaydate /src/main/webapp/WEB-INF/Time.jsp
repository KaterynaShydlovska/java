<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Local Time</title>
<link rel="stylesheet"  href="/css/app.css">
</head>
<body onload="timeAlert()">
	<div class="time">
		<h1><c:out value="${time}"/></h1>
	</div>
</body>
<script defer type="text/javascript" src="js/index.js"></script>
</html>