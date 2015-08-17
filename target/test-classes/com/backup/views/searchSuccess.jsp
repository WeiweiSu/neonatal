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
	
	<table>
		<thead>
			<tr>
				<th>User Name</th>
				<th>Gender</th>
				<th>City/State</th>
				<th>Country</th>
				<th>About User</th>
				<th>Add to Contact List</th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.username}</td>
					<td>${user.gender}</td>
					<td>${user.city}/${user.state}</td>
					<td>${user.country}</td>
					<td>${user.aboutme}</td>
					<td><a href="${user.username}">Add to Contact List</a></td>
				</tr>
			
			</c:forEach>
			
			
				
		</thead>
	</table>

<a href="<%=request.getContextPath()%>/main.htm/${sessionScope.username}">Clik here to back to home page</a>
</body>
</html>