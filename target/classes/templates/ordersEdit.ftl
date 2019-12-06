<#import "parts/common.ftl" as c>

<@c.page>
    <div class="alert alert-primary" role="alert">
        Редактор заказа:
    </div>
    <form action="/order" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Номер заказа :</label>
        <div class="col-sm-6">
            <input type="text" class="form-control mt-2" value="${order.id}" name="orderId" readonly>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Дата приема :</label>
        <div class="col-sm-6">
            <input type="text" class="form-control mt-2" value="${order.firstDate}" name="firstDate">
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Тип устройства :</label>
        <div class="col-sm-6">
            <input type="text" class="form-control mt-2" value="${order.orderDevice}" name="orderDevice">
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Бренд :</label>
        <div class="col-sm-6">
            <input type="text" class="form-control mt-2" value="${order.orderBrand}" name="orderBrand">
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Модель :</label>
        <div class="col-sm-6">
            <input type="text" class="form-control mt-2" value="${order.orderModel}" name="orderModel">
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Фамилия Имя :</label>
        <div class="col-sm-6">
            <input type="text" class="form-control mt-2" value="${order.clientName}" name="clientName">
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Номер телефона :</label>
        <div class="col-sm-6">
            <input type="text" class="form-control mt-2" value="${order.clientPhone}" name="clientPhone">
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Статус заказа :</label>
        <div class="col-sm-6">
            <input type="text" class="form-control mt-2 mb-2" value="${order.orderActive}" name="orderActive">
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <center>
        <button class="btn btn-primary" type="submit">Сохранить</button>
    </center>
    </form>
</@c.page>