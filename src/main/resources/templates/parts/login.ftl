<#macro login path isRegisterForm>
<form action="${path}" method="post" class="form-signin">
        <h2 class="form-heading"><#if !isRegisterForm>Авторизация<#else>Регистрация</#if></h2><h2 class="form-heading"> </h2>

        <div class="form-group">
            <span>Авторизация</span>

            <input class="form-control mt-2" name="username" required type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>

            <input class="form-control mt-2" name="password" required type="password" class="form-control mt-2" placeholder="Password"/>

            <#if isRegisterForm><input class="form-control mt-2" name="email" required type="email"
                                       class="form-control mt-2" placeholder="some@some.ru"
                                       pattern="/^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/"/></#if>

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