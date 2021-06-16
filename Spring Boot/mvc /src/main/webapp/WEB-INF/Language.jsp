<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
<link rel="stylesheet"  href="/css/style.css">
</head>
<body>
<div class="main">
	<div class="content">

		<div>
	    <table id="table">
        
          <tr>
            <th scope="col">Name</th>
            <th scope="col">Creator</th>
            <th scope="col">Version</th>
            <th scope="col">Actions</th>
          </tr>
        
        <tbody>
        <c:forEach items="${allLanguages}" var="language">
          <tr> 
            <td><a href="/getOne/${language.id}">${language.name}</a></td>
            <td>${language.creator}</td>
            <td>${language.currentVersion}</td>
            <td><a href="/language/${language.id}/edit">Edit</a> || <a href="/language/${language.id}/delete">Delete</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table> 
    </div>
      
       <div>
        <form:form action="/language/create" method="post" modelAttribute="language">
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
                <form:label path="currentVersion" class="label">Version</form:label>
                <form:errors path="currentVersion"/>
                <form:input path="currentVersion" class="version"/>
            </p>  
            <input type="submit" value="Submit" class="button"/>
        </form:form>    
    </div> 
   </div> 
   </div>
    
</body>
</html>