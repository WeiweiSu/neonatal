<%@ page session="false"%>
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
						<li><a>Welcome, <sec:authentication
									property="principal.username" /></a></li>
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
						<li><a href="search">Search</a></li>
						<li><a href="message">Show Messages</a></li>
						<li><a href="contact">View My Contact</a></li>
						<li><a href="password">Change Password</a></li>
					</ul>
				</div>

			</div>
			<div class="col-md-9">
				<h2 id="sec0" class="text-danger">Getting Pregnant</h2><p class="text-warning">
				If you're wondering how to get pregnant, we'll tell you everything you need to know, 
				from how long it usually takes to the right time to have sex and how to know when you're ovulating. 
				We give you tips for getting pregnant fast and what to avoid when you're trying to conceive, 
				plus things to do before trying. 
				You can also read up on dealing with fertility problems and the early signs of pregnancy. 
				</p>


				<hr class="col-md-12"><p class="text-warning">
				Getting sick during pregnancy can be scary. 
				We'll help you find out everything you need to know about the most common conditions and complications,
				 including possible causes, tests, risk factors, and treatments. 
				 Plus, learn what symptoms should prompt a call to your caregiver, 
				 what the studies say about going on bedrest, and how to tell if you may be having a miscarriage.
				</p>


				<h2 id="sec1" class="text-info">Health Problems in Pregnancy</h2>
				<p>If you're not keeping track of your menstrual cycle or if it varies widely from one month to 
				the next, you may not be sure when to expect your period. But if you start to experience some 
				of the symptoms below - not all women get them all - and you haven't had a period for a while,
				 you may very well be pregnant. Take a home pregnancy test to find out for sure!</p>
				<div class="row">
					<div class="col-md-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="text-danger">Miscarriage</h3>
							</div>
							<div class="panel-body"><p class="text-info">Miscarriage is the loss of a pregnancy in the first 20 weeks. 
							About 10 to 20 percent of known pregnancies end in miscarriage, 
							and more than 80 percent of miscarriages happen before 12 weeks. 
							Most first-trimester miscarriages are believed to be caused by chromosomal abnormalities in the fertilized egg that keep the embryo from developing.
							 Vaginal spotting or bleeding is usually the first sign, so call your healthcare practitioner right away if you notice it (although it's not uncommon to spot or bleed in early pregnancy even if you're not miscarrying).
							  If your practitioner suspects a miscarriage, she'll order an ultrasound to see what's going on in your uterus and possibly do a blood test.</p></div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="text-danger">Premature labor and birth</h3>
							</div>
							<div class="panel-body"><p class="text-info">If you start having regular contractions that cause your cervix to begin to open (dilate) or thin out (efface) before you reach 37 weeks of pregnancy, 
							you're in preterm or premature labor. When a baby is delivered before 37 weeks, 
							it's called a preterm birth and the baby is considered premature. 
							About 12 percent of babies in the United States are born prematurely. 
							Preterm birth can cause health problems or even be fatal for the baby if it happens too early. 
							The more mature a child is at birth, the more likely he is to survive and be healthy.</p></div>
						</div>
					</div>
				</div>

				<hr>

				<h2 id="sec2">Life as a Mom</h2>
				<p>Being a mom is joyful and exciting and satisfying -- and challenging. 
				Get mom-tested techniques for staying sane and organized, 
				from using technology to your advantage to getting out the door quickly 
				(and looking good, of course)! We've got advice for handling mommy guilt, 
				meeting other parents, avoiding arguments with your partner, 
				and making your kid feel special. Don't forget to take care of you, too -- 
				here's ten surprising ways you can be healthier and live longer.</p>
				<div class="row">
					<div class="col-md-4">
						<img src="static/image/mom1.jpg" class="img-responsive">
					</div>
					<div class="col-md-4">
						<img src="static/image/mom2.jpeg" class="img-responsive">
					</div>
					<div class="col-md-4">
						<img src="static/image/mom3.jpg" class="img-responsive">
					</div>
				</div>

				<hr>

				<h2 id="sec3">Toddler</h2>
				Toddlers are tricky -- they've grown enough to have their own ideas and wants, 
				but their bodies and emotions haven't kept pace. 
				To help you navigate the toddler years -- from tantrums to toilet training and that first toddler bed
				 -- we offer lots of great info on toddler behavior, milestones, 
				 activities, nutrition, sleep, and more, from experts and parents alike. 

				<h2 id="sec4">Milestones</h2>
				Find out when to expect the major milestones, 
				like walking, talking, gaining self control, 
				dropping naps, and even writing and drawing. 
				See what to expect in our videos of cruising and walking. 
				Check out photos of adorably triumphant children who have mastered these (and other) big moments, 
				and find out if your toddler's development is on schedule, early, or late.

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
	</script>

</body>
</html>