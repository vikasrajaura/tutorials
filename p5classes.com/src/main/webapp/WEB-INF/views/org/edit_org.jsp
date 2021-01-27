<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Edit Org</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file="../static/header_menu.html"%>
	
		<c:url var="updateOrgUrl" value="/org/updateOrg" />
		<form:form method="POST" modelAttribute="org" class="formStyle" action="${updateOrgUrl}?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
			<form:input type="hidden" path="orgId" id="orgId" />
			<table style="margin: 0 auto;">
				<tr><td colspan=3 class="formHeading">Org Edit Form</td></tr>
				<tr><td colspan=3>${ERROR_MSG} &nbsp;</td></tr>


				<tr>
					<td><spring:message code="label.orgId" />:</td>
					<td><form:input path="orgId" readOnly="readonly"/></td>
					<td><form:errors path="orgId" cssStyle="color: #ff0000;" /></td>
				</tr>
			
				<tr>
					<td><spring:message code="label.orgName" />:</td>
					<td><form:input path="orgName" /></td>
					<td><form:errors path="orgName" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.orgDetails" />:</td>
					<td><form:input path="details" /></td>
					<td><form:errors path="details" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td>Logo Image:</td>
					<td><input type="file" name="file" /></td>
					<td><img ng-src="data:image/jpeg;base64,${org.logoImage}" id="photo-id"/></td>
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