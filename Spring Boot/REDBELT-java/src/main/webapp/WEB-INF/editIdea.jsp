<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Idea</title>
<link rel="stylesheet"  href="/css/edit.css">
</head>
<body>
<div class="main">
	<h1>Edit ${idea.content}</h1>
	    <form:form action="/update/${idea.id}" method="post" modelAttribute="idea">
	        <p>
	            <form:label path="content">Content:</form:label>
	            <form:input path="content" class="content"/>
	            <br>
	            <form:errors path="content" class="error"/>
	        </p>        
	         <input type="submit" value="Update" class="button"/>
 
	    </form:form>  
	    <div class="button">
	   		 <a href="/delete/${idea.id}">Delete this idea</a>  
	    </div>
 </div>
</body>
</html>