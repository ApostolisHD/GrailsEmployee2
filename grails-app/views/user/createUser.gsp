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
        <g:form controller="user" action="signUp">
            <h2>Εγγραφή</h2>
            <p>Παρακαλώ συμπληρώστε την φόρμα!</p>
            <hr>
            <div class="form-group">
                <input type="user_name" maxlength="50" pattern="^[a-zA-Z]+$" class="form-control" name="user_name" placeholder="Username"
                       required="required">
            </div>

            <div class="form-group">
                <input type="password" maxlength="50" pattern="^[a-zA-Z0-9]+$" class="form-control" name="user_password" placeholder="Password"
                       required="required">
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-lg">ΕΓΓΡΑΦΗ</button>
            </div>
        </g:form>
        <div class="hint-text">Έχετε ήδη λογαριασμό?
            <g:link controller="authentication" action="Login">
            <button type="button" class="btn btn-primary ml-2">ΣΥΝΔΕΣΗ</button>
        </g:link>
        </div>
    </div>
</body>
