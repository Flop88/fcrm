<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#include "parts/security.ftl" >
<@c.page>
    <div>
    </div>
    <div class="container">

<#--        Выводим для клиентов-->

        <#if user?? && !isAdmin>
        <h2>Добро пожаловать, ${name!''}</h2>
            <div class="container">
                <form method="get" action="/" class="form-inline">
                    <label class="col-sm-2 col-form-label"> Введиде номер телефона для проверки статуса ремонта</label>
                    <div class="form-group row">
                        <div class="col-sm-6">
                        <input class="form-control" type="text" name="filterPhone" placeholder="Пример: 89101128799">
                        </div>
                    </div><br>
                    <button class="btn btn-primary ml-2" type="submit">Найти</button>
                </form>
            </div>

        <table class="table table-bordered mt-2">
            <thead>
            <tr>
                <th scope="col">Номер заказа</th>
                <th scope="col">Дата приема</th>
                <th scope="col">Устройство</th>
                <th scope="col">Бренд</th>
                <th scope="col">Модель</th>
                <th scope="col">Неисправность</th>
                <th scope="col">Статус заявки</th>
                <th scope="col">Мастер</th>
            </tr>
            </thead>
            <tbody>
            <#list serviceorders as message>
                <th scope="row">${message.id}</th>
                <td>${message.firstDate}</td>
                <td>${message.orderDevice}</td>
                <td>${message.orderBrand}</td>
                <td>${message.orderModel}</td>
                <td>${message.orderProblem}</td>
                <td>${message.orderActive}</td>
                <td>${message.authorName}</td>
                </tr>
            <#else>
                <No message
            </#list>
            </tbody>
        </table>
    </div>

        </#if>
    <!-- End orders form -->
</@c.page>
