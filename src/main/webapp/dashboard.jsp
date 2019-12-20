<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b>Welcome back, ${ sessionScope.loggedInCustomer.name }</b>
<a href="addCustomer.jsp">Add New Customer</a>
<a href="fetchAllCustomers.lti">Fetch All Customers</a>
</body>
</html>