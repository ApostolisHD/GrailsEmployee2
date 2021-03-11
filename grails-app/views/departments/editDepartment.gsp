<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Edit Employee</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:stylesheet src="styles.css"/>
</head>
<body>
<div class="signup-form">
<g:form controller="departments" action="updateDepartment" id="${department_id}" method="post">
    <h2>Create Employee</h2>
    <div class="form-group">
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-user"></i></span>
            <g:textField name="name" class="form-control"
                         value="${name}"/>
        </div>
    </div>
        <div class="form-action-panel mt-2">
            <g:link controller="user" action="index">
                <button type="submit" class="btn btn-primary">Submit</button>
            </g:link>
            <g:link controller="user" action="index">
                <button type="button" class="btn btn-primary ml-2">Cancel</button>
            </g:link>
        </div>
    </div>
</g:form>
</div>
</div>
</body>

