<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Org</title>
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
			<Spring: type="hidden" path="orgId" id="orgId" />
			<table style="margin: 0 auto;">
				<tr><td colspan=2 class="formHeading">Org Details</td></tr>
				<tr><td colspan=2>${SUCCESS_MSG} &nbsp;</td></tr>

				<tr>
					<td><spring:message code="label.orgId" />:</td>
					<td>${org.orgId}</td>
				</tr>
				<tr>
					<td><spring:message code="label.orgName" />:</td>
					<td>${org.orgName}</td>
				</tr>
				<tr>
					<td><spring:message code="label.orgDetails" />:</td>
					<td>${org.details}</td>
				</tr>

				<tr>
					<sec:authorize access="hasRole('DBA')">
						<td colspan=2>
							<a href="<c:url value='/org/addOrg' />">Add New Org</a>|
							<a href="<c:url value='/org/editOrg/${org.orgId}' />">edit</a>|
							<a href="<c:url value='/org/deleteOrg/${org.orgId}' />">delete</a>
						</td>
					</sec:authorize>
				
					<sec:authorize access="hasRole('ADMIN')">
						<td colspan=2>
							<a href="<c:url value='/org/addOrg' />">Add New Org</a>|
							<a href="<c:url value='/org/editOrg/${org.orgId}' />">edit</a>|
							<a href="<c:url value='/org/deleteOrg/${org.orgId}' />">delete</a>
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