

<div class="form-group">
    <g:textField name="firstName" class="form-control" value="${member?.firstName}" placeholder="Please Enter First Name"/>
    <UIHelper:renderErrorMessage fieldName="firstName" model="${member}" errorMessage="please.enter.first.name"/>
</div>

<div class="form-group">
    <label><g:message code="last.name"/></label>
    <g:textField name="lastName" class="form-control" value="${member?.lastName}" placeholder="Please Last Name"/>
</div>

<div class="form-group">
    <label><g:message code="email.address"/> *</label>
    <g:field type="email" name="email" class="form-control" value="${member?.email}" placeholder="Please Enter Email"/>
</div>
