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

		<h1>Profile of ${olduser.username}</h1>
			<form:form modelAttribute="user" action="profile" method="post">
			    <table>
				    <tr>
				        <td><form:label path="aboutme" cssErrorClass="error">Self Description:</form:label></td>
				        <td><form:input path="aboutme" /> <form:errors path="aboutme" /></td>
				    </tr>
				    <tr>
				        <td><form:label path="city" cssErrorClass="error">City:</form:label></td>
				        <td><form:input path="city" value="${olduser.city}"/> <form:errors path="city" /></td>
				    </tr>
				    <tr>
				        <td><form:label path="state" cssErrorClass="error">State:</form:label></td>
				        <td><form:input path="state" value="${olduser.state}"/> <form:errors path="state" /></td>
				    </tr>
				    <tr>
				        <td><form:label path="country" cssErrorClass="error">Country:</form:label></td>
				        <td><form:input path="country" value="${olduser.country}"/> <form:errors path="country" /></td>
				    </tr>
				    <tr>
				    	<td>
				    		<form:hidden path="id" value="${olduser.id}" />
				    	</td>
				    </tr>
				    <tr>
				        <td colspan="2">
				            <input type="submit" value="Update"/>
				        </td>
				    </tr>
				</table>
			</form:form>




</body>
</html>