<%@ include file="../static/common_taglib.html"%>
<%@ page import="com.p5.ls.web.util.Const" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Section</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file="../static/header_menu.html"%>
	
		<c:url var="saveSectionUrl" value="/section/saveSection" />
		<form:form method="POST" modelAttribute="section" class="formStyle" action="${saveSectionUrl}">
			<form:input type="hidden" path="sectionId" id="sectionId" />
			<table style="margin: 0 auto;">
				<tr><td colspan=3 class="formHeading">Section Registration Form</td></tr>
				<tr><td colspan=3>${ERROR_MSG} &nbsp;</td></tr>

				<tr>
					<td><spring:message code="label.clasName" />:</td>
					<td><form:select path="clas.clasId">
							<form:option value="NONE" label="Select" />
							<form:options items="${clasMap}" />
					</form:select></td>
				</tr>

				<tr>
					<td><spring:message code="label.sectionName" />:</td>
					<td><form:input path="sectionName" /></td>
					<td><form:errors path="sectionName" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.sectionType" />:</td>
					<td><form:input path="type" /></td>
					<td><form:errors path="type" cssStyle="color: #ff0000;" /></td>
				</tr>				

				<tr>
					<td><spring:message code="label.sectionDetails" />:</td>
					<td><form:input path="details" /></td>
					<td><form:errors path="details" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td></td>
					<td><button type="submit"><spring:message code="button.label.add" /></button>
						&nbsp;&nbsp;&nbsp;
						<button type="reset"><spring:message code="button.label.reset" /></button></td>
					<td></td>
				</tr>
			</table>
		</form:form>

		<!-- Footer -->
		<%@include file="/static/footer.html"%>
		<!-- Footer End-->
	</div>
	<!-- Main Content End -->
</body>
</html>