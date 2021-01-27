<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Privilege</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file="../static/header_menu.html"%>
	
			<div style="text-align:center;" class="formHeading"> List Of Privilege <p></p></div>
			<table class="w3-table w3-bordered w3-striped w3-border test w3-hoverable" style="width:auto; margin: 0 auto;">
				<thead>
					<tr class="w3-theme-l4">						
						<th><spring:message code="label.privilege.privId" /></th>
						<th><spring:message code="label.privilege.privName" /></th>
						<th><spring:message code="label.privilege.details" /></th>
						<th><spring:message code="label.privilege.mappedPath" /></th>
						<th><spring:message code="label.privilege.pageId" /></th>
						<th colspan=3></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${privileges}" var="privilege">
						<tr>
							<td>${privilege.privId}</td>
							<td>${privilege.privName}</td>
							<td>${privilege.details}</td>
							<td>${privilege.mappedPath}</td>
							<td>${privilege.pageId}</td>
							<td><a href="<c:url value='/privilege/viewPrivilege/${privilege.privId}' />">view</a></td>
							<sec:authorize access="hasAuthority('PRIVILEGE_EDIT')">
								<td><a href="<c:url value='/privilege/editPrivilege/${privilege.privId}' />">edit</a></td>
							</sec:authorize>
							<sec:authorize access="hasAuthority('PRIVILEGE_DELETE')">
								<td><a href="<c:url value='/privilege/deletePrivilege/${privilege.privId}' />">delete</a></td>
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