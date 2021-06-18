<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/style.css">
</head>
<body>
<div class="main">
<h1>New Dojo</h1>
	    <form:form action="/dojo/create" method="post" modelAttribute="dojo">
            <p>
                <form:label path="name">Name: </form:label>
                <form:input path="name"/>
                <form:errors  path="name"/>
            </p>     
            <input type="submit" value="Submit"/>
    </form:form> 
   </div> 
</body>
</html>