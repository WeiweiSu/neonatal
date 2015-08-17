<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<link rel="stylesheet" href="static/css/adminhome.css">

<title>Healthcare Provider Workspace</title>

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
	


			/* function addAnswer(el, e) {

				document.getElementById("answer").style.visibility="visible";
				el.onclick = null;


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
				xmlhttp.open("GET", "answer/" + e.target.id, true);
				xmlhttp.send();
			} */
			
		

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
        		<li><a href='<%=request.getContextPath()%>/logins'>Login</a></li>
        		<li><a href='<%=request.getContextPath()%>/register'>Register</a></li>
        	</sec:authorize>
        	
        	<sec:authorize access="isAuthenticated()">
        		<li><a>Welcome, <sec:authentication property="principal.username" /></a></li>
    			<li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
			</sec:authorize>
        	
        </ul>
			
			
			
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Dashboard</a></li>
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

			<div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar"
				role="navigation">

				<ul class="nav nav-sidebar">
					<li><a href="<%=request.getContextPath()%>/provider">Overview</a></li>
					<li class="active"><a href="#">Unanswered questions</a></li>
					<li><a href="jsonanswer">post questions</a></li>
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
					<p class="lead">(unanswered questions)</p>
				</h1>

				<h2 class="sub-header">Unanswered Question Overview</h2>
				<div class="table-responsive">
				<c:if test="${!empty unanswered }">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>#</th>
								<th>Title</th>
								<th>Question</th>
								<th>Answer</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${unanswered}" var="question">
								<tr>
									<td>${question.id}</td>
									<td>${question.title}</td>
									<td>${question.question}</td>
									<td>${question.answer}</td>

									<c:choose>
										<c:when test="${!empty question.answeredbyuser}">
											<td>${question.answeredbyuser}</td>
										</c:when>
										<c:when test="${empty question.answeredbyuser}">
											<td><a href="#" id="${question.id}" onclick="visibleFunction(this, event)" >Answer This Question</a></td>
										</c:when>
									</c:choose>

								</tr>
							</c:forEach>

						</tbody>
					</table>
					</c:if>
				</div>
				
				
				
				
				

				<div class="col-sm-9 col-md-10 main" id="answer"  style="visibility:hidden;">

					<div class="panel panel-danger">
						<div class="panel-heading">Make Response</div>
						<div class="panel-body">
							<form:form modelAttribute="healthquestionT" action="provider"
								method="post">
								<div class="form-group">
									<form:label path="answer" cssErrorClass="error"
										for="answerInput">Provider Answer</form:label>
									<form:input path="answer" class="form-control"
										id="answerInput" />
									<form:errors path="answer" />
								</div>
								
								<%-- <form:hidden path="id" value="${question.id}" /> --%>
								<input type="hidden" name="id" id="hiddenfield" value="${question.id}" />
								
								<input type="submit" value="Submit Answer"
									class="btn btn-success" />


							</form:form>


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







</body>
</html>