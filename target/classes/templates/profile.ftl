<#include "parts/security.ftl" >
<#import "parts/common.ftl" as c>

<@c.page>
<div class="container mt-5">
    <form method="post" class="form-signin">
        <h2 class="form-heading">Редактор профиля -  ${name}</h2>
        <h2 class="form-heading"></h2>

        <div class="form-group">
            <input class="form-control mt-2" name="password" required type="password" class="form-control mt-2"
                   placeholder="Password"/>

            <input class="form-control mt-2" name="email" required type="email"
                   class="form-control mt-2" placeholder="some@some.ru"
                   value="${email!''}"/>

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block mt-3" type="submit">Сохранить</button>
        </div>
    </form>
</div>
</@c.page>
