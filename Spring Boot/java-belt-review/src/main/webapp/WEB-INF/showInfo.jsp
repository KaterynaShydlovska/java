<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<h1>${menu.name}</h1>
<h3>${menu.uploader.userName}</h3>
<p>${menu.description}</p>

<a href="/edit/${menu.id}/menu">Edit</a>

</body>
</html>