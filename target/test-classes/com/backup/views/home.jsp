<%@ page session="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>




<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome to Baby Community</title>
</head>
<body>

<a href=<c:url value='/j_spring_security_logout'/>>Logout</a><br/>
	<sec:authorize ifAnyGranted='ROLE_ADMIN'> 
    <h1>Only admin can see this</h1><br/> 
    <a href='employees'> Admin Home </a> 
  </sec:authorize> 
  <h1>Welcome <sec:authorize access="isAuthenticated()"><sec:authentication property="principal.username" /></sec:authorize></h1> 


<iframe src="menu.htm" name="menu_page" width="200" height="1000"></iframe>
<iframe src="main.htm/${username}" name="main_page" width="800" height="1000"></iframe>

</body>
</html>