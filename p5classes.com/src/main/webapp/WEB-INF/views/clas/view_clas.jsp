<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Class</title>
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
			<Spring: type="hidden" path="clasId" id="clasId" />
			<table style="margin: 0 auto;">
				<tr><td colspan=2 class="formHeading">View Class</td></tr>
				<tr><td colspan=2>${SUCCESS_MSG} &nbsp;</td></tr>

				<tr>
					<td><spring:message code="label.clasId" />:</td>
					<td>${clas.clasId}</td>
				</tr>

				<tr>
					<td><spring:message code="label.clasName" />:</td>
					<td>${clas.clasName}</td>
				</tr>
				<tr>
					<td><spring:message code="label.clasStage" />:</td>
					<td>${clas.stage}</td>
				</tr>

				<tr>
					<td><spring:message code="label.clasDetails" />:</td>
					<td>${clas.details}</td>
				</tr>

				<tr>
					<sec:authorize access="hasRole('DBA')">
						<td colspan=2>
							<a href="<c:url value='/clas/addClas' />">Add</a>|
							<a href="<c:url value='/clas/editClas/${clas.clasId}' />">edit</a>|
							<a href="<c:url value='/clas/deleteClas/${clas.clasId}' />">delete</a>
						</td>
					</sec:authorize>
				
					<sec:authorize access="hasRole('ADMIN')">
						<td colspan=2>
							<a href="<c:url value='/clas/addClas' />">Add</a>|
							<a href="<c:url value='/clas/editClas/${clas.clasId}' />">edit</a>|
							<a href="<c:url value='/clas/deleteClas/${clas.clasId}' />">delete</a>
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