<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Section</title>
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
			<Spring: type="hidden" path="sectionId" id="sectionId" />
				<table style="margin: 0 auto;">
				<tr><td colspan=3 class="formHeading">Section Details</td></tr>
				<tr><td colspan=3>${SUCCESS_MSG} &nbsp;</td></tr>
				
				<tr>
					<td><spring:message code="label.sectionId" />:</td>
					<td>${section.sectionId}</td>
				</tr>

				<tr>
					<td><spring:message code="label.sectionName" />:</td>
					<td>${section.sectionName}</td>
				</tr>

				<tr>
					<td><spring:message code="label.sectionType" />:</td>
					<td>${section.type}</td>
				</tr>
				<tr>
					<td><spring:message code="label.sectionDetails" />:</td>
					<td>${section.details}</td>
				</tr>

				<tr>
					<sec:authorize access="hasRole('DBA')">
						<td colspan=2>
							<a href="<c:url value='/section/addSection' />">Add</a>|
							<a href="<c:url value='/section/editSection/${section.sectionId}' />">edit</a>
							<a href="<c:url value='/section/deleteSection/${section.sectionId}' />">delete</a>
						</td>
					</sec:authorize>
				
					<sec:authorize access="hasRole('ADMIN')">
						<td colspan=2>
							<a href="<c:url value='/section/addSection' />">Add</a>|
							<a href="<c:url value='/section/editSection/${section.sectionId}' />">edit</a>
							<a href="<c:url value='/section/deleteSection/${section.sectionId}' />">delete</a>
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