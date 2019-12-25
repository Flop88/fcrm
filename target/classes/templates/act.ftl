<#import "parts/common.ftl" as c>

<@c.page>

    <center><h5>Акты для печати: </h5></center>


    <table class="table table-bordered mt-2">
        <thead>
        <tr>
            <th scope="col">Номер заказа</th>
            <th scope="col">Дата приема</th>
            <th scope="col">Фамилия Имя</th>
            <th scope="col">Номер телефона</th>
            <th scope="col">Цена</th>
            <th scope="col">Active</th>
            <th scope="col">Редактировать</th>
        </tr>
        </thead>
        <tbody>
        <#list acts?reverse as act>
            <tr>
                <td>${act.id}</td>
                <td>${act.firstDate!''}</td>
                <td>${act.clientName!''}</td>
                <td>${act.clientPhone!''}</td>
                <td>${act.orderPrice!''}</td>
                <td>${act.orderActive!''}</td>
                <td>vidachi
                    <a href="/act/priem/${act.id}">Акт приема</a>
                    <a href="/act/vidachi/${act.id}">Акт выдачи</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>