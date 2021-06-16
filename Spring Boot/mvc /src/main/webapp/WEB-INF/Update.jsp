<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Language</title>
<link rel="stylesheet"  href="/css/update.css">
</head>
<body>
<div class="header">
	<div>
	<p></p>
	</div>
	<div class="links">
	<div>
		<a href="/language/${language.id}/edit">Edit</a>
	</div>
	<div>
	 	<a href="/language/${language.id}/delete">Delete</a>
	</div>
</div>
</div>
 
 <div class="content">
	<form:form action="/language/${language.id}/update" method="post" modelAttribute="language">
            <p>
                <form:label path="name" class="label">Name</form:label>
                <form:errors path="name"/>
                <form:input path="name" class="name"/>
            </p>
            <p>
                <form:label path="creator" class="label">Creator</form:label>
                <form:errors path="creator"/>
                <form:input path="creator" class="creator"/>
            </p>
            <p>
                <form:label path="currentVersion"  class="label">Version</form:label>
                <form:errors path="currentVersion"/>
                <form:input path="currentVersion" class="version"/>
            </p>  
            <input type="submit" value="Update" class="button"/>
        </form:form>   
</div>
</body>
</html>