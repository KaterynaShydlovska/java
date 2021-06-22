<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
<link rel="stylesheet"  href="/css/style.css">
</head>
<body>
	<h1>${product.name}</h1>
	<div class="main">
	<div class="left">
		<h3>Categories:</h3>
		<ul>
        <c:forEach items='${ product.categories }' var='p'>
            <li>${p.name}</li>
        </c:forEach>

    </ul>
	</div>
	<div class="right">
	 <p>Add Category: </p>
	<form action="/addCategoryToProduct/${product.id}" method="post">
        <select name="selected_category" id="">
            <c:forEach items='${ nonRelCat }' var='c'>
                <option value="${c.id}">${c.name}</option>
            </c:forEach>
        </select>
        <br>
        <input type="submit" value="Submit" class="button">
    </form>
	</div>
	</div>
	


</body>
</html>