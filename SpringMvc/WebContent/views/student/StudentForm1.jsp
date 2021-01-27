<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Spring MVC form Validation</title>
</head>

<body>
<link rel="stylesheet" href="<spring:theme code='styleSheet' />" type="text/css"/>


<h3>Fill the details</h3>

Change Theme
<a href="/SpringMvc/student/StudentForm1?siteTheme=green">Green</a>|
<a href="/SpringMvc/student/StudentForm1?siteTheme=red">Red</a>

Change Language
<a href="/SpringMvc/student/StudentForm1?siteLanguage=en">English</a>|
<a href="/SpringMvc/student/StudentForm1?siteLanguage=fr">French</a>
<div class="wrapper formStyle">
	<form:form method="POST" modelAttribute="student" action="/SpringMvc/student/StudentFormSubmit1">
		<table>
			<tr>
				<td><spring:message code="label.firstName"/>:</td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssStyle="color: #ff0000;" /></td>
			</tr>

			<tr>
				<td><spring:message code="label.middleName"/></td>
				<td><form:input path="middleName" /></td>
				<td><form:errors path="middleName" cssStyle="color: #ff0000;" /></td>

			</tr>
			<tr>
				<td><spring:message code="label.lastName"/></td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssStyle="color: #ff0000;" /></td>

			</tr>
			<tr>
				<td><spring:message code="label.gender"/> :</td>
				<td><form:input path="gender" /></td>
				<td><form:errors path="gender" cssStyle="color: #ff0000;" /></td>

			</tr>
			<tr>
				<td><spring:message code="label.dob"/> :</td>
				<td><form:input path="dob" /></td>
				<td><form:errors path="dob" cssStyle="color: #ff0000;" /></td>

			</tr>
			<tr>
				<td><spring:message code="label.age"/> :</td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age" cssStyle="color: #ff0000;" /></td>

			</tr>

			<tr>
				<td><spring:message code="label.hobby"/> :</td>
				<td><form:input path="hobby" /></td>
				<td><form:errors path="hobby" cssStyle="color: #ff0000;" /></td>

			</tr>
			<tr>
				<td><spring:message code="label.skills"/> :</td>
				<td><select name="skills" multiple="multiple">
						<option name="Java Core">Java Core</option>
						<option name="Spring Core">Spring Core</option>
						<option name="JMS">JMS</option>
						<option name="EJB">EJB</option>
				</select></td>
				<td><form:errors path="skills" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.mobileNumber"/> :</td>
				<td><form:input path="contact.mobileNumber" /></td>
				<td><form:errors path="contact.mobileNumber" cssStyle="color: #ff0000;" /></td>

			</tr>
			<tr>
				<td><spring:message code="label.email"/> :</td>
				<td><form:input path="contact.email" /></td>
				<td><form:errors path="contact.email" cssStyle="color: #ff0000;" /></td>

			</tr>

			<tr>
				<td><input type="submit" name="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>