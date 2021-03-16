<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Create Employee</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
    <asset:javascript src="jquery-3.3.1.min.js"/>
    <asset:javascript src="popper.min.js"/>
    <asset:javascript src="bootstrap.min.js"/>
    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:stylesheet src="styles.css"/>
</head>

<body>
    <div class="signup-form">
        <g:form controller="employees" action="save" method="post">
            <h2>Create Employee</h2>

            <div class="form-group">
                <h6 class="mb-0 ml-1 text-sm">First Name</h6>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <g:textField name="first_name" class="form-control" placeholder="Please Enter First Name"
                                 required="required"/>
                </div>
            </div>

            <div class="form-group">
                <h6 class="mb-0 ml-1 text-sm">Last Name</h6>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-paper-plane"></i></span>
                    <g:textField name="last_name" class="form-control" placeholder="Please Enter Last Name"
                                 required="required"/>
                </div>
            </div>

            <div class="form-group">
                <h6 class="mb-0 ml-1 text-sm">AFM</h6>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input type="text" maxlength="9" name="afm" class="form-control" placeholder="Please Enter afm"
                           required="required"/>
                </div>
            </div>

            <div class="form-group">
                <h6 class="mb-0 ml-1 text-sm">Date Of Birth</h6>
                <div class="input-group"><span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <g:field type="date" name="date_of_birth" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <h6 class="mb-4 ml-1 text-sm">Department</h6>
                <g:select class="form-control border mb-4" name="id_dep" from="${departments}" optionValue="name" optionKey="department_id" />
            </div>

            <div class="form-action-panel mt-2">
                <button type="submit" class="btn btn-primary ml-2">Create</button>
                <g:link controller="employees" action="index">
                    <button type="button" class="btn btn-primary ml-4">Cancel</button>
                </g:link>
            </div>
        </g:form>
    </div>
</body>
