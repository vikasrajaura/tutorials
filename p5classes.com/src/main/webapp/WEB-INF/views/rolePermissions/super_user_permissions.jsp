<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Super User Permissions</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file="../static/header_menu.html"%>
	
			<table style="margin: 0 auto;">
				<tr><td colspan=3 class="formHeading">Super User Permissions</td></tr>
				<tr><td colspan=3>&nbsp;</td></tr>
				<tr><td colspan=3>&nbsp;</td></tr>
			</table>



	<sec:authorize access="isAuthenticated()">

	<!-- SUPER_USER -->
	<sec:authorize access="hasRole('ROLE_SUPER_USER')">
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/org/addOrg' />"> <spring:message code="label.leftMenu.addOrg" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/org/viewOrgs' />"> <spring:message code="label.leftMenu.viewOrgs" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/branch/addBranch' />"><spring:message code="label.leftMenu.addBranch" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/branch/viewBranches' />"><spring:message code="label.leftMenu.viewBranches" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/user/addUser' />"><spring:message code="label.leftMenu.addUser" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/user/viewUsers' />"><spring:message code="label.leftMenu.viewUsers" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/area/addArea' />"><spring:message code="label.leftMenu.addArea" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/area/viewAreas' />"><spring:message code="label.leftMenu.viewAreas" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/clas/addClas' />"><spring:message code="label.leftMenu.addClas" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/clas/viewClases' />"><spring:message code="label.leftMenu.viewClases" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/section/addSection' />"><spring:message code="label.leftMenu.addSection" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/section/viewSections' />"><spring:message code="label.leftMenu.viewSections" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/privilege/addPrivilege' />"><spring:message code="label.leftMenu.addPrivilege" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/privilege/viewPrivileges' />"><spring:message code="label.leftMenu.viewPrivileges" /></a>

	</sec:authorize>
	 	 
	<!-- DBA_USER -->
	<sec:authorize access="hasRole('ROLE_DBA_USER')">
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/org/addOrg' />"> <spring:message code="label.leftMenu.addOrg" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/org/viewOrgs' />"> <spring:message code="label.leftMenu.viewOrgs" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/branch/addBranch' />"><spring:message code="label.leftMenu.addBranch" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/branch/viewBranches' />"><spring:message code="label.leftMenu.viewBranches" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/user/addUser' />"><spring:message code="label.leftMenu.addUser" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/user/viewUsers' />"><spring:message code="label.leftMenu.viewUsers" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/area/addArea' />"><spring:message code="label.leftMenu.addArea" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/area/viewAreas' />"><spring:message code="label.leftMenu.viewAreas" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/clas/addClas' />"><spring:message code="label.leftMenu.addClas" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/clas/viewClases' />"><spring:message code="label.leftMenu.viewClases" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/section/addSection' />"><spring:message code="label.leftMenu.addSection" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/section/viewSections' />"><spring:message code="label.leftMenu.viewSections" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/privilege/addPrivilege' />"><spring:message code="label.leftMenu.addPrivilege" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/privilege/viewPrivileges' />"><spring:message code="label.leftMenu.viewPrivileges" /></a>
	</sec:authorize>
	 	 
	<!-- ORG_USER -->
	<sec:authorize access="hasRole('ROLE_ORG_USER')">
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/branch/viewBranches' />"><spring:message code="label.leftMenu.viewBranches" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/user/viewUsers' />"><spring:message code="label.leftMenu.viewUsers" /></a>
	</sec:authorize>
	 	 
	<!-- BRANCH_USER -->
	<sec:authorize access="hasRole('ROLE_BRANCH_USER')">
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/branch/addBranch' />"><spring:message code="label.leftMenu.addBranch" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/user/addUser' />"><spring:message code="label.leftMenu.addUser" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/user/viewUsers' />"><spring:message code="label.leftMenu.viewUsers" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/area/addArea' />"><spring:message code="label.leftMenu.addArea" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/area/viewAreas' />"><spring:message code="label.leftMenu.viewAreas" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/section/addSection' />"><spring:message code="label.leftMenu.addSection" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/section/viewSections' />"><spring:message code="label.leftMenu.viewSections" /></a>
	</sec:authorize>
	 	 
	<!-- ADMIN_USER -->
	<sec:authorize access="hasRole('ROLE_ADMIN_USER')">
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/user/addUser' />"><spring:message code="label.leftMenu.addUser" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/user/viewUsers' />"><spring:message code="label.leftMenu.viewUsers" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/area/addArea' />"><spring:message code="label.leftMenu.addArea" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/area/viewAreas' />"><spring:message code="label.leftMenu.viewAreas" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/section/addSection' />"><spring:message code="label.leftMenu.addSection" /></a>
		<a class="w3-bar-item w3-margin-left" href="<c:url value='/section/viewSections' />"><spring:message code="label.leftMenu.viewSections" /></a>
	</sec:authorize>
	 	 
	<!-- PRINCIPLE_USER -->
	<sec:authorize access="hasRole('ROLE_PRINCIPLE_USER')">
	</sec:authorize>
	 	 
	<!-- TEACHER_USER -->
	<sec:authorize access="hasRole('ROLE_TEACHER_USER')">
	</sec:authorize>
	 	 
	<!-- PARENT_USER -->
	<sec:authorize access="hasRole('ROLE_PARENT_USER')">
	</sec:authorize>
	 	 
	<!-- STUDENT_USER -->
	<sec:authorize access="hasRole('ROLE_STUDENT_USER')">
	</sec:authorize>
	
	</sec:authorize>


		<!-- Footer -->
		<%@include file="/static/footer.html"%>
		<!-- Footer End-->
	</div>
	<!-- Main Content End -->
</body>
</html>