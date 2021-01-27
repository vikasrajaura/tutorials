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
	
			<div style="text-align:center;" class="formHeading"> List Of Users <p></p></div>
			<table class="w3-table w3-bordered w3-striped w3-border test w3-hoverable" style="width:auto; margin: 0 auto;">
				<thead>
					<tr class="w3-theme-l4">
						<th><spring:message code="label.firstName" /></th>
						<th><spring:message code="label.lastName" /></th>
						<th><spring:message code="label.email" /></th>
						<th><spring:message code="label.userName" /></th>
						<th colspan=3></th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td>${user.email}</td>
							<td>${user.userName}</td>
							<td><a href="<c:url value='/user/viewUser/${user.userId}' />">view</a></td>
							<sec:authorize access="hasAuthority('USER_EDIT')">
								<td><a href="<c:url value='/user/editUser/${user.userId}' />">edit</a></td>
							</sec:authorize>
							<sec:authorize access="hasAuthority('USER_DELETE')">
								<td><a href="<c:url value='/user/deleteUser/${user.userId}' />">delete</a></td>
							</sec:authorize>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		<!-- Footer -->
		<%@include file="/static/footer.html"%>
		<!-- Footer End-->
	</div>
	<!-- Main Content End -->
</body>
</html>