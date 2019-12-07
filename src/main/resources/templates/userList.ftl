<#import "parts/common.ftl" as c>

<@c.page>
    <div class="alert alert-danger" role="alert">
        <center>В кассе - 0р </center>
    </div>
    <div class="alert alert-primary" role="alert">
        Список пользователей:
    </div>

    <table class="table table-bordered mt-2">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Role</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">Редактировать</a> /
                    <a href="#">Удалить</a> </td>
            </tr>
        </#list>
        </tbody>
    </table>
    <hr>
    <a href="/order">Полный список заказов</a>
</@c.page>