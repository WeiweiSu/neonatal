<%@ page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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

.error {
	color:red;
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
					<li><a href="<%=request.getContextPath()%>/healthcare">Healthcare Concern</a></li>
					<li><a href="<%=request.getContextPath()%>/community">Community</a></li>
					<li><a href="<%=request.getContextPath()%>/profile">Profile</a></li>
					<li class="active"><a href="<%=request.getContextPath()%>/posts">Posts</a></li>
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


				<div class="panel panel-success">
					<div class="panel-heading">
						<h3>Current Post</h3>
					</div>
					<div class="panel-body">
						<h2 class="sub-header">post</h2>


							<c:if test="${!empty post.url}">
									<img src="${post.url}" alt="photo"   width="424" height="362" />
								</c:if>
						<table>
							<tr>
								<td><strong>Title:</strong></td>
								<td>${post.title}</td>
							</tr>
							<tr>
								<td><strong>Description:</strong></td>
								<td>${post.desc}</td>
							</tr>
							<tr>
								<td><strong>Post Date:</strong></td>
								<td>${post.postDate}</td>
							</tr>
						</table>
						

						<h2>Comments</h2>
						<c:if test="${!empty commentList }">
						<table class="table table-striped">
							<thead>
							<tr>
									<th>Comment User</th>
									<th>Comment Content</th>
									<th>Comment Date</th>
							</tr>
							</thead>
						
							<c:forEach items="${commentList }" var="comment">
								
									<tr>
										<td>${comment.username}</td>
										<td>${comment.content}</td>
										<td>${comment.commentDate}</td>
									</tr>
								
							</c:forEach>
						</table>
						</c:if>




					</div>
				</div>



				<div class="panel panel-danger">
					<div class="panel-heading">Make new comment</div>
					<div class="panel-body">
						<form:form modelAttribute="comment" action="" method="post">

							<%-- <div class="form-group">
								<form:errors path="username" class="error" />
								<form:label path="username" cssErrorClass="error"
									for="usernameInput">Author:</form:label>
								<form:input path="username" class="form-control"
									id="usernameInput"
									value='<sec:authentication property="principal.username" />'
									readonly="true" />
							</div> --%>

							<div class="form-group">
								<form:errors path="content" class="error" />
								<form:label path="content" cssErrorClass="error" for="contentInput">Description:</form:label>
								<form:input path="content" class="form-control" id="contentInput" />
							</div>

							<input type="submit" value="Submit to comment"
								class="btn btn-success" />
						</form:form>

					</div>
				</div>












				<hr>


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