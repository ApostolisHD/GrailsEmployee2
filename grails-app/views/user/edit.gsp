<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>EmployeeManagment</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous">

<div class="card">
  <div class="card-header">
  </div>
  <div class="card-body">
    <g:form controller="user" action="update" >
      <div class="form-group">
        <label>First Name</label>
        <g:textField name="first_name" class="form-control" value="${first_name}"/>
      </div>

      <div class="form-group">
        <label>Last Name</label>
        <g:textField name="last_name" class="form-control" value="${last_name}" placeholder="Please Enter Last Name"/>
      </div>
      <div class="form-group">
        <label>AFM</label>
        <g:textField name="afm" class="form-control" value="${afm}" placeholder="Please Enter afm"/>
      </div>
      <div class="form-action-panel">
        <button type="submit" class="btn btn-primary"> Submit </button>
        <g:link controller="user" action="index" class="btn btn-primary">cancel</g:link>
      </div>
    </g:form>
  </div>
</div>