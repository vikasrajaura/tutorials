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
				<tr><td colspan=3 class="formHeading">Exception Page</td></tr>
				<tr><td colspan=3>${exceptionMsg} &nbsp;</td></tr>
				<tr><td colspan=3>Report to admin about this error. As of now go to <a href="<c:url value="/welcome" />">Home Page</a> &nbsp;</td></tr>
				<tr><td colspan=3>${stackTrace} &nbsp;</td></tr>
			</table>

		<!-- Footer -->
		<%@include file="/static/footer.html"%>
		<!-- Footer End-->
	</div>
	<!-- Main Content End -->
</body>
</html>