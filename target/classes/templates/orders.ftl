<#import "parts/common.ftl" as c>

<@c.page>

    <center><h5>Список пользователей: </h5></center>


    <table class="table table-bordered mt-2">
        <thead>
        <tr>
            <th scope="col">Номер заказа</th>
            <th scope="col">Дата приема</th>
            <th scope="col">Дата выдачи</th>
            <th scope="col">Устройство</th>
            <th scope="col">Бренд</th>
            <th scope="col">Модель</th>
            <th scope="col">Комплект</th>
            <th scope="col">Фамилия Имя</th>
            <th scope="col">Номер телефона</th>
            <th scope="col">Неисправность</th>
            <th scope="col">Цена</th>
            <th scope="col">Затраты</th>
            <th scope="col">Гарантия</th>
            <th scope="col">Active</th>
            <th scope="col">Редактировать</th>
        </tr>
        </thead>
        <tbody>
        <#list orders?reverse as order>
            <tr>
                <td>${order.id}</td>
                <td>${order.firstDate!''}</td>
                <td>${order.secondDate!''}</td>
                <td>${order.orderDevice!''}</td>
                <td>${order.orderBrand!''}</td>
                <td>${order.orderModel!''}</td>
                <td>${order.orderComplect!''}</td>
                <td>${order.clientName!''}</td>
                <td>${order.clientPhone!''}</td>
                <td>${order.orderProblem!''}</td>
                <td>${order.orderPrice!''}</td>
                <td>${order.orderExpenses!''}</td>
                <td>${order.orderGaranty!''}</td>
                <td>${order.orderActive!''}</td>
                <td><a href="/order/${order.id}" target="_blank">Редактировать</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>