<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<link rel="stylesheet" href="<spring:theme code='styleSheet' />"
	type="text/css" />

<link rel="stylesheet" href="/SpringMvc/resources/css/style.css"
	type="text/css" />

<title>Setup New Board</title>
</head>

<body>
	<%@include file="/views/header.html"%>

	<div class="wrapper formStyle">
		<form:form method="POST" modelAttribute="board"
			action="/SpringMvc/board/BoardFormSubmit">

			<h3>Setup New Board</h3>
			<table>
				<tr>
					<td><spring:message code="label.board.boardId" /></td>
					<td><form:input path="boardId" /></td>
					<td><form:errors path="boardId" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.board.boardName" /></td>
					<td><form:input path="boardName" /></td>
					<td><form:errors path="boardName" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.board.desc" /></td>
					<td><form:input path="desc" /></td>
					<td><form:errors path="desc" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.board.mobileNumber" /></td>
					<td><form:input path="contact.mobileNumber" /></td>
					<td><form:errors path="contact.mobileNumber"
							cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.board.email" /></td>
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