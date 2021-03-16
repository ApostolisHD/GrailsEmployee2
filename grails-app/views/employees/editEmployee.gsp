<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Edit Employee</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:javascript src="jquery-3.3.1.min.js"/>
    <asset:javascript src="popper.min.js"/>
    <asset:javascript src="bootstrap.min.js"/>
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

