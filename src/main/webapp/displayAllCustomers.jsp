<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<c:forEach items="${ customersList }" var="cust">
		<tr>
			<td>${ cust.name }</td>
			<td>${ cust.email }</td>
			<td>${ cust.dateOfBirth }</td>
		 	<td><img src="profiles/${ cust.profilePicFileName }" width="100" height="100" /></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>