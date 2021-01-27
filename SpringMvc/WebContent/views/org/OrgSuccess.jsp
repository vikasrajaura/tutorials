<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<link rel="stylesheet" href="<spring:theme code='styleSheet' />"
	type="text/css" />

<link rel="stylesheet" href="/SpringMvc/resources/css/style.css"
	type="text/css" />

<title>Organization Setup Success</title>
</head>

<body>
	
	<%@include file="/views/header.html"%>
	
	<div class="wrapper formStyle">
		<h3>Organization Setup Success</h3>
		<table>
			<tr>
				<td><spring:message code="label.org.orgId" /></td>
				<td>${org.orgId}</td>
			</tr>
			<tr>
				<td><spring:message code="label.org.orgName" /></td>
				<td>${org.orgName}</td>
			</tr>
			<tr>
				<td><spring:message code="label.org.desc" /></td>
				<td>${org.desc}</td>
			</tr>
			<tr>
				<td><spring:message code="label.org.mobileNumber" /></td>
				<td>${org.contact.mobileNumber}</td>
			</tr>
			<tr>
				<td><spring:message code="label.org.email" /></td>
				<td>${org.contact.email}</td>
			</tr>
		</table>
	</div>

	<%@include file="/views/footer.html"%>
</body>
</html>