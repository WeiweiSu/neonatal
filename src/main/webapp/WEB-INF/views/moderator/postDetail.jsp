<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<!-- <link ref="stylesheet" href="/static/bootstrap/css/bootstrap.min.css"> -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../../static/css/adminhome.css">

<title>Moderator Homepage</title>

<script type="text/javascript">
	$(document).ready(function() {
		$('[data-toggle=offcanvas]').click(function() {
			$('.row-offcanvas').toggleClass('active');
		});
	});
</script>

<script type="text/javascript">
	function deletePost(e) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				location.reload(true);
			}
		}
		xmlhttp.open("DELETE", "moderator/" + e.target.id, true);
		xmlhttp.send();
	}
</script>


</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Moderator Workspace</a>
			</div>
			<div class="navbar-collapse collapse">
			
			
			<ul class="nav navbar-nav navbar-right">
        	<sec:authorize access="isAnonymous()">
        		<li><a href='<%=request.getContextPath()%>/logins'>Login</a></li>
        		<li><a href='<%=request.getContextPath()%>/register'>Register</a></li>
        	</sec:authorize>
        	
        	<sec:authorize access="isAuthenticated()">
        		<li><a>Welcome, <sec:authentication property="principal.username" /></a></li>
    			<li><a href="<c:url value='/j_spring_security_logout' />">Logout</a></li>
			</sec:authorize>
        	
        </ul>
			
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Settings</a></li>
					<li><a href="<%=request.getContextPath()%>/profile">Profile</a></li>
					<li><a href="#">Help</a></li>
				</ul>
				<form class="navbar-form navbar-right" action="<%=request.getContextPath()%>/hsearch" method="post">
					<input class="form-control" placeholder="Search..." type="text" name="keyword">
					<input type="submit" value="Search" class="btn btn-success" />
				</form>
			</div>
		</div>
	</nav>

	<div class="container-fluid">

		<div class="row row-offcanvas row-offcanvas-left">

			<!-- <div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar"
				role="navigation">

				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">Overview</a></li>
					<li><a href="#">All Posts</a></li>
					<li><a href="#">Some Stuff</a></li>
					<li><a href="#">Export</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">Nav item</a></li>
					<li><a href="">Nav item again</a></li>
					<li><a href="">One more nav</a></li>
					<li><a href="">Another nav item</a></li>
					<li><a href="">More navigation</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">Nav item again</a></li>
					<li><a href="">One more nav</a></li>
					<li><a href="">Another nav item</a></li>
					<li><a href=<c:url value='/j_spring_security_logout'/>><span
							class="label label-danger">Logout</span></a></li>
				</ul>

			</div> -->
			<!--/span-->

			<div class="col-sm-9 col-md-10 main">

				<!--toggle sidebar button-->
				<p class="visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">
						<i class="glyphicon glyphicon-chevron-left"></i>
					</button>
				</p>

				<h1 class="page-header">
					Moderator Workspace
					<p class="lead">(post detail)</p>
				</h1>

				<h2 class="sub-header">Post Detail</h2>
				<div class="panel-body">
						<h2 class="sub-header">post</h2>


						<ul>
							<li><c:if test="${!empty post.url}">
									<img src="${post.url}" />
								</c:if></li>
							<li>${post.title}</li>
							<li>${post.desc}</li>
							<li>${post.postDate}</li>
						</ul>

						<h2>Comments</h2>
						<c:if test="${!empty commentList }">
						<table class="table table-hover">
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
						
						<form action="<%=request.getContextPath()%>/moderator/deletePost/${post.id}" method="get">
						<input type="submit" value="Delete this post"
								class="btn btn-danger" />
						</form>

					</div>
				
			<!--/row-->
		</div>
	</div>
	<!--/.container-->

	<footer>
		<p class="pull-right">�2014 Company</p>
	</footer>


</body>
</html>