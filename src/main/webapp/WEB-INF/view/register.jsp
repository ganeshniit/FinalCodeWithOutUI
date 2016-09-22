<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body >
${info}
<form:form action ="registerUser" commandName="reg">
UserName:<form:input path="userName"/>
<form:errors path="userName"></form:errors>
Email:<form:input path="email"/>
<form:errors path="email"></form:errors>
Password:<form:password path="password"/>
<form:errors path="password"></form:errors>

<input type="submit" value ="Register"/>
</form:form>

</body>
</html>