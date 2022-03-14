<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<title>Register|Manager</title>
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
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
			</ul>
		</div>
	</nav>

	<!-- End Navbar  -->

	<!-- Login form  -->

	<div class="container p-2">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">


					<!-- card header -->
					<div class="card-header">
						<h4 class="text-primary text-center">Manager Registration</h4>
					</div>



					<!-- card Body  -->
					<div class="card-body">

						<form:form class="border border-light pt-1 pb-3 px-5"
							action="/regManager" modelAttribute="manager" method="post">


							<!-- Full Name -->
							<!-- <input type="text" name="mfullName" class="form-control mb-4"
							placeholder="Full Name" required="required"> -->
							<div class="mb-4">
								<form:input path="mfullName" class="form-control"
									placeholder="Full Name" />
								<form:errors path="mfullName" cssStyle="color: #ff0000;" />
							</div>


							<!-- Age -->
							<!-- <input type="number" name="mage" class="form-control mb-4"
							placeholder="Age" required="required"> -->
							<div class="mb-4">
								<form:input path="mage" class="form-control" placeholder="Age" />
								<form:errors path="mage" cssStyle="color: #ff0000;" />
							</div>

							<!-- Date of birth -->
							<div class="mb-4">
								<form:input path="mDOB" class="form-control"
									placeholder="Date of birth" />
								<form:errors path="mDOB" cssStyle="color: #ff0000;" />

							</div>

							<!-- Gender -->
							<div class="mb-4">

								<form:radiobutton path="mgender" value="Male" />
								Male
								<form:radiobutton path="mgender" value="Female" />
								Female
								<form:radiobutton path="mgender" value="Transgender" />
								Transgender
								<form:errors path="mgender" cssStyle="color: #ff0000;" />
							</div>

							<!-- Contact NUmber -->
							<div class="mb-4">
								<form:input path="mcontactnum" class="form-control"
									placeholder="Contact Number" />
								<form:errors path="mcontactnum" cssStyle="color: #ff0000;" />
							</div>


							<!-- Approval  -->
							<!-- <input type="hidden" name="mapproval" value="NOT APPROVED"> -->
							<form:hidden path="mapproval" value="NOT APPROVED" />


							<!-- Email -->
							<!-- <input type="email" name="memail" class="form-control mb-4"
							placeholder="E-mail" required="required"> -->
							<div class="mb-4">
								<form:input path="memail" class="form-control"
									placeholder="Email" />
								<form:errors path="memail" cssStyle="color: #ff0000;" />
								<span style="color: red">${errMsg}</span>
							</div>


							<!-- Username -->
							<!-- <input type="text" name="muserName" class="form-control mb-4"
							placeholder="Username" required="required"> -->
							<div class="mb-4">
								<form:input path="muserName" class="form-control"
									placeholder="Username" />
								<form:errors path="muserName" cssStyle="color: #ff0000;" />
							</div>


							<!-- password -->
							<!-- <input type="password" name="mpassword" class="form-control mb-4"
							placeholder="Password" required="required"> -->
							<div class="mb-4">
								<form:password path="mpassword" class="form-control"
									placeholder="Password" />
								<form:errors path="mpassword" cssStyle="color: #ff0000;" />
							</div>


							<button class="btn btn-block btn-primary mt-4 mb-3" type="submit">Register</button>
						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>




	<!-- Login form  -->























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