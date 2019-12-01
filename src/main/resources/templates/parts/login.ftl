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
<#macro login path isRegisterForm>
<form action="${path}" method="post" class="form-signin">
        <h2 class="form-heading"><#if !isRegisterForm>Авторизация<#else>Регистрация</#if></h2><h2 class="form-heading"> </h2>

        <div class="form-group">
            <span>Авторизация</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control mt-2" placeholder="Password"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />

            <button class="btn btn-lg btn-primary btn-block mt-3" type="submit"><#if !isRegisterForm>Вход<#else>Зарегистрироваться</#if></button>
            <#if !isRegisterForm><h4 class="text-center"><a href="/registration">Создать аккаунт</a></h4></#if>
        </div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Выйти</button>
    </form>
</#macro>