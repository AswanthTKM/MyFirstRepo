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
<style>
#source, #destination, #price {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #ddd;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #ddd;
}

th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	background-color: #04AA6D;
	color: white;
}
</style>


<script type="text/javascript">

	var myData = []
	var tollId = ""
	
	function populateMyData()
	{
		var values = '${locationsList}';
		//alert(values);
		<c:forEach items="${locationsList}" var="l">
			if("${l.tapproval}" == "APPROVED"){
				dat = [];
				dat.push('${l.fromLocation}');
				dat.push('${l.toLocation}');
				dat.push('${l.vechtype}');
				dat.push('${l.fee}');
				dat.push('${l.tid}');
				myData.push(dat);
			}
		</c:forEach>
		/* alert(myData); */
	}
	
	function makeDropDown(data, sourceFilter)
	{
		const filteredArray = data.filter(r => r[0] === sourceFilter);
		
		const uniqueList = getUniqueValues(filteredArray,1);
		
		const destinationLevel = document.getElementById("destination");
		
		destinationLevel.innerHTML = "";
		
		populateDropDown(destinationLevel, uniqueList, 0);
		
	}
	
	function makeVtypeDropDown(data, sourceFilter, destinationFilter)
	{
		const filteredArray = data.filter(r => r[0] === sourceFilter);
		const filteredVtype = filteredArray.filter(r => r[1] === destinationFilter);
		const uniqueList = getUniqueValues(filteredVtype,2);
		const vtypeLevel = document.getElementById("vtype");
		vtypeLevel.innerHTML = "";	
		populateDropDown(vtypeLevel, uniqueList, 0);
		
	}
	
	function makePriceDropDown(data, sourceFilter, destinationFilter, vtypeFilter)
	{
		const filteredArray = myData.filter(r => r[0] === sourceFilter);
		const filteredDestination = filteredArray.filter(r => r[1] === destinationFilter);
		const filteredVtype = filteredDestination.filter(r => r[2] === vtypeFilter);
		console.log(destinationFilter);
		const uniqueList = getUniqueValues(filteredVtype,3);
		tollId = getUniqueValues(filteredVtype,4);
		
		const priceLevel = document.getElementById("price");
		priceLevel.innerHTML = "";
		const oneOrtwoValue = document.getElementById("oneortwo").value;
		var oneOrtwo = 0;
		console.log(oneOrtwoValue);
		if(oneOrtwoValue == "Two Way"){
			oneOrtwo = 1;
		}
		populateDropDown(priceLevel, uniqueList, oneOrtwo);
		
	}
	
	function applyDropDown()
	{
		const sourceLevel = document.getElementById("source").value;
		makeDropDown(myData,sourceLevel)
		applyVtypeDropDown();
	}
	
	function applyPriceDropDown()
	{
		const sourceLevel = document.getElementById("source").value;
		const destinationLevel = document.getElementById("destination").value;
		const vtypeLevel = document.getElementById("vtype").value;
		makePriceDropDown(myData,sourceLevel,destinationLevel,vtypeLevel);
	}
	
	function applyVtypeDropDown()
	{
		const sourceLevel = document.getElementById("source").value;
		const destinationLevel = document.getElementById("destination").value;
		makeVtypeDropDown(myData,sourceLevel,destinationLevel);
		applyPriceDropDown();
	}
	
	function afterDocumentLoads(){
		populateMyData();
		populateSourceDropDown();
		applyDropDown();
		applyVtypeDropDown();
		applyPriceDropDown();
		
		
	}
	
	function getUniqueValues(data, index){
		
		const uniqueOptions = new Set();
		
		data.forEach(r => uniqueOptions.add(r[index]));
		
		return [...uniqueOptions];
	
	}
	
	function populateSourceDropDown()
	{
		const uniqueList = getUniqueValues(myData,0);
		const sourceLevel = document.getElementById("source");
		populateDropDown(sourceLevel, uniqueList, 0);
	}
	
	function populateDropDown(elm, listAsArray, isPrice)
	{
		//alert(elm);
		console.log("is",isPrice);
		elm.innerHTML == "";
		listAsArray.forEach(item => {
			const option = document.createElement("option");
			if(isPrice == 1)
			{
				item = item * 2;
			}
			option.textContent = item;
			elm.appendChild(option);
		});
		
	}

	function populateForm() {
		
		var fsource = document.getElementById("fsource");
		var tsourcevalue = document.getElementById("source").value;
		document.getElementById("fsource").value = tsourcevalue;
		
		var fdestination = document.getElementById("fdestination");
		var tdestinationvalue = document.getElementById("destination").value;
		document.getElementById("fdestination").value = tdestinationvalue;
		
		var fvtype = document.getElementById("fvtype");
		var tvtypevalue = document.getElementById("vtype").value;
		document.getElementById("fvtype").value = tvtypevalue;
		
		
		var foneortwo = document.getElementById("foneortwo");
		var toneortwovalue = document.getElementById("oneortwo").value;
		document.getElementById("foneortwo").value = toneortwovalue;
		
		
		var fprice = document.getElementById("fprice");
		var tpricevalue = document.getElementById("price").value;
		document.getElementById("fprice").value = tpricevalue;
		
		var ftid = document.getElementById("ftid");
		document.getElementById("ftid").value = tollId;
		
		var fjdate =  document.getElementById("fjdate");
		var tjdatevalue = document.getElementById("jdate").value;
		document.getElementById("fjdate").value = tjdatevalue;
		
		document.getElementById("myform").submit();
		
	}
	
	//document.getElementById("source").addEventListener("change",applyDropDown);
	document.addEventListener("DOMContentLoaded",afterDocumentLoads);

</script>

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
				<button type="button" class="btn btn-light my-2 my-sm-0 mr-2"
					disabled>${eUser.ufullName}</button>
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
					<div class="card-body"></div>


					<h2 align="center">View Toll Details</h2>


				</div>
			</div>
		</div>
	</div>

	<c:set var="count" value="0" scope="page" />
	<table align="center">
		<tr>
			<th><h3>Source</h3></th>
			<th><h3>Destination</h3></th>
			<th><h3>Vehicle Type</h3></th>
			<th><h3>One way / Two way</h3></th>
			<th><h3>Price</h3></th>
			<th><h3>Journey Date</h3></th>
			<th><h3></h3></th>
		</tr>
		<tr>
			<th><select id='source' onchange="applyDropDown();"
				class="mdb-select md-form"></select></th>

			<th><select id='destination' onchange="applyVtypeDropDown();"></select></th>

			<th><select id='vtype' onchange="applyPriceDropDown();"></select></th>
			<th><select id='oneortwo' onchange="applyPriceDropDown();"><option>One
						Way</option>
					<option>Two Way</option></select></th>
			<th><select id='price' disabled></select></th>
			<th><input id='jdate' type="date"></th>

			<th><input type="button" onclick="populateForm()"
				value="Buy TollTicket"></th>

		</tr>
	</table>

	<br>
	<br>
	<a type="button" class="btn btn-primary float-right"
		href="/toHomepageUser">Back to Homepage</a>



	<form id="myform" action="/confirmPayment" method="post">
		<input type="hidden" name="fsource" id="fsource" value=""> <input
			type="hidden" name="fdestination" id="fdestination" value="">
		<input type="hidden" name="fvtype" id="fvtype" value=""> <input
			type="hidden" name="foneortwo" id="foneortwo" value=""> <input
			type="hidden" name="fprice" id="fprice" value=""> <input
			type="hidden" name="ftid" id="ftid" value=""> <input
			type="date" name="fjdate" id="fjdate" value="" hidden="hidden">
	</form>


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