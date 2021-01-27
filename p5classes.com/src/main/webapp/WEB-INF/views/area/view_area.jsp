<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Area</title>
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
			<Spring: type="hidden" path="areaId" id="areaId" />
			<table style="margin: 0 auto;">
				<tr><td colspan=3 class="formHeading">Area Details</td></tr>
				<tr><td colspan=3>${SUCCESS_MSG} &nbsp;</td></tr>
				
				<tr>
					<td><spring:message code="label.areaId" />:</td>
					<td>${area.areaId}</td>
				</tr>

				<tr>
					<td><spring:message code="label.areaName" />:</td>
					<td>${area.areaName}</td>
				</tr>

				<tr>
					<td><spring:message code="label.areaType" />:</td>
					<td>${area.type}</td>
				</tr>
				<tr>
					<td><spring:message code="label.areaNormalCap" />:</td>
					<td>${area.normalCap}</td>
				</tr>
				<tr>
					<td><spring:message code="label.areaMaxCap" />:</td>
					<td>${area.maxCap}</td>
				</tr>

				<tr>
					<td><spring:message code="label.areaDetails" />:</td>
					<td>${area.details}</td>
				</tr>

				<tr>
					<sec:authorize access="hasRole('DBA')">
						<td colspan=2>
							<a href="<c:url value='/area/addArea' />">Add</a>|
							<a href="<c:url value='/area/editArea/${area.areaId}' />">edit</a>
							<a href="<c:url value='/area/deleteArea/${area.areaId}' />">delete</a>
						</td>
					</sec:authorize>
				
					<sec:authorize access="hasRole('ADMIN')">
						<td colspan=2>
							<a href="<c:url value='/area/addArea' />">Add</a>|
							<a href="<c:url value='/area/editArea/${area.areaId}' />">edit</a>
							<a href="<c:url value='/area/deleteArea/${area.areaId}' />">delete</a>
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