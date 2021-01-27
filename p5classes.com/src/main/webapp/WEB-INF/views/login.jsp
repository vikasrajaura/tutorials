<%@ include file=".../../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin Page</title>
<%@ include file=".../../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file=".../../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file=".../../static/header_menu.html"%>


		<c:url var="loginUrl" value="/login" />
		<form:form method="POST" class="formStyle" action="${loginUrl}" >
			<table style="margin: 0 auto; padding-top:40px;" >
				<tr>
					<td colspan=3 class="formHeading">Login Form</td>
				</tr>
				<c:if test="${SUCCESS_MSG != null}">
					<tr><td colspan=3><label style="color: #4caf50;">${SUCCESS_MSG}	&nbsp;</label></td></tr>
				</c:if>
				<c:if test="${ERROR_MSG != null}">
					<tr><td colspan=3><label style="color: #ff0000;">${ERROR_MSG} &nbsp;</label></td></tr>
				</c:if>
				<tr>
					<td colspan=3><c:if test="${param.error != null}">
							<label style="color: #ff0000;"><spring:message
									code="error.invalid.userName" /></label>
						</c:if> <c:if test="${param.logout != null}">
							<label style="color: #4caf50;"><spring:message
									code="label.logout.success" /></label>
						</c:if>&nbsp;</td>
				</tr>

				<tr>
					<td><spring:message code="label.userName" /></td>
					<td><input type="text" id="userName" name="userName" placeholder="Username" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.password" /></td>
					<td><input type="password" id="password" name="password" placeholder="Password" /></td>
				</tr>

				<tr>
					<td>Code: </td>
					<td><input type="text" id="code" name="code" /></td>
				</tr>

				<tr>
					<td></td>
					<td><p>Use Google Authenticator app on your phone to obtain the verification Code</p></td>
				</tr>
				
				<tr>
					<td colspan=2>
						<spring:message code="label.rememberMe" />  &nbsp; &nbsp; &nbsp;
						<input type="checkbox" id="rememberme" name="remember-me" /> &emsp; &emsp; &emsp;
						<input type="submit" name="submit" value="Log in" />
					</td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td colspan=2>
						<a href="<c:url value="/user/forgetPassword" />" title="Forgot Password?">Forgot Password?</a>&emsp;
						<a href="">Create an Account</a></td>
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