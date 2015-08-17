<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<h2>Send Message Form</h2>
<%-- <form action="../../../../message" method="post">
	<table>
		<tr>
			<td>To:</td>
			<td><input type="text" name="toUser" value="${toUser}" readonly /></td>
		</tr>
		<tr>
			<td>From:</td>
			<td><input type="text" name="fromUser" value="${fromUser}" readonly /></td>
		</tr>
		<tr>
			<td>Message:</td>
			<td><textarea rows="4" cols="" name="message"></textarea><br>
				Enter up to 4000 characters. HTML cannot be displayed.</td>
		</tr>
	</table>
	<input type="submit" value="Send message" />
	<input type="reset" value="Clear form" />
</form> --%>

<form:form modelAttribute="message" action="" method="post">
	<form:input path="message"/><form:errors path="username"></form:errors>
	<input type="submit" />

</form:form>

</body>
</html>