<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Areas</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
		<%@include file="../static/header_menu.html"%>

			<div style="text-align:center;" class="formHeading"> List Of Areas <p></p></div>
			<table class="w3-table w3-bordered w3-striped w3-border test w3-hoverable" style="width:auto; margin: 0 auto;">
				<thead>
					<tr class="w3-theme-l4">						
						<th><spring:message code="label.areaId" /></th>
						<th><spring:message code="label.areaName" /></th>
						<th><spring:message code="label.areaType" /></th>
						<th><spring:message code="label.areaNormalCap" /></th>
						<th><spring:message code="label.areaMaxCap" /></th>
						<th><spring:message code="label.areaDetails" /></th>
						<th colspan=3></th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${areas}" var="area">
						<tr>
							<td>${area.areaId}</td>
							<td>${area.areaName}</td>
							<td>${area.type}</td>
							<td>${area.normalCap}</td>
							<td>${area.maxCap}</td>
							<td>${area.details}</td>
							<td><a href="<c:url value='/area/viewArea/${area.areaId}' />">view</a></td>
							<sec:authorize access="hasAuthority('ORG_EDIT')">
								<td><a href="<c:url value='/area/editArea/${area.areaId}' />">edit</a></td>
							</sec:authorize>
							<sec:authorize access="hasAuthority('ORG_DELETE')">
								<td><a href="<c:url value='/area/deleteArea/${area.areaId}' />">delete</a></td>
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