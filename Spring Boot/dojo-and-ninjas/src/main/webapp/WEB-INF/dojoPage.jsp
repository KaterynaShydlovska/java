<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Page</title>
<link rel="stylesheet"  href="/css/dojoPage.css">
</head>
<body>
<h1>${dojo.name} Location Ninjas</h1>

<table id="main">
   
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
          </tr>
    
        <tbody>
            <c:forEach items='${ dojo.ninjas }' var='ninja'>
                <tr>
                    <td>${ninja.firstName}</td>
                    <td>${ninja.lastName}</td>
                    <td>${ninja.age}</td>
                    
                </tr>
            </c:forEach>
          
        </tbody>
      </table>

</body>
</html>