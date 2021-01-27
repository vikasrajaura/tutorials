<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Spring MVC form Validation</title>
</head>
 
<body>
    <h2>Enter below details to login</h2>
 
    <form:form method="POST" modelAttribute="customer" action="doLogin">
        <table>
            
            <tr>
                <td>Enter your E-mail:</td>
                <td><form:input path="emailId" /></td>
                <td><form:errors path="emailId" cssStyle="color: #ff0000;" /></td>
            </tr>
            
            <tr>
                <td>Enter a password:</td>
                <td><form:password path="password"  showPassword="true"/></td>
                <td><form:errors path="password" cssStyle="color: #ff0000;"/></td>
            </tr>
            
            <tr>
                <td><input type="submit" name="submit" value="Register"></td>
            </tr>
        </table>
    </form:form>
 
</body>
</html>