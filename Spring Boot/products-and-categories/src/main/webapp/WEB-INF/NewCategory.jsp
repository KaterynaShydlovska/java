<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
<link rel="stylesheet"  href="/css/newProduct.css">
</head>


<body>
	<div class="main">
		<h1>New Category</h1>
		<form:form action="/category/create" method="post" modelAttribute="category">
            <p>
                <form:label path="name">Name: </form:label>
                <form:input path="name"/>
                <form:errors  path="name"/>
            </p>
            <input type="submit" value="Submit" class="button"/>
    </form:form>  
    
   </div>

</body>
</html>