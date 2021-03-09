<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>EmployeeManagment</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <asset:stylesheet src="sidebar.css"/>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <a href="user/index" class="navbar-brand">Employee</a>
    <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarMenu">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>

<div class="d-flex" id="wrapper">
    <div class="sidebar bg-light border-right" id="sidebar-wrapper">
        <div class="list-group list-group-flush">
            <a href="#" class="list-group-item list-group-item-action bg-light">Search Employee</a>
            <g:link controller="user" action="create" class="btn btn-secondary">Add Employee</g:link>
            <a href="#" class="list-group-item list-group-item-action bg-light">Logout</a>
        </div>
    </div>
</div>

<div id="page-content-wrapper">
    <div class="page-content">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
            <table class="table table-condensed table-hover table-striped table-bordered col-sm-12">
                <thead class="thead-dark" >
                    <tr>
                        <th>Departure</th>
                        <th>First Name</th>
                        <th>last Name</th>
                        <th>AFM</th>
                        <th>date_of_birth</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                        <tbody>
                            <g:each in="${employees}">
                                <tr>
                                    <td>${it.name}</td>
                                    <td>${it.first_name}</td>
                                    <td>${it.last_name}</td>
                                    <td>${it.afm}</td>
                                    <td>${it.date_of_birth}</td>
                                    <td>
                                        <g:link controller="user" action="edit" class="btn btn-secondary" id="${it.employee_id}">Edit</g:link>
                                        <g:link controller="user" action="delete" class="btn btn-secondary" id="${it.employee_id}">Delete</g:link>
                                    </td>
                                </tr>
                            </g:each>
                        </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</div>
</body>
