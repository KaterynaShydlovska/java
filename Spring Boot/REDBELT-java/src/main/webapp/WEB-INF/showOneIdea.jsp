<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Idea Info</title>
<link rel="stylesheet"  href="/css/show.css">
</head>

<body>
<div class="main">
	<h1>${idea.content}</h1>
	<p>Created by:<span class="creator">${idea.creator.name}</span></p>
	<div class="button">
		<a href="/edit/${idea.id}" class="a">Edit</a>
	</div>
	
</div>


</body>
</html>