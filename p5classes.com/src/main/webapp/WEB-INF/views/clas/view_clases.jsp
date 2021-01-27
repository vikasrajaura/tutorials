<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Classes</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file="../static/header_menu.html"%>
	
			<div style="text-align:center;" class="formHeading"> List Of Classes <p></p></div>
			<table class="w3-table w3-bordered w3-striped w3-border test w3-hoverable" style="width:auto; margin: 0 auto;">
				<thead>
					<tr class="w3-theme-l4">						
						<th><spring:message code="label.clasId" /></th>
						<th><spring:message code="label.clasName" /></th>
						<th><spring:message code="label.clasStage" /></th>
						<th><spring:message code="label.clasDetails" /></th>
						<th colspan=3></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${clases}" var="clas">
						<tr>
							<td>${clas.clasId}</td>
							<td>${clas.clasName}</td>
							<td>${clas.stage}</td>
							<td>${clas.details}</td>
							<td><a href="<c:url value='/clas/viewClas/${clas.clasId}' />">view</a></td>
							<sec:authorize access="hasAuthority('CLASS_EDIT')">
								<td><a href="<c:url value='/clas/editClas/${clas.clasId}' />">edit</a></td>
							</sec:authorize>
							<sec:authorize access="hasAuthority('CLASS_DELETE')">
								<td><a href="<c:url value='/clas/deleteClas/${clas.clasId}' />">delete</a></td>
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