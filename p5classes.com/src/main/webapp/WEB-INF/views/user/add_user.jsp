<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add User</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file="../static/header_menu.html"%>
	
		<c:url var="saveUserUrl" value="/user/saveUser" />
		<form:form method="POST" modelAttribute="user" class="formStyle" action="${saveUserUrl}">
			<form:input type="hidden" path="userId" id="userId" />
			<table style="margin: 0 auto;">
				<tr><td colspan=3 class="formHeading">User Registration Form</td></tr>
				<tr><td colspan=3>${ERROR_MSG} &nbsp;</td></tr>

				<tr>
					<td><spring:message code="label.userName" />:</td>
					<td><form:input path="userName" placeholder="Enter Username" /></td>
					<td><form:errors path="userName" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.password" />:</td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.firstName" />:</td>
					<td><form:input path="firstName" placeholder="First Name" /></td>
					<td><form:errors path="firstName" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.middleName" /></td>
					<td><form:input path="middleName" placeholder="Middle Name" /></td>
					<td><form:errors path="middleName" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.lastName" /></td>
					<td><form:input path="lastName" placeholder="Last Name" /></td>
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
					<td><form:input type="date" path="dob" /></td>
					<td><form:errors path="dob" cssStyle="color: #ff0000;" /></td>
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