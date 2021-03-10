<%@ page contentType="text/html;charset=UTF-8" %>

<head>
    <asset:stylesheet src="SignUp.css"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
    <title>Sign Up Form</title>
    <asset:stylesheet src="bootstrap.min.css"/>
</head>

<body>
    <div class="signup-form">
        <g:form controller="signupUser" action="signUp">
            <h2>Sign Up</h2>

            <p>Please fill in this form to create an account!</p>
            <hr>

            <div class="form-group">
                <input type="user_name" class="form-control" name="user_name" placeholder="Username"
                       required="required">
            </div>

            <div class="form-group">
                <input type="password" class="form-control" name="user_password" placeholder="Password"
                       required="required">
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-lg">Sign Up</button>
            </div>
        </g:form>
        <div class="hint-text">Already have an account?<g:link controller="authentication" action="Login"
                                                               class="btn btn-secondary">Login Here</g:link></div>
    </div>
</body>