<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Admission Form</title>
<body>
<h1>${headerMessage}</h1>
<h3>Student Admission Form..</h3>
	<form action="/SpringMvc/student/StudentFormSubmit" method="post">
	<form:errors path="student.*" />
		<table>
			<tr>
				<td>First Name :</td>
				<td><input type="text"name="firstName" /></td>
			</tr>
			<tr>
				<td>Middle Name :</td>
				<td><input type="text" name="middleName" /></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><input type="text" name="gender" /></td>
			</tr>
			<tr>
				<td>DOB :</td>
				<td><input type="text" name="dob" /></td>
			</tr>
			<tr>
				<td>Age :</td>
				<td><input type="text" name="age" /></td>
			</tr>

			<tr>
				<td>Hobby :</td>
				<td><input type="text" name="hobby" /></td>
			</tr>
			<tr>
				<td>Skills :</td>
				<td><select name="skills" multiple="multiple">
				<option name="Java Core">Java Core</option>
				<option name="Spring Core">Spring Core</option>
				<option name="JMS">JMS</option>
				<option name="EJB">EJB</option>
				</select></td>
			</tr>
			<tr>
				<td>Mobile Number :</td>
				<td><input type="text" name="contact.mobileNumber" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="text" name="contact.email" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" name="Submit Form" /></td>
			</tr>
		</table>
	</form>

</body>
</html>