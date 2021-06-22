<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
<link rel="stylesheet"  href="/css/newProduct.css">
</head>
<body>
<div class="main">
<h1>New Product</h1>
<form:form action="/product/create" method="post" modelAttribute="product">
            <p>
                <form:label path="name">Name: </form:label>
                <form:input path="name" class="lable"/>
                <form:errors  path="name"/>
            </p>
             <p>
                <form:label path="description">Description: </form:label>
                <form:input path="description"/>
                <form:errors  path="description"/>
            </p> 
             <p>
                <form:label path="price" >Price: </form:label>
                <form:input path="price" class="lable1"/>
                <form:errors  path="price"/>
            </p>    
            <input type="submit" value="Submit" class="button"/>
    </form:form>  
    
   </div>
</body>
</html>