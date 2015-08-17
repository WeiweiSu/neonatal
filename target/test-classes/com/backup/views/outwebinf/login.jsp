<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<h1>Login page out of web-inf</h1>
<c:if test='${not empty param.error}'>
	<font color='red'>
		Login error. <br /> 
		Reason : ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message} 
	</font>
</c:if>

<form method='POST' action='<c:url value='/j_spring_security_check' />'> 
	<table>
		<tr>
			<td align='right'>Username</td>
			<td><input type='text' name='j_username' /></td> 
		</tr>
		<tr>
			<td align='right'>Password</td>
			<td><input type='password' name='j_password' /></td>
		</tr>
		<tr>
			<td colspan='2' align='right'> 
			<input type='submit' value='Login' />
		</tr>
	</table>
</form>

</body>
</html>