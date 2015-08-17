<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Baby Center Community</title>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">

<!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->



<!-- CSS code from Bootply.com editor -->

<style type="text/css">
header {
	margin-bottom: 30px;
}
</style>
</head>

<!-- HTML code from Bootply.com editor -->

<body>


	<header class="navbar navbar-default navbar-static-top" role="banner">
		<div class="container">
			<div class="navbar-header">
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="<%=request.getContextPath()%>/homepage" class="navbar-brand">Home Page</a>
			</div>
			<nav class="collapse navbar-collapse" role="navigation">
				<ul class="nav navbar-nav">
					<li class="active"><a href="<%=request.getContextPath()%>/healthcare">Healthcare Concern</a></li>
					<li><a href="<%=request.getContextPath()%>/community">Community</a></li>
					<li><a href="<%=request.getContextPath()%>/profile">Profile</a></li>
					<li><a href="<%=request.getContextPath()%>/posts">Posts</a></li>
				</ul>
				
				<ul class="nav navbar-nav navbar-right">
        	<sec:authorize access="isAnonymous()">
        		<li><a href='<%=request.getContextPath()%>/logins'>Login</a></li>
        		<li><a href='<%=request.getContextPath()%>/register'>Register</a></li>
        	</sec:authorize>
        	
        	<sec:authorize access="isAuthenticated()">
        		<li><a>Welcome, <sec:authentication property="principal.username" /></a></li>
    			<li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
			</sec:authorize>
        	
        </ul>
        
        <form class="navbar-form navbar-right"
					action="<%=request.getContextPath()%>/hsearch" method="post">
					<div class="col-sm-7">
						<input class="form-control" placeholder="Search..." type="text"
							name="keyword">
					</div>
					<input type="submit" value="Search" class="btn btn-success" />
				</form>
				
			</nav>
		</div>
	</header>

	<!-- Begin Body -->
	<div class="container">
		<div class="row">
			<div class="col-md-9">
			
			<table>
				<tr>
					<td><h2 class="text-info">Type of question:</h2></td>
					<td><h2 class="text-info">${requestScope.question.title}</h2></td>
				</tr>
				<tr>
					<td><h3 class="text-success">Question:</h3></td>
					<td><h3 class="text-success">${requestScope.question.question}</h3></td>
				</tr>
				<tr>
					<td><h3 class="text-danger">Response By Healthcare Provider:</h3></td>
					<td><h3 class="text-danger">${requestScope.question.answer}</h3></td>
				</tr>
				<c:if test="${!empty question.answeredbyuser}">
				<tr><td colspan="2"><h4>Answered By: ${requestScope.question.answeredbyuser}</h4></td></tr>
				</c:if>
			</table>
			
			<form action="<%=request.getContextPath()%>/report.pdf" method="get">
			<input type="hidden" name="questionID" value="${requestScope.question.id}"/>
			<input type="submit" value="Generate PDF"
									class="btn btn-success" />
			</form>
			
				<%-- <h2 class="text-info">${requestScope.question.title}</h2>
				<h3 class="text-success">${requestScope.question.question}</h3>
				<h3 class="text-danger">${requestScope.question.answer}</h3>
				<br>
				
				<c:if test="${!empty question.answeredbyuser}">
				<h4>Answered By: ${requestScope.question.answeredbyuser}</h4>
				</c:if> --%>
				
			</div>
		</div>
	</div>




	<script type='text/javascript'
		src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>


	<script type='text/javascript'
		src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>






	<!-- JavaScript jQuery code from Bootply.com editor -->

	<script type='text/javascript'>
		$(document).ready(function() {

		});
	</script>

</body>
</html>