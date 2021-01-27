<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Branch</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file="../static/header_menu.html"%>
			
		<c:if test="${successMsg==null}">
		<c:url var="saveBranchUrl" value="/branch/saveBranch" />
		<form:form method="POST" modelAttribute="branch" class="formStyle" action="${saveBranchUrl}">
			<form:input type="hidden" path="branchId" id="branchId" />
			<table style="margin: 0 auto;">
				<tr><td colspan=3 class="formHeading">Branch Registration Form</td></tr>
				<tr><td colspan=3>${ERROR_MSG} &nbsp;</td></tr>

				<tr>
					<td><spring:message code="label.orgName" />:</td>
					<td><form:select path="orgId">
							<form:option value="NONE" label="Select" />
							<form:options items="${orgMap}" />
					</form:select></td>
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
					<td><form:input path="details" /></td>
					<td><form:errors path="details" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.branchAddress" />:</td>
					<td><form:input path="address" /></td>
					<td><form:errors path="address" cssStyle="color: #ff0000;" /></td>
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
		</c:if>
		<c:if test="${successMsg!=null}">
			<table style="margin: 0 auto;">
					<tr><td colspan=3>${successMsg}&nbsp;</td></tr>
			</table>
		</c:if>
		
		
		<!-- Footer -->
		<%@include file="/static/footer.html"%>
		<!-- Footer End-->
	</div>
	<!-- Main Content End -->
</body>
</html>