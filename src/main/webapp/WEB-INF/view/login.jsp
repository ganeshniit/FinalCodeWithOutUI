<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>login page</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8"> 

</head>
<body>
<center><div class="container">
		<div class="account_grid">
			   <div class=" login-right">
			  	<h3>REGISTERED CUSTOMERS</h3>
				<p>If you have an account with us, please log in.</p>
				<c:if test="${SPRING_SECURITY_LAST_EXCEPTION !=null}">
<div>
<center>Your login attempt was not successful, try again!!
caused:${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</center>
</div>
</c:if>
				
				<form name="f" action="<c:url value='j_spring_security_check'/>" method='POST'>
				  <div>
					<span>User Name</span>
					<input type="text" name='j_username' placeholder="UserName Required"  required="required"> 
				  </div>
				  <div>
					<span>Password</span>
					<input type="password" name='j_password' placeholder="Password Required"  required="required"> 
				  </div>
				  <input type="submit" value="Login">
			    </form>
			   </div>	</div></div></center>
</body>
