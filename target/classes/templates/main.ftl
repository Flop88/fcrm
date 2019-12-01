<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <div>
    </div>
    <div class="container">
        <form method="get" action="/main" class="form-inline">
            <input class="form-control" type="text" name="filter" placeholder="Фамилия Имя">
            <button class="btn btn-primary ml-2" type="submit">Найти</button>
        </form>
    </div>
    <button type="button" class="btn btn-primary mt-3" data-toggle="modal" data-target="#exampleModal">
        Добавить заказ
    </button>
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Добавить заказ</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div>
                        <form method="post">
                            <input class="form-control" type="text" required name="firstDate"
                                   placeholder="Введите дату приема"/> <br/>
                            <input class="form-control" type="text" required name="orderDevice"
                                   placeholder="Тип устройства"/><br/>
                            <input class="form-control" type="text" required name="orderBrand"
                                   placeholder="Бренд"/><br/>
                            <input class="form-control" type="text" required name="orderModel"
                                   placeholder="Модель"/><br/>
                            <input class="form-control" type="text" required name="clientName"
                                   placeholder="Имя и фамилия"/><br/>
                            <input class="form-control" type="text" required name="clientPhone"
                                   placeholder="Номер телефона"/><br/>
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <center>
                                <button class="btn btn-primary" type="submit">Добавить</button>
                            </center>
                        </form>
                        <br/>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="alert alert-primary mt-2" role="alert">
        Список заказов:
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
        </tr>
        </thead>
        <tbody>
        <#list serviceorders as message>
            <tr>
                <th scope="row">${message.id}</th>
                <td>${message.firstDate}</td>
                <td>${message.orderDevice}</td>
                <td>${message.orderBrand}</td>
                <td>${message.orderModel}</td>
                <td>${message.clientName}</td>
                <td>${message.clientPhone}</td>
                <td>${message.authorName}</td>
            </tr>
        <#else>
            <No message
        </#list>
        </tbody>
    </table>
</@c.page>