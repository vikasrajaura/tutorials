<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<title>Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/SpringPro/resources/css/w3.css">

<!-- 
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 -->
<link rel="stylesheet" href="<spring:theme code='styleSheet' />" type="text/css" />
<link rel="shortcut icon" href="/SpringPro/resources/images/icon.ico" type="image/x-icon">
<style>
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif;}
.w3-sidebar {
  z-index: 3;
  width: 250px;
  top: 43px;
  bottom: 0;
  height: inherit;
  display:none;
}

</style>
<script src="/SpringProj/resources/js/menu.js"></script>
<body>

<!-- top menu and side menu -->
<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-left w3-hover-white w3-large w3-theme-l1 w3-hide-large" href="javascript:void(0)" onclick="w3_open('sideMenu', 'sideMenuOverlay')"><i class="fa fa-bars"></i></a>
    <a href="#" class="w3-bar-item w3-button w3-theme-l1">Logo</a>
    <a href="#" class="w3-bar-item w3-button w3-hover-white">About</a>
    <a href="#" class="w3-bar-item w3-button w3-hover-white">Values</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Hide Small1</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Hide Small2</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Hide Medium1</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Hide Medium2</a>
  </div>
</div>



<!-- Sidebar -->
<nav class="w3-sidebar w3-bar-block w3-large w3-theme-l5 w3-animate-left" id="sideMenu">
  <h4 class="w3-bar-item w3-theme-l1 w3-padding-large" style="position: fixed; max-width: fit-content; max-width:250px; margin: 0px;"><b>Side Menu</b>
  <a href="javascript:void(0)" onclick="w3_close('sideMenu', 'sideMenuOverlay')" class="w3-right w3-xlarge /*w3-padding-large*/ w3-hover-black" title="Close Menu">
    <i class="fa fa-remove"></i>
  </a>
  </h4>
  <a class="w3-bar-item w3-button w3-hover-black" style="margin-top:50px;" href="#">Link</a>
  <a class="w3-bar-item w3-button w3-show-small w3-hide-medium w3-hover-black" href="#">Hide Small1</a>
  <a class="w3-bar-item w3-button w3-show-small w3-hide-medium w3-hover-black" href="#">Hide Small2</a>
  <a class="w3-bar-item w3-button w3-show-small w3-show-medium w3-hover-black" href="#">Hide Medium</a>
  <a class="w3-bar-item w3-button w3-show-small w3-show-medium w3-hover-black" href="#">Hide Medium</a>
  
</nav>


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close('sideMenu', 'sideMenuOverlay')" style="cursor:pointer" title="close side menu" id="sideMenuOverlay"></div>


<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
<div class="w3-main w3-theme-l4" id="mainContent" >
      
		<c:url var="loginUrl" value="/login" />
		<form:form method="POST" class="formStyle" action="${loginUrl}" >
			<table style="margin: 0 auto; padding-top:140px;" >
				<tr><td colspan=2 class="formHeading">Login Form</td></tr>
				<tr>
					<td colspan=2>
						<c:if test="${param.error != null}">
							<label style="color: #ff0000;"><spring:message 	code="error.invalid.userName" /></label>
						</c:if> <c:if test="${param.logout != null}">
							<label style="color: #4caf50;"><spring:message	code="label.logout.success" /></label>
						</c:if>&nbsp;
					</td>
				</tr>

				<tr>
					<td><input type="text" id="userName" name="userName" placeholder="Username" /></td>
					<td><form:errors path="userName" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td><input type="password" id="password" name="password" placeholder="Password" /></td>
					<td><form:errors path="password" cssStyle="color: #ff0000;" /></td>
				</tr>
				<tr>
					<td colspan=2><spring:message code="label.rememberMe" />&nbsp; &nbsp; &nbsp;
					    <input type="checkbox" id="rememberme" name="remember-me" />
					</td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="Log in"></td>
				</tr>
			</table>
		</form:form>
      	
      	<br/><br/><br/>
		<!-- Footer -->
		<%@include file="/static/footer.html"%>
		<!-- Footer End-->
	</div>
	<!-- Main Content End -->
</body>
</html>