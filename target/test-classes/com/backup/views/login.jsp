<%@ page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"> -->
<title>Login Page</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>


</head>
<body>
	<div class="container">
		<%-- <form action="login.htm" method=POST role="form">
		<h2 class="form-signin-heading">Please sign in</h2>
		<p style="color: red">${error}</p><br>
		User Name: <input type="text" name="userName" /><br>
		Password:  <input type="password" name="password" /><br>
		<input type="checkbox" name="remember" value="checked"/> Remember me for 1 week<br>
		<input type="submit" value="Member Login" class="btn btn-lg btn-primary btn-block"/>
	</form> --%>


		<c:if test='${not empty param.error}'>
			<font color='red'> Login error. <br /> Reason :
				${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
			</font>
		</c:if>

		<%-- <form method='POST'
			action='<c:url value='/j_spring_security_check' />'>
			<h2 class="form-signin-heading">Please sign in</h2>
			<table>
				<tr>
					<td align='right'>Username</td>
					<td><input type='text' name='j_username' /></td>
				</tr>
				<tr>
					<td align='right'>Password</td>
					<td><input type='password' name='j_password' /></td>
				</tr>
				<tr>
					<td colspan='2' align='right'><input type="submit"
						value="Member Login" class="btn btn-lg btn-primary btn-block" />
				</tr>
			</table>
		</form> --%>


		<!--login modal-->
		<div id="loginModal" class="modal show" tabindex="-1" role="dialog"
			aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h1 class="text-center">Login</h1>
					</div>
					<div class="modal-body">
						<form class="form col-md-12 center-block" method='POST'
			action='<c:url value='/j_spring_security_check' />'>
							<div class="form-group">
								<input type="text" class="form-control input-lg"
									placeholder="User Name" name='j_username'>
							</div>
							<div class="form-group">
								<input type="password" class="form-control input-lg"
									placeholder="Password"  name='j_password' >
							</div>
							<div class="form-group">
								<button class="btn btn-primary btn-lg btn-block">Sign
									In</button>
								<span class="pull-right"><a href="register">Register</a></span><span><a
									href="#">Need help?</a></span>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<div class="col-md-12">
							<button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
						</div>
					</div>
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




	</div>
</body>
</html>