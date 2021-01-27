<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Edit Branch</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
		<%@include file="../static/header_menu.html"%>
		
		<c:url var="updateBranchUrl" value="/branch/updateBranch" />
		<form:form method="POST" modelAttribute="branch" class="formStyle" action="${updateBranchUrl}">
			<form:input type="hidden" path="branchId" id="branchId" />
			<table style="margin: 0 auto;">
				<tr><td colspan=3 class="formHeading">Branch Edit Form</td></tr>
				<tr><td colspan=3>${ERROR_MSG} &nbsp;</td></tr>
				
				<tr>
					<td><spring:message code="label.orgId" />:</td>
					<td>${branch.org.orgId}</td>
				</tr>

				<tr>
					<td><spring:message code="label.branchId" />:</td>
					<td><form:input path="branchId" readOnly="readonly"/></td>
				</tr>
			
				<tr>
					<td><spring:message code="label.branchName" />:</td>
					<td><form:input path="branchName" /></td>
					<td><form:errors path="branchName" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.branchType" />:</td>
					<td><form:input path="type" /></td>
					<td><form:errors path="type" cssStyle="color: #ff0000;" /></td>
				</tr>				
				
				<tr>
					<td><spring:message code="label.branchDetails" />:</td>
					<td><form:textarea path="details" rows="3" cols="20"/></td>
					<td><form:errors path="details" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.branchAddress" />:</td>
					<td><form:textarea path="address" rows="3" cols="20"/></td>
					<td><form:errors path="address" cssStyle="color: #ff0000;" /></td>
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