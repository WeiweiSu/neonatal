<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<h1>Rearch Page</h1>
<form action="search/lookUpByMemberNum" method="post">
<p style="color: red">${error}</p><br>
	<table>
		<tr>
			<td colspan="2"><strong>Look up by Member Number</strong></td>
		</tr>
		<tr>
			<td colspan="2">Please enter the member number of the person you want to look up</td>
		</tr>
		<tr>
			<td><input type="text" name="memberNum" /></td>
			<td><input type="submit" value="See Profile" /></td>
		</tr>
	</table>
</form>

<form action="search/lookUpByUsername" method="post">
<p style="color: red">${error}</p><br>
	<table>
		<tr>
			<td colspan="2"><strong>Look up by Username</strong></td>
		</tr>
		<tr>
			<td colspan="2">Please enter the username of the person you want to look up</td>
		</tr>
		<tr>
			<td><input type="text" name="username" /></td>
			<td><input type="submit" value="See Profile" /></td>
		</tr>
	</table>
</form>






</body>
</html>