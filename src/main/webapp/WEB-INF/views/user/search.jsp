<%@ page session="false"%>
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
				<a href="homepage" class="navbar-brand">Home Page</a>
			</div>
			<nav class="collapse navbar-collapse" role="navigation">
				<ul class="nav navbar-nav">
					<li><a href="healthcare">Healthcare Concern</a></li>
					<li class="active"><a href="community">Community</a></li>
					<li><a href="profile">Profile</a></li>
					<li><a href="posts">Posts</a></li>
				</ul>
				
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
			<div class="col-md-3" id="leftCol">

				<div class="well">
					<ul class="nav nav-stacked" id="sidebar">
						<li class="active"><a href="search">Search</a></li>
						<li><a href="message">Show Messages</a></li>
						<li><a href="contact">View My Contact</a></li>
						<li><a href="password">Change Password</a></li>
					</ul>
				</div>

			</div>
			<div class="col-md-9">

				<div class="row">
					<div class="col-md-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3>Look up by Member Number</h3>
							</div>
							<div class="panel-body">


								<form action="search/lookUpByMemberNum" method="post"
									role="form">
									<p style="color: red">${error}</p>
									<br>

									<div class="form-group">
										<label for="memberNum">Please enter the member number of the
												person you want to look up</label> <input
											type="text" class="form-control" id="memberNum" name="memberNum"
											placeholder="Member Number">
									</div>
									
									<button type="submit" class="btn btn-success">See Profile</button>


								</form>


							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3>Look up by Username</h3>
							</div>
							<div class="panel-body">
							
							<form action="search/lookUpByUsername" method="post"
									role="form">
									<p style="color: red">${error}</p>
									<br>

									<div class="form-group">
										<label for="username">Please enter the username of the person you want to look up</label> 
										<input type="text" class="form-control" id="username" name="username" placeholder="Member User Name">
									</div>
									
									<button type="submit" class="btn btn-success">See Profile</button>


								</form>
							
							
							</div>
						</div>
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