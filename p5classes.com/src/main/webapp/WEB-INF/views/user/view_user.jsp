<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View User</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file="../static/header_menu.html"%>
	
		<div class="formStyle">
			<Spring: type="hidden" path="userId" id="userId" />
			<table style="margin: 0 auto;">
				<tr><td colspan=2 class="formHeading">User View</td></tr>
				<tr><td colspan=2>${SUCCESS_MSG} &nbsp;</td></tr>
				<tr>
					<td><spring:message code="label.userId" />:</td>
					<td>${user.userId}</td>
				</tr>

				<tr>
					<td><spring:message code="label.userName" />:</td>
					<td>${user.userName}</td>
				</tr>

				<tr>
					<td><spring:message code="label.firstName" />:</td>
					<td>${user.firstName}</td>
				</tr>

				<tr>
					<td><spring:message code="label.middleName" /></td>
					<td>${user.middleName}</td>
				</tr>

				<tr>
					<td><spring:message code="label.lastName" /></td>
					<td>${user.lastName}</td>
				</tr>
				<tr>
					<td><spring:message code="label.email" /> :</td>
					<td>${user.email}</td>
				</tr>

				<tr>
					<td><spring:message code="label.gender" /> :</td>
					<td>${user.gender}</td>
				</tr>

				<tr>
					<td><spring:message code="label.dob" /> :</td>
					<td>${user.dob}</td>
				</tr>
				<tr>
					<td>Last Login :</td>
					<td>${user.lastLogin}</td>
				</tr>

				<tr>
					<sec:authorize access="hasRole('DBA')">
						<td colspan=2>
							<a href="<c:url value='/user/addUser' />">Add</a>|
							<a href="<c:url value='/user/editUser/${user.userId}' />">edit</a>|
							<a href="<c:url value='/user/deleteUser/${user.userId}' />">delete</a>
						</td>
					</sec:authorize>
				
					<sec:authorize access="hasRole('ADMIN')">
						<td colspan=2>
							<a href="<c:url value='/user/addUser' />">Add</a>|
							<a href="<c:url value='/user/editUser/${user.userId}' />">edit</a>|
							<a href="<c:url value='/user/deleteUser/${user.userId}' />">delete</a>
						</td>
					</sec:authorize>
					<sec:authorize access="hasRole('USER')">
						<td colspan=2>

						</td>
					</sec:authorize>
				</tr>
			</table>
		</div>

		<!-- Footer -->
		<%@include file="/static/footer.html"%>
		<!-- Footer End-->
	</div>
	<!-- Main Content End -->
</body>
</html>