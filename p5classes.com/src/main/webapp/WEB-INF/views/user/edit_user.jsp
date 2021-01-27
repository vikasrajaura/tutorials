<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Edit User</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file="../static/header_menu.html"%>
		
		<c:url var="updateUserUrl" value="/user/updateUser" />
		<form:form method="POST" modelAttribute="user" class="formStyle" action="${updateUserUrl}">
			<form:input type="hidden" path="password" id="password" />
			<table style="margin: 0 auto;">
				<tr><td colspan=3 class="formHeading">User Edit Form</td></tr>
				<tr><td colspan=3>${ERROR_MSG} &nbsp;</td></tr>

				<tr>
					<td><spring:message code="label.orgId" />:</td>
					<td>${user.orgId}</td>
					<td></td>
				</tr>
				<tr>
					<td><spring:message code="label.password" />:</td>
					<td>${user.password}</td>
					<td></td>
				</tr>
			
				<tr>
					<td><spring:message code="label.userId" />:</td>
					<td><form:input path="userId" readonly="readonly"/></td>
					<td></td>
				</tr>
							
				<tr>
					<td><spring:message code="label.userName" />:</td>
					<td><form:input path="userName" /></td>
					<td><form:errors path="userName" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.firstName" />:</td>
					<td><form:input path="firstName" /></td>
					<td><form:errors path="firstName" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.middleName" /></td>
					<td><form:input path="middleName" /></td>
					<td><form:errors path="middleName" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.lastName" /></td>
					<td><form:input path="lastName" /></td>
					<td><form:errors path="lastName" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.email" /> :</td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.gender" /> :</td>
					<td><form:input path="gender" /></td>
					<td><form:errors path="gender" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.dob" /> :</td>
					<td><form:input path="dob" /></td>
					<td><form:errors path="dob" cssStyle="color: #ff0000;" /></td>
				</tr>
<%-- 				<tr>
					<td><label class="col-md-3 control-lable" for="roles">Roles</label> :</td>
					<td><form:select path="roles" items="${roles}" multiple="true" itemValue="roleId"
							itemLabel="roleName" /></td>
					<td><form:errors path="roles" /></td>
				</tr>
 --%>
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