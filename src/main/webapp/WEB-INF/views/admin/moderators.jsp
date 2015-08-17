<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link rel="stylesheet" href="static/css/adminhome.css" >

<title>Admin Homepage</title>

<script type="text/javascript">
$(document).ready(function() {
	  $('[data-toggle=offcanvas]').click(function() {
	    $('.row-offcanvas').toggleClass('active');
	  });
	});
</script>

<script type="text/javascript">
	function deleteUser(e) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
		  	xmlhttp = new XMLHttpRequest();
		}
		else { 
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		    	location.reload(true);
		    }
		}
		xmlhttp.open("DELETE", "users/" + e.target.id, true);
		xmlhttp.send();
	}
</script>


</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Baby Forum Management</a>
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
        
         <div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar" role="navigation">
           
            <ul class="nav nav-sidebar">
              <li><a href="employees">Overview</a></li>
              <li><a href="users">All Users</a></li>
              <li class="active"><a href="#">Moderator Users</a></li>
              <li><a href="employees">Employees</a></li>
					<li><a href="<%=request.getContextPath()%>/providerAccounts">Healthcare Providers</a></li>
            </ul>
        </div><!--/span-->
        
        <div class="col-sm-9 col-md-10 main">
          
          <!--toggle sidebar button-->
          <p class="visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas"><i class="glyphicon glyphicon-chevron-left"></i></button>
          </p>
          
		  <h1 class="page-header">
            Admin Workspace
            <p class="lead">(Moderator management)</p>
          </h1>

          <h2 class="sub-header">Section title</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>User Name</th>
                  <th>Gender</th>
                  <th>City</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${userList}" var="user">
                <tr>
                	<td>${user.id}</td>
                	<td>${user.username}</td>
                	<td>${user.gender}</td>
                	<td>${user.city}</td>
                	<td><a href="#" id="${user.id}" onclick="deleteUser(event)">Delete</a></td>
                </tr>
                </c:forEach>
                
              </tbody>
            </table>
          </div>

      </div><!--/row-->
	</div>
</div><!--/.container-->

<footer>
  <p class="pull-right">©2014 Company</p>
</footer>


</body>
</html>