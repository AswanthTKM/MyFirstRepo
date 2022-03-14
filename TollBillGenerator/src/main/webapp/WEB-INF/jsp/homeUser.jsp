<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">

<title>Index</title>
</head>
<body style="background-color: #f0f1f2;">

	<!-- Start Navbar  -->

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="#">Toll Bill Generator</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/toHomepageUser">Home <span class="sr-only">(current)</span>
				</a></li>
			</ul>

			<form class="form-inline my-2 my-lg-0">
				<a type="button" href="/editUserProfile" class="btn btn-light my-2 my-sm-0 mr-2">Edit
					Profile</a>
				<a href="/logoutUser" class="btn btn-light my-2 my-sm-0"
					type="submit">Logout</a>
			</form>
		</div>
	</nav>

	<!-- End Navbar  -->

	<!-- Content  -->

	<div class="container p-2">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">


					<div class="card-body">

						<!-- Alert  -->
						<div class="mx-5 mt-3">

							<%-- <h5 style="color: green;" align="center">${regMsg}</h5> --%>

							<c:if test="${not empty logMsg}">
								<div class="alert alert-success text-center" role="alert">
									<strong><c:out value="${logMsg}" /></strong>
								</div>
								<c:set var="logMsg" value="" scope="session" />
							</c:if>
						</div>
						<!-- Alert  -->



						<div class="border border-light pt-1 pb-3 px-5">

							<p class="h3 mb-5 text-center">Welcome , ${eUser.ufullName}</p>

							<div class="text-center">

								<br>

								<!-- Plan journey  -->
								<a type="button" class="btn btn-block btn-primary mb-4"
									href="/TollDetailsUser">Plan A Journey</a>
									
									<!-- View planned journey  -->
								<a type="button" class="btn btn-block btn-primary mb-4"
									href="/viewUserJourneyDetails">View Planned Journey </a>

								<!-- User feedback  -->
								<a type="button" class="btn btn-block btn-primary mb-4"
									href="/addUserFeedback">Feedback</a>

								<!-- Other -->
								<a type="button" class="btn btn-block btn-primary mb-4" href="">Other</a>



							</div>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
	</div>
	</div>
	</div>
	</div>




	<!-- Content  -->























	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
    -->
</body>
</html>