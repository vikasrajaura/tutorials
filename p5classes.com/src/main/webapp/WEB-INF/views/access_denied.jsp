<%@ include file=".../../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Access Denied</title>
<%@ include file=".../../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file=".../../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file=".../../static/header_menu.html"%>
			
			<table style="margin: 0 auto;">
			<sec:authorize access="isAuthenticated()">
				<tr><td colspan=3 class="formHeading">Unauthorized Access</td></tr>
				<tr><td colspan=3>Hi ${varFullName}, you are not authorized to access this page. &nbsp;</td></tr>
				<tr>
					<td colspan=3>Go to <a href="<c:url value="/welcome" />">Home
							Page</a> or <a href="<c:url value="/logout" />">Logout</a> and
						relogin with the appropriate credentials. &nbsp;
					</td>
				</tr>
			</sec:authorize>
			<sec:authorize access="!isAuthenticated()">
			<tr><td colspan=3 >	<a href="<c:url value="/login" />">Login</a> </td>
			</sec:authorize>
			</table>
			

		<!-- Footer -->
		<%@include file="/static/footer.html"%>
		<!-- Footer End-->
	</div>
	<!-- Main Content End -->
</body>
</html>