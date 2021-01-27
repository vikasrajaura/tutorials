<%@ include file="../static/common_taglib.html"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Edit Area</title>
<%@ include file="../static/common_style_script.html"%>
</head>
<body>
	<!-- Top Menu, Side Menu -->
	<%@include file="../static/menu.html"%>
	<!-- Top Menu, Side Menu End -->

	<!-- Main Content -->
	<div class="w3-main" id="mainContent">
	<%@include file="../static/header_menu.html"%>
	
		<c:url var="updateAreaUrl" value="/area/updateArea" />
		<form:form method="POST" modelAttribute="area" class="formStyle" action="${updateAreaUrl}">
			<form:input type="hidden" path="areaId" id="areaId" />
			<table style="margin: 0 auto;">
				<tr><td colspan=3 class="formHeading">Area Edit Form</td></tr>
				<tr><td colspan=3>${ERROR_MSG} &nbsp;</td></tr>


				<tr>
					<td><spring:message code="label.areaId" />:</td>
					<td><form:input path="areaId" readOnly="readonly"/></td>
					<td><form:errors path="areaId" cssStyle="color: #ff0000;" /></td>
				</tr>
			
				<tr>
					<td><spring:message code="label.areaName" />:</td>
					<td><form:input path="areaName" /></td>
					<td><form:errors path="areaName" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td><spring:message code="label.areaType" />:</td>
					<td><form:input path="type" /></td>
					<td><form:errors path="type" cssStyle="color: #ff0000;" /></td>
				</tr>				

				<tr>
					<td><spring:message code="label.areaNormalCap" />:</td>
					<td><form:input path="normalCap" /></td>
					<td><form:errors path="normalCap" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td><spring:message code="label.areaMaxCap" />:</td>
					<td><form:input path="maxCap" /></td>
					<td><form:errors path="maxCap" cssStyle="color: #ff0000;" /></td>
				</tr>
				
				<tr>
					<td><spring:message code="label.areaDetails" />:</td>
					<td><form:textarea path="details" rows="3" cols="20"/></td>
					<td><form:errors path="details" cssStyle="color: #ff0000;" /></td>
				</tr>

				<tr>
					<td></td>
					<td><button type="submit"><spring:message code="button.label.update" /></button>
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