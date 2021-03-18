<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Edit Department</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:stylesheet src="styles.css"/>
</head>
<body>
<div class="signup-form">
<g:form controller="departments" action="updateDepartment" id="${department_id}" method="post">
    <h2>Επεξεργασία Τμηματός</h2>
    <div class="form-group">
        <label class="mb-0 ml-1 text-sm" for="name">ΟΝΟΜΑ ΤΜΗΜΑΤΟΣ</label>
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-user"></i></span>
            <input minlength="1" maxlength="10" id="name" name="name" placeholder="Εισαγωγή Τμήματος" class="form-control" value="${name}" required="required"/>
        </div>
    </div>
        <div class="form-action-panel mt-2">
            <g:link controller="employees" action="index">
                <button type="submit" class="btn btn-primary">ΑΠΟΘΗΚΕΥΣΗ</button>
            </g:link>
            <g:link controller="employees" action="index">
                <button type="button" class="btn btn-primary ml-2">ΑΚΥΡΩΣΗ</button>
            </g:link>
        </div>
    </div>
</g:form>
</div>
</div>
</body>

