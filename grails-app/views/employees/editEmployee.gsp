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
    <h2>Επεξεργασία Εργαζομένου</h2>
    <div class="form-group">
        <h6 class="mb-0 ml-1 text-sm">ΟΝΟΜΑ</h6>
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-user"></i></span>
            <input type="text" minlength="3" maxlength="50" name="first_name" class="form-control" placeholder="Εισαγωγή Ονόματος"
                   required="required" pattern="^[α-ωΑ-Ωa-zA-Z]+$" title="Παρακαλώ εισάγεται μόνο γράμματα" value="${first_name}"/>
        </div>
    </div>
    <div class="form-group">
        <h6 class="mb-0 ml-1 text-sm">ΕΠΩΝΥΜΟ</h6>
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-user"></i></span>
            <input type="text" minlength="3" maxlength="50" name="last_name" class="form-control" placeholder="Εισαγωγή Επωνύμου"
                   required="required" pattern="^[α-ωΑ-Ωa-zA-Z]+$" title="Παρακαλώ εισάγεται μόνο γράμματα" value="${last_name}"/>
        </div>
    </div>
    <div class="form-group">
        <h6 class="mb-0 ml-1 text-sm">ΑΦΜ</h6>
        <div class="input-group">
            <span class="input-group-addon"><i class="fa fa-user"></i></span>
            <input type="text" minlength="9" maxlength="9" name="afm" class="form-control" placeholder="Εισαγωγή ΑΦΜ"
                   required="required" pattern="^[0-9]*$" title="Παρακαλώ εισάγεται μόνο αριθμούς" value="${afm}"/>
        </div>

        <div class="form-group">
            <h6 class="mb-0 ml-1 text-sm">ΗΜΕΡΟΜΗΝΙΑ ΓΕΝΝΗΣΗΣ</h6>
            <div class="input-group"><span class="input-group-addon"><i class="fa fa-lock"></i></span>
                <g:field type="date" name="date_of_birth" class="form-control" required="required" value="${date_of_birth}"/>
            </div>
        </div>

        <div class="form-group mt-4">
            <h6 class="mb-0 ml-1 text-sm">ΤΜΗΜΑΤΑ</h6>
            <g:select class="form-control border mb-4" name="id_dep" from="${departments}" optionValue="name" optionKey="department_id"></g:select>
        </div>
        <div class="form-action-panel mt-2">
            <button type="submit" class="btn btn-primary">ΑΠΟΘΗΚΕΥΣΗ</button>
            <g:link controller="employees" action="index">
                <button type="button" class="btn btn-primary ml-2">ΑΚΥΡΩΣΗ</button>
            </g:link>
        </div>
    </div>
</g:form>
</div>
</div>
</body>

