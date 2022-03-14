<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<title>Admin|ModifyDetails</title>
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
					href="/toHomepageAdmin">Home <span class="sr-only">(current)</span>
				</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<a href="/logoutAdmin" class="btn btn-light my-2 my-sm-0"
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


						<form:form method="POST"
							class="border border-light pt-1 pb-2 px-5"
							modelAttribute="eManager" commandName="student"
							action="/saveModifiedApproval">

							<!-- Heading -->
							<p class="h4 mb-4 text-center text-primary">Edit Manager
								Approval Status</p>

							<!-- Hidden ID  -->
							<form:input type="hidden" path="mid" name="mid" />


							<!-- Full Name  -->
							<div class="mb-3">
								<label for="mfullName" class="form-label">Full Name</label>

								<form:input type="text" path="mfullName" name="mfullName"
									class="form-control" readonly="true" />
							</div>

							<!-- Age  -->
							<div class="mb-3">
								<label for="mage" class="form-label">Age</label>

								<form:input type="number" path="mage" name="mage"
									class="form-control" readonly="true" />
							</div>


							<!-- Date of Birth  -->
							<div class="mb-3">
								<label for="mDOB" class="form-label">Date of birth</label>

								<form:input type="text" path="mDOB" name="mDOB"
									class="form-control" readonly="true" />
							</div>

							<!-- Gender  -->
							<div class="mb-3">
								<label for="mgender" class="form-label">Gender</label>

								<form:input type="text" path="mgender" name="mgender"
									class="form-control" readonly="true" />
							</div>

							<!-- Contact Number  -->
							<div class="mb-3">
								<label for="mcontactnum" class="form-label">Contact
									Number</label>

								<form:input type="text" path="mcontactnum" name="mcontactnum"
									class="form-control" readonly="true" />
							</div>


							<!-- Email  -->
							<div class="mb-3">
								<label for="memail" class="form-label">Email</label>

								<form:input type="email" path="memail" name="memail"
									class="form-control" readonly="true" />
							</div>

							<!-- Username  -->
							<div class="mb-3">
								<label for="muserName" class="form-label">Username</label>

								<form:input type="text" path="muserName" name="muserName"
									class="form-control" readonly="true" />
							</div>

							<!-- Password  -->
							<div class="mb-3">
								<label for="mpassword" class="form-label">Password</label>

								<form:input type="text" path="mpassword" name="mpassword"
									class="form-control" readonly="true" />
							</div>

							<!-- Approval Status  -->
							<div class="mb-5 ">
								<label for="mapproval" class="form-label">Approval
									Status</label>

								<form:select path="mapproval" name="mapproval"
									class="form-control">
									<form:option value="NOT APPROVED">NOT APPROVED</form:option>
									<form:option value="APPROVED">APPROVED</form:option>
								</form:select>

							</div>

							<!-- Submit button -->
							<div class="mb-3 text-center">
								<button type="submit" class="btn btn-primary btn-block">Update
									Approval Status</button>
							</div>

						</form:form>













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