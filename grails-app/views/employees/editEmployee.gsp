<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Edit Employee</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:stylesheet src="styles.css"/>
</head>
<body>
<div class="signup-form">
<g:form controller="employees" action="updateEmployee" id="${employee_id}" method="post">
    <h2>Edit Employee</h2>

    <div class="form-group">
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-user"></i></span>
            <g:textField name="first_name" class="form-control" placeholder="Please Enter First Name"
                         value="${first_name}"/>
        </div>
    </div>

    <div class="form-group">
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-user"></i></span>
            <g:textField name="last_name" class="form-control" placeholder="Please Enter Last Name"
                         value="${last_name}"/>
        </div>
    </div>

    <div class="form-group">
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-user"></i></span>
            <input maxlength="9" name="afm" class="form-control" placeholder="Please Enter afm" value="${afm}"/>
        </div>

        <div class="form-group mt-4">
            <g:select class="form-control border mb-4" name="id_dep" from="${departments}" optionValue="name" optionKey="department_id"></g:select>
        </div>

        <div class="form-action-panel mt-2">
            <button type="submit" class="btn btn-primary">Save</button>
            <g:link controller="employees" action="index">
                <button type="button" class="btn btn-primary ml-2">Cancel</button>
            </g:link>
        </div>
    </div>
</g:form>
</div>
</div>
</body>

