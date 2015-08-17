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
				<a href="homepage" class="navbar-brand">Home Page</a>
			</div>
			<nav class="collapse navbar-collapse" role="navigation">
				<ul class="nav navbar-nav">
					<li><a href="healthcare">Healthcare Concern</a></li>
					<li><a href="community">Community</a></li>
					<li><a href="profile">Profile</a></li>
					<li class="active"><a href="#">Posts</a></li>
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
						<h3>Popular Posts</h3>
					</div>
					<div class="panel-body">
						<h2 class="sub-header">posts</h2>


						<div class="table-responsive">
						<c:if test="${!empty postList }">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Post title</th>
										<th>Description</th>
										<th>Post Date</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${postList}" var="post">
										<tr>
											<td>${post.title}</td>
											<td>${post.desc}</td>
											<td>${post.postDate}</td>
											<td><a href="comments/${post.id}">See Detail</a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
							</c:if>
						</div>




					</div>
				</div>



				<div class="panel panel-danger">
					<div class="panel-heading">Publish Post</div>
					<div class="panel-body">
						<form:form modelAttribute="post" action="posts" method="post"
							enctype="multipart/form-data">
							<div class="form-group">
								<form:errors path="title" class="error" />
								<form:label path="title" cssErrorClass="error" for="titleInput">Title</form:label>
								<form:input path="title" class="form-control" id="titleInput" />
							</div>


							<div class="form-group">
								<form:errors path="desc" class="error" />
								<form:label path="desc" cssErrorClass="error" for="descInput">Description:</form:label>
								<form:input path="desc" class="form-control" id="descInput" />
							</div>

							<div class="form-group">
								<form:errors path="image" class="error" />
								<form:label path="image" cssErrorClass="error" for="imageInput">Update Image:</form:label>
								<form:input path="image" type="file" class="form-control"
									id="imageInput" />
							</div>



							<input type="submit" value="Submit to post"
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