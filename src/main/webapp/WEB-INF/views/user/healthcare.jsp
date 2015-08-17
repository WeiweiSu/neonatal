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
					<li class="active"><a href="#">Healthcare Concern</a></li>
					<li><a href="community">Community</a></li>
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
					action="<%=request.getContextPath()%>/hsearch" method="post" name="myForm" onsubmit="return validateForm()">
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
				<h2 id="sec0" class="text-danger">Is It Safe?</h2>
				<p class="text-primary">You've probably heard about medications you shouldn't take,
				 foods you should avoid, even chores you should stop doing.
				  Sometimes it's hard to separate fact from fiction.
				   Whether you're wondering about exercise, sex, or sleep, 
				   our experts answer your most pressing questions about what is and isn't safe during pregnancy.</p>



				<hr class="col-md-12">
				<p>Ronald J. Ruggiero
					pharmacy and obstetrics, gynecology, and reproductive science
					In general, we tell pregnant women to avoid all medications in 
					the first trimester as much as possible and use other nondrug remedies 
					if they can. But after that, if you're having allergy symptoms like sneezing 
					or a really runny nose, you can use Actifed, Chlortrimeton, or Benadryl.
					I'm more comfortable with those older medications I've mentioned than the 
					new drugs like Claritin or Allegra. The new ones are probably all right, 
					too, but we don't have enough evidence to show they're really safe. 
					So I'd go with the old standbys.</p>



				<h2 id="sec1" class="text-warning">Is it safe to get a manicure while I'm pregnant?</h2>
				<p>There's little or no evidence that a pregnant woman's 
				exposure to the chemicals involved in a manicure or pedicure 
				is harmful to the fetus. A pedicure in particular can be a 
				wonderful thing in late pregnancy when you're having trouble 
				reaching your toes even to clip your nails.
				Given the heightened sensitivity to smell in pregnancy, 
				the fumes may make some women nauseated, so a well-ventilated location would be helpful.</p>
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-success">
							<div class="panel-heading">
								<h3>Concern or Question</h3>
							</div>
							<div class="panel-body">
								<h2 class="sub-header" class="text-warning">All Posted Healthcare Question</h2>


								<div class="table-responsive">
								<c:if test="${!empty questionList}">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>#</th>
												<th>Title</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${questionList}" var="question">
												<tr>
													<td>${question.id}</td>
													<td>${question.title}</td>
													<td><a href="healthcare/${question.id}" id="${question.id}">See Detail</a></td>
												</tr>
											</c:forEach>

										</tbody>
									</table>
									</c:if>
								</div>




							</div>
						</div>
					</div>
				</div>

				<hr>

				<h2 id="sec2" class="text-warning">Baby Health Guides</h2>
				<p>One of the biggest responsibilities new parents face is 
				managing baby healthcare -- everything from choosing a 
				doctor and scheduling checkups to giving medicine and caring for
				 bumps, bruises, sniffles, and emerging teeth. Our health guides to baby 
				 illnesses and injuries, medicine, and doctor visits will help keep you 
				 prepared for whatever comes up.</p>
				<div class="row">
					<div class="col-md-4">
						<img src="static/image/p1.jpg" class="img-responsive">
					</div>
					<div class="col-md-4">
						<img src="static/image/p2.jpeg" class="img-responsive">
					</div>
					<div class="col-md-4">
						<img src="static/image/p3.jpg" class="img-responsive">
					</div>
				</div>

				<hr>

				<h2 id="sec3" class="text-danger">Any Concern?</h2>



				<div class="panel panel-danger">
					<div class="panel-heading">Ask question</div>
					<div class="panel-body">
						<form:form modelAttribute="healthquestion" action="#"
							method="post">
							<div class="form-group">
								<form:errors path="title" class="error"/>
								<form:label path="title" cssErrorClass="error" for="titleInput">Title</form:label>
								<form:input path="title" class="form-control" id="titleInput" />
								
							</div>

							<div class="form-group">
							
								<form:errors path="question" class="error" />
								<form:label path="question" cssErrorClass="error"
									for="questionInput">Question:</form:label>
								<form:input path="question" class="form-control"
									id="questionInput" />
							</div>
							<input type="submit" value="Submit"
								class="btn btn-success" />
						</form:form>

					</div>
				</div>











				<h2 id="sec4" class="text-success">Big Kid</h2>
				<p>Your big kid will change a lot between the ages of 
				5 to 8. Find out more about the physical, social and emotional, 
				and speech and language developmental milestones to expect from older kids, 
				and get great expert advice on tackling the tough topics, dealing with discipline, 
				ending the bedtime battles, and solving behavior problems like tattling, teasing, and talking back. </p>


				<hr>
				
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

		function validateForm()
		{
		var x=document.forms["myForm"]["keyword"].value;
		if (x==null || x=="")
		  {
		  alert("Searching keyword must be filled out");
		  return false;
		  }
		}
		
	</script>

</body>
</html>