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
	<form action="../message/delete" method="post">
	<table>
                <thead>
                <tr>
                    <th>Message ID</th>
                    <th>From User</th>
                    <th>Message</th>
                    <th>Date</th>
                    <th>Reply to User</th>
                    <th>Delete</th>
                </tr>
                </thead>
                
                <tbody>
                <c:forEach items="${messages}" var="message">
                <input type="hidden" name="fromUser" value="${sessionScope.username}"/>
                    <tr>
                        <td>${message.id}</td>
                        <td>${message.fromUser}</td>
                        <td>${message.message}</td>
                        <td>${message.messageDate}</td>
                        <td><a href="../message/replyfrom/${sessionScope.username}/to/${message.fromUser}">Reply</a></td>
                        <td><input type="checkbox" name="delete" value="${message.id}" />Delete</td>
                    </tr>
                </c:forEach>
                <tr>
                	<td colspan="6">You have ${size} messages</td>
                </tr>
                <tr>
                	<td colspan="6"><input type="submit" value="Delete Selected Messages" /></td>
                </tr>
                </tbody>
            </table>
      </form>

</body>
</html>