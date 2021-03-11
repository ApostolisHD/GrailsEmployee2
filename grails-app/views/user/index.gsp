<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Employee Management</title>
    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:stylesheet src="styles.css"/>
</head>

<body class="sb-nav-fixed">
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
        <a class="navbar-brand" href="index">Employee - Department Management</a>
        <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i>
        </button>

%{--        <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">--}%
%{--            <div class="input-group">--}%
%{--                <input class="form-control" type="text" placeholder="Search for..." aria-label="Search"--}%
%{--                       aria-describedby="basic-addon2"/>--}%

%{--                <div class="input-group-append">--}%
%{--                    <button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>--}%
%{--                </div>--}%
%{--            </div>--}%
%{--        </form>--}%
    </nav>

    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <div class="sb-sidenav-menu-heading">Employee Management</div>
                        <g:link controller="user" action="create" class="nav-link">
                            <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                            Create Employee
                        </g:link>
                        <div class="sb-sidenav-menu-heading">Departments Management</div>
                        <g:link controller="departments" action="create" class="nav-link">
                            <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                            Create Department
                        </g:link>
                        <div class="sb-sidenav-menu-heading">Settings</div>
                        <g:link controller="authentication" action="logout" class="nav-link">
                            <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                            Logout
                        </g:link>
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
                                                <g:link controller="user" action="editEmployee" class="btn btn-secondary"
                                                        id="${it.employee_id}">Edit</g:link>
                                                <g:link controller="user" action="deleteEmployee" class="btn btn-secondary"
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