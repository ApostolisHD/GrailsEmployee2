<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta charset="utf-8">
    <asset:stylesheet src="login.css"/>
    <title>Login</title>
    <asset:stylesheet src="bootstrap.min.css"/>
</head>

<body>
    <g:if test="${flash.message}">
        <div class="alert alert-primary alert-dismissible" role="alert">
            <a href="/" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <g:message message="${flash.message}"></g:message>
        </div>
    </g:if>
    <g:form controller="authentication" action="doLogin" id="${user_id}">
        <div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
            <div class="card card0 border-0">
                <div class="row d-flex">
                    <div class="col-lg-6">
                        <div class="card1 pb-5">
                            <div class="row"><img
                                    src="data:image/png;base64,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"
                                    class="logo">
                            </div>
                            <div class="row px-3 justify-content-center mt-4 mb-5 border-line">
                                <img src="https://i.imgur.com/uNGdWHi.png" class="image">
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6">
                        <div class="card2 card border-0 px-4 py-5">
                            <div class="row px-3">
                                <label class="mb-1">Username</label>
                                <input type="text" maxlength="50" name="user_name" class="form-control" placeholder="Εισαγωγή username"  required="required"/></div>
                            <div class="row px-3"><label class="mb-1">
                                <h6 class="mb-0 text-sm">Password</h6>
                            </label><input type="password" maxlength="50" name="user_password" class="form-control" placeholder="Εισαγωγή password" required="required"/></div>

                            <div class="row mb-3 px-3"><button type="submit" class="btn btn-primary mt-2">ΣΥΝΔΕΣΗ</button>
                            </div>

                            <div class="row mb-4 px-3"><small class="font-weight-bold">Δεν έχετε λογαριασμό? <g:link
                                    controller="user" action="createUser"
                                    class="btn btn-primary">ΕΓΓΡΑΦΗ</g:link></small></div>
                        </div>
                    </div>
                </div>
                <div class="bg-blue py-4">
                    <div class="row px-3"><small
                            class="ml-4 ml-sm-5 mb-2">Copyright &copy; 2021. All rights reserved.</small>
                        <div class="social-contact ml-4 ml-sm-auto"><span
                                class="fa fa-facebook mr-4 text-sm"></span> <span
                                class="fa fa-google-plus mr-4 text-sm"></span> <span
                                class="fa fa-linkedin mr-4 text-sm"></span> <span
                                class="fa fa-twitter mr-4 mr-sm-5 text-sm"></span></div>
                    </div>
                </div>
            </div>
        </div>
    </g:form>
</body>
