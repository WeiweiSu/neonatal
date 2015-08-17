<%@ page session="false"%>
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


<script type="text/javascript">
	$(document).ready(function() {
		$('[data-toggle=offcanvas]').click(function() {
			$('.row-offcanvas').toggleClass('active');
		});
	});
</script>

<script type="text/javascript">
	function deleteMessage(e) {
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
		xmlhttp.open("DELETE", "message/" + e.target.id, true);
		xmlhttp.send();
	}
</script>















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
					<li class="active"><a href="#">Community</a></li>
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
			<div class="col-md-3" id="leftCol">

				<div class="well">
					<ul class="nav nav-stacked" id="sidebar">
						<li><a href="search">Search</a></li>
						<li class="active"><a href="message">Show Messages</a></li>
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
								<h3>View Messages</h3>
							</div>
							<div class="panel-body">

							<c:if test="${!empty messages }">

								<table class="table table-striped">
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
											<input type="hidden" name="fromUser"
												value="${sessionScope.username}" />
											<tr>
												<td>${message.id}</td>
												<td>${message.fromUser}</td>
												<td>${message.message}</td>
												<td>${message.messageDate}</td>
												<td><a
													href="message/replyfrom/<sec:authentication property="principal.username" />/to/${message.fromUser}">Reply</a></td>
												<td><a href="#" id="${message.id}"
												onclick="deleteMessage(event)">Delete</a></td>
											</tr>
										</c:forEach>
										<tr>
											<td colspan="6">You have ${size} messages</td>
										</tr>
									</tbody>
								</table>
								</c:if>



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