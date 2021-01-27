<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Edit Privilege</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
		<%@include file="../static/header_menu.html"%>
		
		<c:url var="updatePrivilegeUrl" value="/privilege/updatePrivilege" />
		<form:form method="POST" modelAttribute="privilege" class="formStyle" action="${updatePrivilegeUrl}">
			<form:input type="hidden" path="privId" id="privId" />
			<table style="margin: 0 auto;">
				<tr><td colspan=3 class="formHeading">Privilege Edit Form</td></tr>
				<tr><td colspan=3>${ERROR_MSG} &nbsp;</td></tr>
				
				<tr>
					<td><spring:message code="label.privilege.privId" />:</td>
					<td>${privilege.privId}</td>
				</tr>

				<tr>
					<td><spring:message code="label.privilege.privName" />:</td>
					<td><form:input path="privName" /></td>
					<td><form:errors path="privName" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.privilege.details" />:</td>
					<td><form:input path="details" /></td>
					<td><form:errors path="details" cssStyle="color: #ff0000;" /></td>
				</tr>				
				
				<tr>
					<td><spring:message code="label.privilege.mappedPath" />:</td>
					<td><form:input path="mappedPath" /></td>
					<td><form:errors path="mappedPath" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.privilege.pageId" />:</td>
					<td><form:input path="pageId" /></td>
					<td><form:errors path="pageId" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td></td>
					<td><button type="submit"><spring:message code="button.label.update" /></button>
						&nbsp;&nbsp;&nbsp;
						<button type="reset"><spring:message code="button.label.reset" /></button></td>
					<td></td>
				</tr>

			</table>
		</form:form>

		<!-- Footer -->
		<%@include file="/static/footer.html"%>
		<!-- Footer End-->
	</div>
	<!-- Main Content End -->
</body>
</html>