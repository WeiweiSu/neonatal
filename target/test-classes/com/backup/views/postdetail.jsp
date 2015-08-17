<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>

<div>
	<ul>
		<li>
			<c:if test="${!empty post.url}">
			    <img src="${post.url}" />
			</c:if>
		</li>
		<li>${post.title}</li>
		<li>${post.desc}</li>
		<li>${post.postDate}</li>
	</ul>
</div>

<div>
	<h2>Comments</h2>
	<c:if test="${!empty commentList}" >
		<table>
			<tr>
				<td>${comment.username}</td>
				<td>${comment.content}</td>
				<td>${comment.commentDate}</td>
			</tr>
		</table>
	</c:if>
</div>

<div>
	<h2>Make new comment</h2>
	<form:form modelAttribute="comment" action="${post.id}" method="post">
		 <table>
				    <tr>
				        <td><form:label path="username" cssErrorClass="error">Author:</form:label></td>
				        <td><form:input path="username" value="${sessionScope.username}" readonly="true" /> <form:errors path="username" /></td>
				    </tr>
				    <tr>
				        <td><form:label path="content" cssErrorClass="error">Description:</form:label></td>
				        <td><form:input path="content" /> <form:errors path="content" /></td>
				    </tr>
				    <tr>
				        <td colspan="2">
				            <input type="submit" value="Submit to comment"/>
				        </td>
				    </tr>
				</table>
	</form:form>
</div>


</body>
</html>