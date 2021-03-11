<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Create Employee</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:stylesheet src="styles.css"/>
</head>

<body>
    <div class="signup-form">
        <g:form controller="departments" action="saveDepartment">
            <h2>Create Department</h2>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <g:textField name="name" class="form-control" placeholder="Please Enter A Department"
                                 required="required"/>
                </div>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-lg">Create Department</button>
            </div>
        </g:form>

    </div>
</body>
