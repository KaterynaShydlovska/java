<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show</title>
<link rel="stylesheet"  href="/css/show.css">
</head>
<body>
	<div class="dashboard">
		<a href="/languages">Dashboard</a>
	</div>
	<div>
		<p>${language.name}</p>
		<p>${language.creator}</p>
		<p>${language.currentVersion}</p>
	</div>
	<div>
		<a href="/language/${language.id}/edit">Edit</a>
	</div>
	<div>
		<a href="/language/${language.id}/delete">Delete</a>
	</div>


</body>
</html>