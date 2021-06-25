<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/dashboard.css">
</head>
<body>
<div class="main">
<div>


<h1>Welcome! ${loggetdUser.userName}</h1>

<h3>All the menu items:</h3>

	<table>
	  <tr>
	    <th>Menu Item</th>
	    <th>Uploaded by</th>
	    <th>Action</th>
	
	  </tr>
	   <c:forEach items='${ allMenuItems }' var='m'>
	  <tr>
	    <td><a href="/menu/${m.id}/info">${m.name}</a></td>
	    <td>${m.uploader.userName}</td>
	    <td><a href="/edit/${m.id}/menu">Edit</a>|| <a href="/delete/${m.id}/menu">Delete</a></td>

	  </tr>
	     </c:forEach>
  </table>
  <a href="/addItem">Add new Menu item</a>
</div>
<div>
<a href="/logout">LogOut</a>
</div>

</div>


</body>
</html>