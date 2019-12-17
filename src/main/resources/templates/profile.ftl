<#include "parts/security.ftl" >
<#import "parts/common.ftl" as c>

<@c.page>
    <div class="container mt-5">
        <form method="post" class="form-signin">
            <h2 class="form-heading">Редактор профиля - ${name}</h2>
            <h2 class="form-heading"></h2>

            <div class="form-group">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Новый пароль :</label>
                    <div class="col-sm-6">
                        <input class="form-control mt-2" name="password" required type="password"
                               class="form-control mt-2"
                               placeholder="Password"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Новый e-mail :</label>
                    <div class="col-sm-6">
                        <input class="form-control mt-2" name="email" required type="email"
                               class="form-control mt-2" placeholder="some@some.ru"
                               value="${email!''}"/>
                    </div>
                </div>

                <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                <button class="btn btn-lg btn-primary btn-block mt-3" type="submit">Сохранить</button>
            </div>
        </form>
    </div>
</@c.page>
