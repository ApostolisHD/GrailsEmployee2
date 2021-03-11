<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Create Employee</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:stylesheet src="styles.css"/>
</head>

<body>
    <div class="signup-form">
        <g:form controller="employees" action="save">
            <h2>Create Employee</h2>

            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <g:textField name="first_name" class="form-control" placeholder="Please Enter First Name"
                                 required="required"/>
                </div>
            </div>

            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-paper-plane"></i></span>
                    <g:textField name="last_name" class="form-control" placeholder="Please Enter Last Name"
                                 required="required"/>
                </div>
            </div>

            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input maxlength="9" name="afm" class="form-control" placeholder="Please Enter afm"
                           required="required"/>
                </div>
            </div>

            <div class="form-group">
                <div class="input-group"><span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <g:field type="date" name="date_of_birth" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <g:select name="id_dep" from="${departments}" optionValue="name" optionKey="department_id" />
            </div>

            <div class="form-group mt-2">
                <button type="submit" class="btn btn-primary btn-block btn-lg">Sign Up</button>
            </div>
        </g:form>

    </div>
</body>
