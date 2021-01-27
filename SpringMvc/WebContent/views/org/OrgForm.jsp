<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<link rel="stylesheet" href="<spring:theme code='styleSheet' />"
	type="text/css" />

<link rel="stylesheet" href="/SpringMvc/resources/css/style.css"
	type="text/css" />

<title>Setup New Organization</title>
</head>

<body>
	<%@include file="/views/header.html"%>

	<div class="wrapper formStyle">
		<h3>Setup New Organization</h3>
		<form:form method="POST" modelAttribute="org"
			action="/SpringMvc/org/OrgFormSubmit">
			<table>
				<tr>
					<td><spring:message code="label.org.orgId" /></td>
					<td><form:input path="orgId" /></td>
					<td><form:errors path="orgId" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.org.orgName" /></td>
					<td><form:input path="orgName" /></td>
					<td><form:errors path="orgName" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.org.desc" /></td>
					<td><form:input path="desc" /></td>
					<td><form:errors path="desc" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.org.mobileNumber" /></td>
					<td><form:input path="contact.mobileNumber" /></td>
					<td><form:errors path="contact.mobileNumber"
							cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.org.email" /></td>
					<td><form:input path="contact.email" /></td>
					<td><form:errors path="contact.email"
							cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="Submit"></td>
				</tr>
			</table>
		</form:form>
	</div>
	<%@include file="/views/footer.html"%>
</body>
</html>