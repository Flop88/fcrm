<#import "parts/common.ftl" as c>

<@c.page>
    <div class="alert alert-primary" role="alert">
    Редактор пользователя:
    </div>
    <form action="/user" method="post">
        <div class="form-group">
        <input class="form-control" type="text" name="username" value="${user.username}">
        <#list roles as role>
            <div>
                <label class="ml-4"><input class="form-check-input" type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button class="btn btn-primary" type="submit">Save</button>
        </div>
    </form>
</@c.page>