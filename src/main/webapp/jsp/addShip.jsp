<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add New Ships</title>
		<style type="text/css">
			label{
			    display:inline-block;
			    width:100px;
			    margin-bottom:5px;
			}
		</style>
	</head>
	<body>
		<h1>Add Ship</h1>
		<form:form modelAttribute="ship">
			<label for="name">Ship Name: </label>
			<form:input path="name" name="name"/>
			<form:errors path="name"/><br>
			<label for="passengers">Passengers: </label>
			<form:input path="passengers" name="passengers"/>
			<form:errors path="passengers"/><br>
			<label for="cost">Cost: </label>
			<form:input path="cost" name="cost"/>
			<form:errors path="cost"/><br>
			<label for="metres">Metres: </label>
			<form:input path="metres" name="metres"/>
			<form:errors path="metres"/><br>			
			<input type="submit" value="Add">
		</form:form>
		<a href="/">Home</a>
	</body>
</html>