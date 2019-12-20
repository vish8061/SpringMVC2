<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addCustomer.lti" method="post" enctype="multipart/form-data">
		Enter name : <input type="text" name="name" /><br />
		Enter email : <input type="text" name="email" /><br /> 
		Enter Password : <input	type="password" name="password" /><br /> 
		Enter date of birth : <input type="date" name="dateOfBirth" /><br>
		Select Profile Pic : <input type="file" name="profilePic" /><br/> 
		<button type="submit">Register</button>
	</form>
</body>
</html>