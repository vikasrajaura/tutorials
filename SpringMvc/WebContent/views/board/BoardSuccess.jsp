<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<link rel="stylesheet" href="<spring:theme code='styleSheet' />"
	type="text/css" />

<link rel="stylesheet" href="/SpringMvc/resources/css/style.css"
	type="text/css" />

<title>Board Setup Success</title>
</head>

<body>
	<%@include file="/views/header.html"%>

	<div class="wrapper formStyle">
		<a href="/SpringMvc/board/BoardForm">Create New Board</a>|
		<h3>Board Setup Success</h3>
		<table>
			<tr>
				<td><spring:message code="label.board.boardId" /></td>
				<td>${board.boardId}</td>
			</tr>
			<tr>
				<td><spring:message code="label.board.boardName" /></td>
				<td>${board.boardName}</td>
			</tr>
			<tr>
				<td><spring:message code="label.board.desc" /></td>
				<td>${board.desc}</td>
			</tr>
			<tr>
				<td><spring:message code="label.board.mobileNumber" /></td>
				<td>${board.contact.mobileNumber}</td>
			</tr>
			<tr>
				<td><spring:message code="label.board.email" /></td>
				<td>${board.contact.email}</td>
			</tr>
		</table>
	</div>

	<%@include file="/views/footer.html"%>
</body>
</html>