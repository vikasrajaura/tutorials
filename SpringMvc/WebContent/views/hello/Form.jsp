<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head>Form
</head>
<body>
	<form action="/SpringMvc/RequestParam" method="post">

		<p>
			Name : <input type="text" name="name" />
		</p>
		<p>
			Age : <input type="text" name="age" />
		</p>
		<input type="submit" name="Submit Form" />
	</form>

	<form action="/SpringMvc/RequestParamMap">

		<p>
			Name : <input type="text" name="name" />
		</p>
		<p>
			Age : <input type="text" name="age" />
		</p>
		<input type="submit" name="Submit Form" />
	</form>

</body>
</html>