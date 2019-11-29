<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <div>
        <@l.logout />
        <span><a href="/user">User list</a></span>
    </div>
    <div>
        <form method="post">
            <input type="text" name="firstDate" placeholder="Введите дату приема"/> <br/>
            <input type="text" name="orderDevice" placeholder="Тип устройства"/><br/>
            <input type="text" name="orderBrand" placeholder="Бренд"/><br/>
            <input type="text" name="orderModel" placeholder="Модель"/><br/>
            <input type="text" name="clientName" placeholder="Имя и фамилия"/><br/>
            <input type="text" name="clientPhone" placeholder="Номер телефона"/><br/>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
        <br/>
        <form method="get" action="/main">
            <input type="text" name="filter" >
            <button type="submit">Найти</button>
        </form>
    </div>
    <div>Заказы</div>
    <#list serviceorders as message>
        <div>
            <b>${message.id}</b>
            <span>${message.firstDate}</span>
            <span>${message.orderDevice}</span>
            <span>${message.orderBrand}</span>
            <span>${message.orderModel}</span>
            <span>${message.clientName}</span>
            <span>${message.clientPhone}</span>
            <strong>${message.authorName}</strong>
        </div>
    <#else>
        No message
    </#list>
</@c.page>