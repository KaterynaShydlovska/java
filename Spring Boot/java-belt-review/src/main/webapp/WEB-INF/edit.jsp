<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form:form action="/update/${menu.id}/menu" method="post" modelAttribute="menu">
        <p>
            <form:label path="name">Menu Item Name:</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="description">Description</form:label>
            <form:errors path="description"/>
            <form:textarea path="description"/>
        </p>
        
        <input type="submit" value="Update"/>
    </form:form>  
    
    <a href="/delete/${menu.id}/menu">Delete this item</a>  
</body>
</html>
