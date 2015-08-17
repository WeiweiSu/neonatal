<%@ page session="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"> 
        <title>Bootply.com - 50/50 Content with Background Image</title>
        <meta name="generator" content="Bootply" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" type="text/css" rel="stylesheet">
        <!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->




        <!-- CSS code from Bootply.com editor -->
        
        <style type="text/css">
            html,
body {
  height: 100%;
}

#wrap {
  min-height: 100%;
  height: 100%;
  /* Negative indent footer by its height */
  margin: 0 auto -82px 0;
  /* Pad bottom by footer height */
  padding: 0 0 80px 0;
}

/* Set the fixed height of the footer here */
#footer {
  height: 80px;
  background-color: #f5f5f5;
}


#wrap > .center-container {
  padding: 50px 0 0 0;
  margin:0;
}

#footer > .container {
  padding-top:5px
  padding-left: 15px;
  padding-right: 15px;
}

.center-container {
  height:100%;
  display: table;
  width:100%;
  margin:0;
}

.center-row {
  height:50%;
  width:100%;
  display: table-row;
}
  
.center-row > div {
  height:100%;
  width:50%;
  display: table-cell;
  border:0 solid #eee;
  color:#fff;
  vertical-align:middle;
}


.bg-one {
	background:#efefef url('static/image/healthcare.jpg');
}
.bg-two {
  background:#efefef url('static/image/community2.jpg');
}
.bg-three {
  background:#efefef url('static/image/profile2.jpg');
}
.bg-four {
  background:#efefef url('static/image/post.jpg');
}
        </style>
    </head>
    
    <!-- HTML code from Bootply.com editor -->
    
    <body  >
        
        <!-- Wrap all page content here -->
<div id="wrap">
  
  <!-- Fixed navbar -->
  <div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Baby Center Community</a>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">Home</a></li>
          <li><a href="#about">About</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Directory <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="healthcare">Healthcare</a></li>
              <li><a href="community">Community</a></li>
              <li><a href="posts">Posts</a></li>
              <li class="divider"></li>
              <li class="dropdown-header">Our sponsors</li>
              <li><a href="http://www.babycenter.com">Baby Center</a></li>
              <li><a href="http://www.diapers.com">Diapers.com</a></li>
              <li><a href="http://www.viacord.com">Viacord</</a></li>

								<sec:authorize ifAnyGranted='ROLE_ADMIN'>
								<li class="divider"></li>
									<li class="dropdown-header">Management Link</li>
									<li><a href='employees'> Admin Home </a></li>
								</sec:authorize>

								<sec:authorize ifAnyGranted='ROLE_MODERATOR'>
								<li class="divider"></li>
									<li class="dropdown-header">Management Link</li>
									<li><a href='moderator'> Moderator Home </a></li>
								</sec:authorize>

								<sec:authorize ifAnyGranted='ROLE_PROVIDER'>
								<li class="divider"></li>
									<li class="dropdown-header">Management Link</li>
									<li><a href='provider'> Provider Home </a></li>
								</sec:authorize>


							</ul>
          </li>
          
          
        </ul>
        
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
      </div><!--/.nav-collapse -->
    </div>
  </div>
  
  <!-- Begin page content -->
  <div class="center-container">
    <div class="center-row">
      <div class="col-xs-6 bg-one text-center"><h2><a href="healthcare">Healthcare Concern</a></h2></div>
      <div class="col-xs-6 bg-two text-center"><h2><a href="community">Community</a></h2></div>
    </div>
    <div class="center-row">
      <div class="col-xs-6 bg-three text-center"><h2><a href="profile">Profile</a></h2></div>
      <div class="col-xs-6 bg-four text-center"><h2><a href="posts">Post</a></h2></div>
    </div>
  </div>
</div>

<div id="footer">
  <div class="container">
    <p>&nbsp;</p>
    <p class="lead">Baby Center Community @<a href="">bcc.com</a></p>
  </div>
</div>

        
        <script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>


        <script type='text/javascript' src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>





        
        <!-- JavaScript jQuery code from Bootply.com editor -->
        
        <script type='text/javascript'>
        
        $(document).ready(function() {
        
            
        
        });
        
        </script>
        
    </body>
</html>