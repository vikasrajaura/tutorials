<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Branch</title>
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
			<Spring: type="hidden" path="branchId" id="branchId" />
			<table style="margin: 0 auto;">
				<tr><td colspan=3 class="formHeading">Branch Details</td></tr>
				<tr><td colspan=3>${SUCCESS_MSG} &nbsp;</td></tr>

				<tr>
					<td><spring:message code="label.orgId" />:</td>
					<td>${branch.org.orgId}</td>
				</tr>
			
				<tr>
					<td><spring:message code="label.branchId" />:</td>
					<td>${branch.branchId}</td>
				</tr>

				<tr>
					<td><spring:message code="label.branchName" />:</td>
					<td>${branch.branchName}</td>
				</tr>

				<tr>
					<td><spring:message code="label.branchType" />:</td>
					<td>${branch.type}</td>
				</tr>
				<tr>
					<td><spring:message code="label.branchDetails" />:</td>
					<td>${branch.details}</td>
				</tr>
				<tr>
					<td><spring:message code="label.branchAddress" />:</td>
					<td>${branch.address}</td>
				</tr>

				<tr>
					<sec:authorize access="hasRole('DBA')">
						<td colspan=2>
							<a href="<c:url value='/branch/addBranch' />">Add</a>|
							<a href="<c:url value='/branch/editBranch/${branch.branchId}' />">edit</a>
							<a href="<c:url value='/branch/deleteBranch/${branch.branchId}' />">delete</a>
						</td>
					</sec:authorize>
				
					<sec:authorize access="hasRole('ADMIN')">
						<td colspan=2>
							<a href="<c:url value='/branch/addBranch' />">Add</a>|
							<a href="<c:url value='/branch/editBranch/${branch.branchId}' />">edit</a>
							<a href="<c:url value='/branch/deleteBranch/${branch.branchId}' />">delete</a>
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