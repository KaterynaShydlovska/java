<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
<link rel="stylesheet"  href="/css/ninja.css">
</head>
<body>
<div class="main">
<h1>New Ninja</h1>
<form:form action="/ninja/create" method="post" modelAttribute="ninja">
			<p>
                <form:label path="dojo" class="lable">Dojo: </form:label>
                <form:select path="dojo" id="">
                    <c:forEach items='${allDojos}' var='d'>
                        <option value="${d.id}">${d.name}</option>
                    </c:forEach>
                    
                </form:select>
            </p>
            <p>
                <form:label path="firstName">First Name: </form:label>
                <form:input path="firstName"/>
                <form:errors  path="firstName"/>
            </p>
             <p>
                <form:label path="lastName">Last Name: </form:label>
                <form:input path="lastName"/>
                <form:errors  path="lastName"/>
            </p> 
             <p>
                <form:label path="age" class="lable1">Age: </form:label>
                <form:input path="age"/>
                <form:errors  path="age"/>
            </p>    
            <input type="submit" value="Submit" class="button"/>
    </form:form>  
    
   </div>


</body>
</html>