<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<div class="card">
<nav class="col-md-2 col-2 bg-light sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">

            <li class="nav-item">
                <a class="nav-link" href="/">
                    Books
                </a>
            </li>

            <li class="nav-item ">
                <a class="nav-link <#if page == '/search'> active</#if>" href="/search">
                    Search for Books
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/user/create">
                    Add Book
                </a>
            </li>
        </ul>
    </div>
</nav>
</div>
<div class="h-auto">
<div class="container-fluid">
<div class="card">
    <div class="card-header">
        <div class="card-body">
            <table class="table table-bordered">
                <thead class="thead-dark">
                    <tr>
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
                                    <td>${it.first_name}</td>
                                    <td>${it.last_name}</td>
                                    <td>${it.afm}</td>
                                    <td>${it.date_of_birth}</td>
                                    <td>
                                        <g:link controller="user" action="delete" class="btn btn-secondary" id="${it.employee_id}"><i class="fas fa-trash"></i></g:link>
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