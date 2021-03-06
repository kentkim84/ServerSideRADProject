<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List of Ships</title>
	</head>
	<body>
		<h1>Ships</h1>
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Passengers</th>
				<th>Cost</th>
				<th>Length(Metres)</th>
				<th>Shipping Company</th>
			</tr>
			<c:forEach items="${shipList}" var="ship">
				<tr>
					<td>${ship.name}</td>
					<td>${ship.passengers}</td>
					<td>${ship.cost}</td>
					<td>${ship.metres}</td>
					<td>${ship.shippingCompany.name}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="/">Home</a>
	</body>
</html>