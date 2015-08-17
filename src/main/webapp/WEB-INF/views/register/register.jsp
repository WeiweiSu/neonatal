<%@ page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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

<style>
error {
	color: red;
}
</style>


</head>
<body>
	<div class="container">

		<%-- 
		<c:if test='${not empty param.error}'>
			<font color='red'> Login error. <br /> Reason :
				${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
			</font>
		</c:if>
 --%>

		<!--login modal-->
		<div id="loginModal" class="modal show" tabindex="-1" role="dialog"
			aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h1 class="text-center">Register</h1>
					</div>
					<div class="modal-body">

						<form:form modelAttribute="user" action="register" method="post"
							class="form col-md-12 center-block">
							<div class="form-group">

								<c:if test="${!empty error }">
									<h4 style="color: red">${error}</h4>
								</c:if>

								<form:errors path="username" class="error" />
								<form:label path="username" cssErrorClass="error"
									for="usernameInput">*User Name:</form:label>
								<form:input path="username" class="form-control"
									id="usernameInput" />
							</div>
							<div class="form-group">
								<form:errors path="password" class="error" />
								<form:label path="password" cssErrorClass="error"
									for="passwordInput">*Password:</form:label>
								<form:password path="password" class="form-control"
									id="passwordInput" />
							</div>
							<div class="form-group">
								<form:errors path="aboutme" class="error" />
								<form:label path="aboutme" cssErrorClass="error"
									for="aboutmeInput">Self Description:</form:label>
								<form:input path="aboutme" class="form-control"
									id="aboutmeInput" />
							</div>
							<div class="form-group">
								<form:errors path="country" class="error" />
								<form:label path="country" cssErrorClass="error"
									for="countryInput">Country:</form:label>
								<form:input path="country" class="form-control"
									id="countryInput" />
							</div>
							<div class="form-group">
								<form:errors path="state" class="error" />
								<form:label path="state" cssErrorClass="error" for="stateInput">State:</form:label>
								<form:input path="state" class="form-control" id="stateInput" />
							</div>
							<div class="form-group">
								<form:errors path="city" class="error" />
								<form:label path="city" cssErrorClass="error" for="cityInput">City:</form:label>
								<form:input path="city" class="form-control" id="cityInput" />
							</div>
							<div class="form-group">
								<button class="btn btn-primary btn-lg btn-block">Register</button>
								<span class="pull-right"><a href="logins">Sign in</a></span><span><a
									href="#">Need help?</a></span>
							</div>


						</form:form>


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