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


<script>
function modifyForm(id,myDate,source,destination,vtype,oneortwo,price,jdate) {
		var mydate = new Date(jdate);
		const now = Date.now();
		const msBetweenDates = (mydate.getTime() - now);

		const hoursBetweenDates = msBetweenDates / (60 * 60 * 1000);
		if (hoursBetweenDates > 24) {
			
			var fsource = document.getElementById("fsource");
			document.getElementById("fsource").value = source;
			
			var fdestination = document.getElementById("fdestination");
			document.getElementById("fdestination").value = destination;
			
			var fvtype = document.getElementById("fvtype");
			document.getElementById("fvtype").value = vtype;
			
			
			var foneortwo = document.getElementById("foneortwo");
			document.getElementById("foneortwo").value = oneortwo;
			
			
			var fprice = document.getElementById("fprice");
			document.getElementById("fprice").value = price;
			
			var ftid = document.getElementById("ftid");
			document.getElementById("ftid").value = id;
			
			var fjdate =  document.getElementById("fjdate");
			document.getElementById("fjdate").value = jdate;
			document.getElementById("myform").submit();
			
		} else {
		  alert("Cannot Modify this Journey date as 24 hours has passed");
}
		
	}
</script>
<title>User|View Planned Journey</title>
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

	<div class="container p-4">
		<div class="row">
			<div class="col-md-12 offset-md-0">
				<div class="card">




					<!-- card header -->
					<div class="card-header">


						<!-- Alert  -->
						<div class="mx-5 ">

							<c:if test="${not empty logMsg}">
								<div class="alert alert-success text-center" role="alert">
									<strong><c:out value="${logMsg}" /></strong>
								</div>
								<c:set var="logMsg" value="" scope="session" />
							</c:if>
						</div>
						<!-- Alert  -->


						<h4 class="text-primary text-center">Planned Jouneys</h4>
					</div>

					<!-- card Body  -->
					<div class="card-body">

						<c:set var="count" value="0" scope="page" />
						<c:set var="euid" value="${eUid}" scope="page" />
						<table class="table table-striped table-hover table-bordered">
							<thead>
								<tr>
									<th class="text-center" scope="col">Sl.No</th>
									<th class="text-center" scope="col">From Location</th>
									<th class="text-center" scope="col">To Location</th>
									<th class="text-center" scope="col">Vehicle Type</th>
									<th class="text-center" scope="col">Oneway / Twoway</th>
									<th class="text-center" scope="col">Fee paid</th>
									<th class="text-center" scope="col">Journey Date</th>
									<th class="text-center" scope="col">Action</th>
								</tr>
							</thead>

							<tbody>

								<c:forEach var="m" items="${userTollList}">
									<c:if test="${ m.user.uid == euid }">
										<c:set var="count" value="${count + 1}" scope="page" />

										<tr>
											<td class="text-center">${count}</td>
											<td class="text-center">${m.tolldetails.fromLocation}</td>
											<td class="text-center">${m.tolldetails.toLocation}</td>
											<td class="text-center">${m.tolldetails.vechtype}</td>
											<td class="text-center">${m.oneortwo}</td>
											<td class="text-center">${m.price}</td>
											<td class="text-center">${m.getJourneyDate()}</td>
											<td class="text-center">
												<input type="button" onclick="modifyForm('${m.id}','${m.getCreatedDate()}',
												'${m.tolldetails.fromLocation}','${m.tolldetails.toLocation}','${m.tolldetails.vechtype}','${m.oneortwo}','${m.price}','${m.getJourneyDate()}')" 
												value="Modify" class="btn btn-sm btn-danger mx-0">
												<a href="/deleteJourneyDetails?id=${m.id}&price=${m.price}" class="btn btn-sm btn-danger mx-0">Cancel Journey</a>
											</td>
										</tr>
									</c:if>
								</c:forEach>

							</tbody>
						</table>
						<form id="myform" action="/ModifyTollDetailsUser" method="post">
							<input type="hidden" name="fsource" id="fsource" value="">
							<input type="hidden" name="fdestination" id="fdestination" value="">
							<input type="hidden" name="fvtype" id="fvtype" value="">
							<input type="hidden" name="foneortwo" id="foneortwo" value=""> 
							<input type="hidden" name="fprice" id="fprice" value=""> 
							<input type="hidden" name="ftid" id="ftid" value=""> 
							<input type="date" name="fjdate" id="fjdate" value="" hidden="hidden">
						</form>
						<a href="/toHomepageUser" class="btn btn-primary float-right">Back</a>




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