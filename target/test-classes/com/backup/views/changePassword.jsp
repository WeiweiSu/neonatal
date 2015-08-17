<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	
	<form action="password" method="post">
	<p style="color: red">${error}</p><br>
		<table>
			<tr>
				<td colspan="2" align="center"><strong>Password Change Form</strong></td>
			</tr>
			<tr>
				<td>Please Enter Your old Password:</td>
				<td><input type="password" name="oldPassword" /></td>
			</tr>
			<tr>
				<td>Enter NEW password:</td>
				<td><input type="password" name="newPassword" /></td>
			</tr>
			<tr>
				<td>Enter New password again:</td>
				<td><input type="password" name="confirmPassword" /></td>
			</tr>
			<tr>
				<td colspan="2"><input  type="submit" value="Change Password" /></td>
			</tr>
		</table>
	</form>
	
	<a>Enter fields to update password.</a>
	
</body>
</html>