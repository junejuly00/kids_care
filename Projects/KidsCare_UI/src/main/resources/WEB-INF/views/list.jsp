<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<table>
    <tr>
        <th>userId</th>
        <th>email</th>
        <th>name</th>
        <th>phone</th>
        <th>provider</th>
        <th>role</th>
        <th>Manage</th>
    </tr>
    <c:forEach var="userInfo" items="${list}">
	    <tr>
	        <td>${userInfo.userId}</td>
	        <td>${userInfo.email}</td>
	        <td>${userInfo.name}</td>
	        <td>${userInfo.phone}</td>
	        <td>${userInfo.provider}</td>
	        <td>${userInfo.role}</td>
	        <td></td>
	    </tr>
    </c:forEach>
    <!-- Add more rows as needed -->
</table>
</body>
</html>