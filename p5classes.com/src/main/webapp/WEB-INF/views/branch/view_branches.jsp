<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Branches</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file="../static/header_menu.html"%>
	
			<div style="text-align:center;" class="formHeading"> List Of Branches <p></p></div>
			<table class="w3-table w3-bordered w3-striped w3-border test w3-hoverable" style="width:auto; margin: 0 auto;">
				<thead>
					<tr class="w3-theme-l4">						
						<th><spring:message code="label.orgId" /></th>
						<th><spring:message code="label.branchId" /></th>
						<th><spring:message code="label.branchName" /></th>
						<th><spring:message code="label.branchType" /></th>
						<th><spring:message code="label.branchDetails" /></th>
						<th><spring:message code="label.branchAddress" /></th>
						<th colspan=3></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${branches}" var="branch">
						<tr>
							<td>${branch.org.orgId}</td>
							<td>${branch.branchId}</td>
							<td>${branch.branchName}</td>
							<td>${branch.type}</td>
							<td>${branch.details}</td>
							<td>${branch.address}</td>
							<td><a href="<c:url value='/branch/viewBranch/${branch.branchId}' />">view</a></td>
							<sec:authorize access="hasAuthority('BRANCH_EDIT')">
								<td><a href="<c:url value='/branch/editBranch/${branch.branchId}' />">edit</a></td>
							</sec:authorize>
							<sec:authorize access="hasAuthority('BRANCH_DELETE')">
								<td><a href="<c:url value='/branch/deleteBranch/${branch.branchId}' />">delete</a></td>
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