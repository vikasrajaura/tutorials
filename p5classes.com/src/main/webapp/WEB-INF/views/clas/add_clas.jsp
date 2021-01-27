<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Class</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file="../static/header_menu.html"%>
	
		<c:url var="saveClasUrl" value="/clas/saveClas" />
		<form:form method="POST" modelAttribute="clas" class="formStyle" action="${saveClasUrl}">
			<form:input type="hidden" path="clasId" id="clasId" />
			<table style="margin: 0 auto;">
				<tr><td colspan=3 class="formHeading">Add Class Form</td></tr>
				<tr><td colspan=3>${ERROR_MSG} &nbsp;</td></tr>

				<tr>
					<td><spring:message code="label.clasName" />:</td>
					<td><form:input path="clasName" /></td>
					<td><form:errors path="clasName" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.clasStage" />:</td>
					<td><form:input path="stage" /></td>
					<td><form:errors path="stage" cssStyle="color: #ff0000;" /></td>
				</tr>
				
				<tr>
					<td><spring:message code="label.clasDetails" />:</td>
					<td><form:textarea path="details" rows="3" cols="20"/></td>
					<td><form:errors path="details" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td></td>
					<td><button type="submit"><spring:message code="button.label.add" /></button>
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