<div class="form-group">
    <label><g:message code="name"/> *</label>
    <g:textField name="name" class="form-control" value="${user?.name}" placeholder="Please Enter Name"/>
</div>

<div class="form-group">
    <label><g:message code="email"/> *</label>
    <g:field type="email" name="email" class="form-control" value="${user?.email}" placeholder="Please Enter Email"/>
</div>
<g:if test="${!edit}">
    <div class="form-group">
        <label><g:message code="password"/> *</label>
        <g:passwordField name="password" class="form-control" value="${user?.password}" placeholder="Please Enter Password"/>
    </div>
</g:if>