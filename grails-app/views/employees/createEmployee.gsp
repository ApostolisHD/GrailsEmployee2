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
            <h2>Δημιουργία Εργαζομένου</h2>

            <div class="form-group">
                <label class="mb-0 ml-1 text-sm" for="first_name">ΟΝΟΜΑ</label>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" id="first_name" minlength="3" maxlength="50" name="first_name" class="form-control" placeholder="Εισαγωγή Ονόματος"
                           required="required" pattern="^[α-ωΑ-Ωa-zA-Z]+$"/>
                </div>
            </div>

            <div class="form-group">
                <label class="mb-0 ml-1 text-sm" for="last_name">ΕΠΩΝΥΜΟ</label>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-paper-plane"></i></span>
                    <input type="text" id="last_name" minlength="3" maxlength="50" name="last_name" class="form-control" placeholder="Εισαγωγή Επωνύμου"
                           required="required" pattern="^[α-ωΑ-Ωa-zA-Z]+$" title="Παρακαλώ εισάγεται μόνο γράμματα"/>
                </div>
            </div>

            <div class="form-group">
                <label class="mb-0 ml-1 text-sm" for="afm">ΑΦΜ</label>
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input type="text" id="afm" minlength="9" maxlength="9" name="afm" class="form-control" placeholder="Εισαγωγή ΑΦΜ"
                           required="required" pattern="^[0-9]*$" title="Παρακαλώ εισάγεται μόνο αριθμούς"/>
                </div>
            </div>

            <div class="form-group">
                <label class="mb-0 ml-1 text-sm" for="date_of_birth">ΗΜΕΡΟΜΗΝΙΑ ΓΕΝΝΗΣΗΣ</label>
                <div class="input-group"><span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <g:field type="date" id="date_of_birth" name="date_of_birth" class="form-control" required="required"/>
                </div>
            </div>

            <div class="form-group">
                <h6 class="mb-4 ml-1 text-sm">ΤΜΗΜΑΤΑ</h6>
                <g:select class="form-control border mb-4" name="id_dep" from="${departments}" optionValue="name" optionKey="department_id" />
            </div>

            <div class="form-action-panel mt-2">
                <button type="submit" class="btn btn-primary ml-2">ΔΗΜΙΟΥΡΓΙΑ</button>
                <g:link controller="employees" action="index">
                    <button type="button" class="btn btn-primary ml-4">ΑΚΥΡΩΣΗ</button>
                </g:link>
            </div>
        </g:form>
    </div>
</body>
