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
		
		<c:if test="${token==null}">
		<c:url var="sendPasswordResetLinkUrl" value="/user/sendPasswordResetLink" />
		<form:form method="POST" class="formStyle" action="${sendPasswordResetLinkUrl}">
			<table style="margin: 0 auto; padding-top:40px;" >
				<tr><td colspan=2 class="formHeading">Enter Username</td></tr>

				<tr><td colspan=3>
				<c:if test="${SUCCESS_MSG != null}">
					<label style="color: #4caf50;">${SUCCESS_MSG}	&nbsp;</label>
				</c:if>
				<c:if test="${ERROR_MSG != null}">
					<label style="color: #ff0000;">${ERROR_MSG} &nbsp;</label>
				</c:if>
				</td></tr>
				
				<tr>
					<td colspan=2><input type="text" id="userName" name="userName" placeholder="User Name" /></td>
				</tr>
				<tr></tr>
				<tr>
					<td colspan=2>
						<input type="submit" name="submit" value="Submit" />
					</td>
				</tr>
			</table>
		</form:form>
		</c:if>
		
		<c:if test="${token!=null}">
		<c:url var="forgetPasswordUrl" value="/user/forgetPassword" />
		<form:form method="POST" class="formStyle" action="${forgetPasswordUrl}">
			<input type="hidden" id="token" name="token" value=${token} />
			<table style="margin: 0 auto; padding-top:40px;" >
				<tr><td colspan=3 class="formHeading">Forget Password Form</td></tr>
				<tr><td colspan=3>
				<c:if test="${SUCCESS_MSG != null}">
					<label style="color: #4caf50;">${SUCCESS_MSG} &nbsp;</label>
				</c:if>
				<c:if test="${ERROR_MSG != null}">
					<label style="color: #ff0000;">${ERROR_MSG} &nbsp;</label>
				</c:if>
				</td></tr>

				<tr>
					<td><spring:message code="label.newPassword" /></td>
					<td><input type="text" id="newPassword" name="newPassword" placeholder="Password" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.confirmPassword" /></td>
					<td><input type="text" id="confirmPassword" name="confirmPassword" placeholder="Password" /></td>
				</tr>
				<tr>
					<td colspan=2>
						<input type="submit" name="submit" value="Submit" />
					</td>
				</tr>
			</table>
		</form:form>
      	</c:if>
		<!-- Footer -->
		<%@include file="/static/footer.html"%>
		<!-- Footer End-->
	</div>
	<!-- Main Content End -->
</body>
</html>