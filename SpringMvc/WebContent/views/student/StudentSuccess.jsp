<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Admission Success</title>
<body>
	<h1>${headerMessage}</h1>
	<h3>Student Admission Success Page</h3>

	<table>
		<tr>
			<td>First Name :</td>
			<td>${student.firstName}</td>
		</tr>
		<tr>
			<td>Middle Name :</td>
			<td>${student.middleName}</td>
		</tr>
		<tr>
			<td>Last Name :</td>
			<td>${student.lastName}</td>
		</tr>
		<tr>
			<td>Gender :</td>
			<td>${student.gender}</td>
		</tr>
		<tr>
			<td>DOB :</td>
			<td>${student.dob}</td>
		</tr>
		<tr>
			<td>Hobby :</td>
			<td>${student.hobby}</td>
		</tr>
		<tr>
			<td>Skills :</td>
			<td>${student.skills}</td>
		</tr>
		<tr>
			<td>Mobile Number :</td>
			<td>${student.contact.mobileNumber}</td>
		</tr>

		<tr>
			<td>Email :</td>
			<td>${student.contact.email}</td>
		</tr>

	</table>

</body>
</html>