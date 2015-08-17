<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>

<h1>All Posts</h1>
    <c:if test="${!empty postList}">
        <table>
        	<tr>
        		<th>Post title</th>
        		<th>Description</th>
        		<th>Post Date</th>
        	</tr>
        		<c:forEach items="${postList}" var="post">
        			<tr>
        				<td>${post.title}</td>
        				<td>${post.desc}</td>
        				<td>${post.postDate}</td>
        				<td><a href="comments/${post.id}" >See Detail</a></td>
        			</tr>
        		</c:forEach>
        </table>
    </c:if>




<h1>Publish Post</h1>
<form:form modelAttribute="post" action="posts" method="post" enctype="multipart/form-data">
			    <table>
				    <tr>
				        <td><form:label path="title" cssErrorClass="error">Title</form:label></td>
				        <td><form:input path="title" /> <form:errors path="title" /></td>
				    </tr>
				    <tr>
				        <td><form:label path="username" cssErrorClass="error">Author:</form:label></td>
				        <td><form:input path="username" value="${sessionScope.username}" readonly="true" /> <form:errors path="username" /></td>
				    </tr>
				    <tr>
				        <td><form:label path="desc" cssErrorClass="error">Description:</form:label></td>
				        <td><form:input path="desc" /> <form:errors path="desc" /></td>
				    </tr>
				    <tr>
				        <td><form:label path="image" cssErrorClass="error">Image:</form:label></td>
				        <td><form:input path="image" type="file" /> <form:errors path="image" /></td>
				    </tr>
				    <tr>
				        <td colspan="2">
				            <input type="submit" value="Submit to post"/>
				        </td>
				    </tr>
				</table>
			</form:form>



</body>
</html>