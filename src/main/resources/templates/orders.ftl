<#import "parts/common.ftl" as c>

<@c.page>
    <div class="alert alert-primary" role="alert">
        Список пользователей:
    </div>

    <table class="table table-bordered mt-2">
        <thead>
        <tr>
            <th scope="col">Номер заказа</th>
            <th scope="col">Дата приема</th>
            <th scope="col">Устройство</th>
            <th scope="col">Бренд</th>
            <th scope="col">Модель</th>
            <th scope="col">Фамилия Имя</th>
            <th scope="col">Номер телефона</th>
            <th scope="col">Добавил</th>
            <th scope="col">Active</th>
            <th scope="col">Редактировать</th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
            <tr>
                <td>${order.id}</td>
                <td>${order.firstDate}</td>
                <td>${order.orderDevice}</td>
                <td>${order.orderBrand}</td>
                <td>${order.orderModel}</td>
                <td>${order.clientName}</td>
                <td>${order.clientPhone}</td>
                <td>${order.orderActive}</td>
                <td><a href="/order/${order.id}">Редактировать</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>