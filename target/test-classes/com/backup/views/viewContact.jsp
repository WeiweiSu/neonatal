<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome ${sessionScope.username}</h2>
<form action="contact/delete" method="post">
	<table>
		<tr>
			<th>Contact ID</th>
			<th>Contact Name</th>
			<th>Comment</th>
			<th>Date Added</th>
			<th>Delete Contact</th>
		</tr>
		
		<c:forEach items="${contacts}" var="contact">
			<tr>
				<td>${contact.id}</td>
				<td>${contact.contactname}</td>
				<td>${contact.comments}</td>
				<td><input type="checkbox" name="delete" value="${contact.id}" />Delete</td>
			</tr>
		</c:forEach>
		
		<tr><td colspan="4"><input type="submit" value="Delete Selected Contacts" /></td></tr>
	</table>

</form>

</body>
</html>