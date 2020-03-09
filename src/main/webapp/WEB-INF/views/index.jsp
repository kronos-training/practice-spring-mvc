<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Clients</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <a class="navbar-brand" href="#">Navbar</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav">
	      <li class="nav-item active">
	        <a class="nav-link" href="#">Example with Spring Boot <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Export Clients
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <a href="/export/pdf" class="dropdown-item" href="#">PDF</a>
                <a href="/export/excel" class="dropdown-item" href="#">Excel</a>
              </div>
            </li>
	    </ul>
	  </div>
	</nav>

	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<h2 class="display-4">${ title }</h2>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Client</th>
							<th scope="col">Email</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clients}" var="item">
							<tr>
								<td>${item.id}</td>
								<td>${item.name}</td>
								<td>${item.email}</td>
								<td><a href="/update/${item.id}" class="badge badge-success">Update</a>&nbsp;
									<a href="/delete/${item.id}" class="badge badge-danger">Remove</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">

				<h2 class="display-4">New Client</h2>

				<form action="/create" method="POST">
					<div class="form-group">
				    	<label for="idField">ID</label>
				    	<input type="number" class="form-control" id="idField" name="id" value="${client.id}">
				  	</div>

					<div class="form-group">
				    	<label for="nameField">Name</label>
				    	<input type="text" class="form-control" id="nameField" name="name" value="${client.name}">
				  	</div>
				  	<div class="form-group">
				    	<label for="lastNameField">LastName</label>
				    	<input type="text" class="form-control" id="lastNameField" name="lastName" value="${client.lastName}">
				  	</div>
				  	<div class="form-group">
				    	<label for="emailField">Email</label>
				    	<input type="email" class="form-control" id="emailField" name="email" value="${client.email}">
				  	</div>
				  	<div class="form-group">
				    	<label for="numberPhoneField">Number Phone</label>
				    	<input type="text" class="form-control" id="numberPhoneField" name="numberPhone" value="${client.numberPhone}">
				  	</div>
				  	<button type="submit" class="btn btn-primary">Submit</button>
				  	<a href="/" class="btn btn-success">Add client</a>
				</form>
			</div>
		</div>

	</div>


	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>