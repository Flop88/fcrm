<#--<#macro login path>-->
<#--    <form action="${path}" method="post">-->
<#--        <div class="form-group row">-->
<#--            <label class="col-sm-2 col-form-label">Логин :</label>-->
<#--            <div class="col-sm-6">-->
<#--                <input type="text" name="username" class="form-control" placeholder="User name" />-->
<#--            </div>-->
<#--        </div>-->
<#--        <div class="form-group row">-->
<#--            <label class="col-sm-2 col-form-label">Пароль :</label>-->
<#--            <div class="col-sm-6">-->
<#--                <input type="password" name="password" class="form-control" placeholder="Password" />-->
<#--            </div>-->
<#--        </div>-->
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
<#--        <button class="btn btn-primary" type="submit">Войти</button>-->
<#--    </form>-->
<#--</#macro>-->
<#macro login path>
<form action="${path}" method="post" class="form-signin">
        <h2 class="form-heading">Авторизация</h2>

        <div class="form-group">
            <span>Авторизация</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />

            <button class="btn btn-lg btn-primary btn-block" type="submit">Вход</button>
            <h4 class="text-center"><a href="/registration">Создать аккаунт</a></h4>
        </div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Выйти</button>
    </form>
</#macro>