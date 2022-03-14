<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<title>User|Feedback</title>
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
				<a href="/logoutUser" class="btn btn-light my-2 my-sm-0"
					type="submit">Logout</a>
			</form>
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
						<h4 class="text-primary text-center">Add Feedback</h4>
					</div>



					<!-- card Body  -->
					<div class="card-body">

						<form class="border border-light pt-1 pb-3 px-5"
							action="/saveUserFeedback" method="post">

							<!-- uid -->
							<div class="mb-4">
								<label for="uid" class="form-label">User ID</label> <input
									name="uid" class="form-control" placeholder="${eUser.uid}"
									value="${eUser.uid}" readonly="readonly" />
							</div>

							<!-- user name -->
							<div class="mb-4">
								<label for="ufullName" class="form-label">Full Name</label> <input
									name="ufullName" class="form-control"
									placeholder="${eUser.ufullName}" value="${eUser.ufullName}"
									readonly="readonly" />
							</div>

							<div class="mb-4">
								<label>Kindly provide your feedback on a scale of 1-5 (
									1 being lowest and 5 being highest)</label>
							</div>

							<!-- Question1 -->
							<div class="mb-4">
								<label for="resp01" class="form-label"> 1.How user
									friendly is the application? </label> <br>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp01"
										id="inlineRadio1" value="1"> <label
										class="form-check-label" for="inlineRadio1">1</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp01"
										id="inlineRadio2" value="2"> <label
										class="form-check-label" for="inlineRadio2">2</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp01"
										id="inlineRadio3" value="3"> <label
										class="form-check-label" for="inlineRadio2">3</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp01"
										id="inlineRadio4" value="4"> <label
										class="form-check-label" for="inlineRadio2">4</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp01"
										id="inlineRadio5" value="5"> <label
										class="form-check-label" for="inlineRadio2">5</label>
								</div>
							</div>

							<!-- Question2 -->
							<div class="mb-4">
								<label for="resp02" class="form-label"> 2.How legible
									were the user guidelines to you? </label> <br>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp02"
										id="inlineRadio1" value="1"> <label
										class="form-check-label" for="inlineRadio1">1</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp02"
										id="inlineRadio2" value="2"> <label
										class="form-check-label" for="inlineRadio2">2</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp02"
										id="inlineRadio3" value="3"> <label
										class="form-check-label" for="inlineRadio2">3</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp02"
										id="inlineRadio4" value="4"> <label
										class="form-check-label" for="inlineRadio2">4</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp02"
										id="inlineRadio5" value="5"> <label
										class="form-check-label" for="inlineRadio2">5</label>
								</div>
							</div>

							<!-- Question3 -->
							<div class="mb-4">
								<label for="resp03" class="form-label"> 3.How frequently
									do you use the application for your journeys? </label> <br>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp03"
										id="inlineRadio1" value="1"> <label
										class="form-check-label" for="inlineRadio1">1</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp03"
										id="inlineRadio2" value="2"> <label
										class="form-check-label" for="inlineRadio2">2</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp03"
										id="inlineRadio3" value="3"> <label
										class="form-check-label" for="inlineRadio2">3</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp03"
										id="inlineRadio4" value="4"> <label
										class="form-check-label" for="inlineRadio2">4</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp03"
										id="inlineRadio5" value="5"> <label
										class="form-check-label" for="inlineRadio2">5</label>
								</div>
							</div>

							<!-- Question4 -->
							<div class="mb-4">
								<label for="resp04" class="form-label"> 4.Has the
									application helped you save time? </label> <br>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp04"
										id="inlineRadio1" value="1"> <label
										class="form-check-label" for="inlineRadio1">1</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp04"
										id="inlineRadio2" value="2"> <label
										class="form-check-label" for="inlineRadio2">2</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp04"
										id="inlineRadio3" value="3"> <label
										class="form-check-label" for="inlineRadio2">3</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp04"
										id="inlineRadio4" value="4"> <label
										class="form-check-label" for="inlineRadio2">4</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp04"
										id="inlineRadio5" value="5"> <label
										class="form-check-label" for="inlineRadio2">5</label>
								</div>
							</div>


							<!-- Question5 -->
							<div class="mb-5">
								<label for="resp05" class="form-label"> 5.Would you
									recommend the application to others? </label> <br>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp05"
										id="inlineRadio1" value="1"> <label
										class="form-check-label" for="inlineRadio1">1</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp05"
										id="inlineRadio2" value="2"> <label
										class="form-check-label" for="inlineRadio2">2</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp05"
										id="inlineRadio3" value="3"> <label
										class="form-check-label" for="inlineRadio2">3</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp05"
										id="inlineRadio4" value="4"> <label
										class="form-check-label" for="inlineRadio2">4</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="resp05"
										id="inlineRadio5" value="5"> <label
										class="form-check-label" for="inlineRadio2">5</label>
								</div>
							</div>


							<button class="btn btn-block btn-primary mt-4 mb-3" type="submit">Submit
								Feedback</button>
						</form>
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