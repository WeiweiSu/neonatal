<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<!-- <link ref="stylesheet" href="/static/bootstrap/css/bootstrap.min.css"> -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="static/css/adminhome.css">

<title>Healthcare Provider Homepage</title>

<script type="text/javascript">
	$(document).ready(function() {
		$('[data-toggle=offcanvas]').click(function() {
			$('.row-offcanvas').toggleClass('active');
		});
	});
</script>


<script>


	function visibleFunction(el, e) {
		document.getElementById("answer").style.visibility="visible";
		el.onclick = null;

		document.getElementById("hiddenfield").value = e.target.id;
		
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
				<a class="navbar-brand" href="#">Healthcare Provider Workspace</a>
			</div>
			<div class="navbar-collapse collapse">
			
			<ul class="nav navbar-nav navbar-right">
        	<sec:authorize access="isAnonymous()">
        		<li><a href='logins'>Login</a></li>
        		<li><a href='register'>Register</a></li>
        	</sec:authorize>
        	
        	<sec:authorize access="isAuthenticated()">
        		<li><a>Welcome, <sec:authentication property="principal.username" /></a></li>
    			<li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
			</sec:authorize>
        	
        </ul>
			
			
			
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Dashboard</a></li>
					<li><a href="#">Settings</a></li>
					<li><a href="profile">Profile</a></li>
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

			<div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar"
				role="navigation">

				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">Overview</a></li>
					<li><a href="unanswered">Unanswered questions</a></li>
					<li><a href="#">post questions</a></li>
				</ul>
			</div>
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
					Healthcare Provider Workspace
					<p class="lead">(overview)</p>
				</h1>

				<a id="getAll">Display Answered Questions</a>


				<div class="col-sm-9 col-md-10 main">

					<div class="panel panel-danger">
						<div class="panel-heading">Answered Question</div>
						<div class="panel-body">

							<h2 class="sub-header">Answered Question Overview</h2>
							<div class="table-responsive">
								<table class="table table-hover">
									<thead>
										<tr>
											<th>#</th>
											<th>Title</th>
											<th>Question</th>
											<th>Answer</th>
											<th>Answered By</th>
										</tr>
									</thead>
									<tbody>






									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>




			</div>
			<!--/row-->
		</div>
	</div>
	<!--/.container-->

	<footer>
		<p class="pull-right">©2014 Company</p>
	</footer>


<script>
$(function(){
	$("#getAll").click(function(){
		$.ajax({
			url:"jsonanswer/all",
			success:function(result){
				$.each(result,function(index,element){
					$('tbody').after('<tr><td>'+element.id+'</td><td>'+element.title+'</td><td>'+element.question+'</td><td>'+element.answer+'</td><td>'+element.answeredbyuser+'</td></tr>')
				});
			}
		});
	});
});
</script>


</body>
</html>