<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="addTheProduct" commandName="pro" method="post" enctype="multipart/form-data">>

Name:<form:input path="name"/>
Brand:<form:input path="brand"/>
Price:<form:input path="price"/>
Add product Image: <input type="file" name="file">
<input type="submit" value="submit"/>
</form:form>
</body>
</html>