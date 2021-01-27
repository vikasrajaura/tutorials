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

		<c:url var="changePasswordUrl" value="/user/changePassword" />
		<form:form method="POST" class="formStyle" action="${changePasswordUrl}">
			<table style="margin: 0 auto; padding-top:40px;" >
				<tr><td colspan=3 class="formHeading">Change Password Form</td></tr>
				<tr><td colspan=3><label style="color: #ff0000;">${ERROR_MSG} &nbsp;</label></td></tr>
				
				<tr>
					<td><spring:message code="label.password" /></td>
					<td><input type="password" id="oldPassword" name="oldPassword" placeholder="Old Password" /></td>
				</tr>
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
      	
		<!-- Footer -->
		<%@include file="/static/footer.html"%>
		<!-- Footer End-->
	</div>
	<!-- Main Content End -->
</body>
</html>