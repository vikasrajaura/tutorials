<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Orgs</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file="../static/header_menu.html"%>
	
			<div style="text-align:center;" class="formHeading"> List Of Orgs <p></p></div>
			<table class="w3-table w3-bordered w3-striped w3-border test w3-hoverable" style="width:auto; margin: 0 auto;">
				<thead>
					<tr class="w3-theme-l4">
						<th><spring:message code="label.orgId" /></th>
						<th><spring:message code="label.orgName" /></th>
						<th><spring:message code="label.orgDetails" /></th>
						<th colspan=3></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orgs}" var="org">
						<tr>
							<td>${org.orgId}</td>
							<td>${org.orgName}</td>
							<td>${org.details}</td>
							<td><a href="<c:url value='/org/viewOrg/${org.orgId}' />">view</a></td>
							<sec:authorize access="hasAuthority('ORG_EDIT')">
								<td><a href="<c:url value='/org/editOrg/${org.orgId}' />">edit</a></td>
							</sec:authorize>
							<sec:authorize access="hasAuthority('ORG_DELETE')">
								<td><a href="<c:url value='/org/deleteOrg/${org.orgId}' />">delete</a></td>
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