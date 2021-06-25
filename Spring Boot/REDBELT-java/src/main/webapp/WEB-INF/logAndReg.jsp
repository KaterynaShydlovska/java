<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/style.css">
</head>
<body>
<div class="main">
<div>
    <h1>Registration</h1>
    <form:form action="/register" method="post" modelAttribute="newUser">
        <div class="form-group">
            <label>Name:</label>
            <form:input path="name" class="form-control" />
            <br>
            <form:errors path="name" class="error" />
        </div>
        <div class="form-group">
            <label>Email:</label>
            <form:input path="email" class="form-control1" />
            <br>
            <form:errors path="email" class="terror" />
        </div>
        <div class="form-group">
            <label>Password:</label>
            <form:password path="password" class="form-control2" />
            <br>
            <form:errors path="password" class="error" />
        </div>
        <div class="form-group">
            <label>Confirm Password:</label>
            <form:password path="confirm" class="form-control3" />
            <br>
            <form:errors path="confirm" class="error" />
        </div>
        <input type="submit" value="Register" class="button"/> 
    </form:form>
   </div>
    <div>
     <h1>Login</h1>
    
    <form:form action="/login" method="post" modelAttribute="newLogin">
        <div class="form-group">
            <label>Email:</label>
            <form:input path="email" class="form-controlLog" />
            <br>
            <form:errors path="email" class="error" />
        </div>
        <div class="form-group">
            <label>Password:</label>
            <form:password path="password" class="form-controlLog2" />
            <br>
            <form:errors path="password" class="error" />
        </div>
        <input type="submit" value="Login" class="button" />
    </form:form>
    </div>
    </div>
</body>
</html>