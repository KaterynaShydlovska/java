<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Page</title>
<link rel="stylesheet"  href="/css/style.css">
</head>
<body>

<h1>${category.name}</h1>
	<div class="main">
	<div class="left">
		<h3>Products:</h3>
		<ul>
        <c:forEach items='${ category.products }' var='c'>
            <li>${c.name}</li>
        </c:forEach>

    </ul>
	</div>
	<div class="right">
	 <p>Add Product: </p>
	<form action="/addProductToCategory/${category.id}" method="post">
        <select name="selected_product" id="">
            <c:forEach items='${ nonRelProd }' var='p'>
            	   <option value="${p.id}">${p.name}</option>

            </c:forEach>
        </select>
        <br>
        <input type="submit" value="Submit" class="button">
    </form>
	</div>
	</div>
	

</body>
</html>