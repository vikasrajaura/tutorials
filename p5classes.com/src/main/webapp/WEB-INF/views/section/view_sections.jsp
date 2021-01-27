<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Sections</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file="../static/header_menu.html"%>
	
			<div style="text-align:center;" class="formHeading"> List Of Sections <p></p></div>
			<table class="w3-table w3-bordered w3-striped w3-border test w3-hoverable" style="width:auto; margin: 0 auto;">
				<thead>
					<tr class="w3-theme-l4">						
						<th><spring:message code="label.sectionId" /></th>
						<th><spring:message code="label.sectionName" /></th>
						<th><spring:message code="label.sectionType" /></th>
						<th><spring:message code="label.sectionDetails" /></th>
						<th colspan=3></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${sections}" var="section">
						<tr>
							<td>${section.sectionId}</td>
							<td>${section.sectionName}</td>
							<td>${section.type}</td>
							<td>${section.details}</td>
							<td><a href="<c:url value='/section/viewSection/${section.sectionId}' />">view</a></td>
							<sec:authorize access="hasAuthority('SECTION_EDIT')">
								<td><a href="<c:url value='/section/editSection/${section.sectionId}' />">edit</a></td>
							</sec:authorize>
							<sec:authorize access="hasAuthority('SECTION_DELETE')">
								<td><a href="<c:url value='/section/deleteSection/${section.sectionId}' />">delete</a></td>
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