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
                    <input maxlength="10" name="name" class="form-control" placeholder="Please Enter Department"
                           required="required"/>
                </div>
            </div>
            <div class="form-group">
                    <button type="submit" class="btn btn-primary">Create</button>
                    <g:link controller="employees" action="index">
                        <button type="button" class="btn btn-primary ml-2">Cancel</button>
                    </g:link>
                </div>
            </div>
        </g:form>
    </div>
</body>
