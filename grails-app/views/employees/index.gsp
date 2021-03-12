<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title>Employee Management</title>
    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:stylesheet src="styles.css"/>
</head>


<body class="sb-nav-fixed">
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
        <a class="navbar-brand" href="index">Employee - Department Management</a>
        <div class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-5 my-2 my-md-0">
            <div class="collapse navbar-collapse" id="navbar-list-4">
                <div class ="sb-nav-link-icon"> <i class="bi bi-person" style="font-size: 2rem; color: cornflowerblue"></i></div>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                           ${user_name}
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <g:link controller="authentication" action="logout" class="dropdown-item">Log Out</g:link>
                        </div>
                    </li>
                </ul>
            </div>
        </div>

    </nav>
    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <div class="sb-sidenav-menu-heading">Employee Management</div>

                        <g:link controller="employees" action="createEmployee" class="nav-link">
                            <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                            Create Employee
                        </g:link>
                        <div class="sb-sidenav-menu-heading">Departments Management</div>
                        <g:link controller="departments" action="createDepartment" class="nav-link">
                            <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                            Create Department
                        </g:link>
                        <div class="sb-sidenav-menu-heading"></div>
                            <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        </div>
                         </div>
            <div class="sb-sidenav-footer">
                <div class="small">Logged in as:</div>
                ${user_name}
            </div>
        </nav>
    </div>

        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid">
                    <h1 class="mt-4">Employees</h1>

                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-table mr-1"></i>
                            DataTable Employees
                        </div>

                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                    <tr>
                                        <th>Department</th>
                                        <th>First Name</th>
                                        <th>last Name</th>
                                        <th>AFM</th>
                                        <th>Date Of Birth</th>
                                        <th>Actions</th>
                                    </tr>
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
                                                <g:link controller="employees" action="editEmployee" class="btn btn-secondary"
                                                        id="${it.employee_id}">Edit</g:link>
                                                <g:link controller="employees" action="deleteEmployee" class="btn btn-secondary"
                                                        id="${it.employee_id}">Delete</g:link>
                                            </td>
                                        </tr>
                                    </g:each>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </main>

            <div>
                <main>
                    <g:if test="${flash.message}">
                        <div class="alert alert-primary alert-dismissible" role="alert">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <g:message message="${flash.message}"></g:message>
                        </div>
                    </g:if>
                    <div class="container-fluid">
                        <h1 class="mt-4">Departments</h1>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                DataTable Departments
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" width="100%" cellspacing="0">
                                        <thead>
                                        <tr>
                                        <tr>
                                            <th>Department</th>
                                            <th>Actions</th>
                                        </tr>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <g:each in="${departments}">
                                            <tr>
                                                <td>${it.name}</td>
                                                <td>
                                                    <g:link controller="departments" action="editDepartment" class="btn btn-secondary"
                                                            id="${it.department_id}">Edit</g:link>
                                                    <g:link controller="departments" action="deleteDepartment" class="btn btn-secondary"
                                                            id="${it.department_id}">Delete</g:link>
                                                </td>
                                            </tr>
                                        </g:each>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>

            <footer class="py-4 bg-light mt-auto">
                <div class="container-fluid">
                    <div class="d-flex align-items-center justify-content-between small">
                        <div class="text-muted">Copyright &copy; Employee - Department Management 2021</div>

                        <div>
                            <a href="index">Privacy Policy</a>
                            &middot;
                            <a href="index">Terms &amp; Conditions</a>
                        </div>
                    </div>
                </div>
            </footer>
            </div>
        </div>
    </div>
</body>