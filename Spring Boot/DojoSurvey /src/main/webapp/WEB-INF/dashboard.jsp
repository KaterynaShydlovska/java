<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/style.css">
</head>
<body>
<div class="content">
<div class="main">
	<div class="form">
		<form action="/info" method="post">
		        <div class= "form-group">
		            <label for="" class="lable">Your Name:</label>
		            <input class= "form-control" type="text" name="fname" id="" required>
		        </div>
		        <div class= "form-group">
		            <label for="" class="lable1">Dojo Location:</label>
		            <select name="location" id="">
		                <option value="SanJose">San Jose</option>
		                <option value="Seattle">Seattle</option>
		                <option value="Dallas">Dallas</option>
		                <option value="NewYork">New York</option>
		                <option value="Maimi">Maimi</option>
		            </select>
		        </div>
		        <div class= "form-group">
		            <label for="" class="lable2">Favorite Language: </label>
		            <select name="language" id="">
		                <option value="Java">Java</option>
		                <option value="JavaScript">JavaScript</option>
		                <option value="Python">Python</option>
		                <option value="C#">C#</option>
		                <option value="Ruby">Ruby</option>
		            </select>
		        </div>
		        <div class= "form-group">
		            <label for="" class="lable">Comments (optional): </label>
		           <br/>
		            <textarea name="comment" rows="10" cols="30"></textarea>
		        </div>
		        <div class="button">
		        <input type="submit" value="Button" class="submit">
		        </div>
		    </form>
	    </div>
   </div>
  </div>

</body>
</html>