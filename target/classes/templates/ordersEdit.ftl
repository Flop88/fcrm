<#import "parts/common.ftl" as c>

<@c.page>
    <div class="alert alert-primary" role="alert">
        Редактор заказа:
    </div>
    <form action="/order" method="post">
        <div class="col">
            <center><h5>Добавление заказа</h5></center>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Номер заказа :</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control mt-2" value="${order.id}" name="orderId" readonly>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Дата приема :</label>
                <div class="col-sm-6">
                    <input type="date" class="form-control mt-2" value="${order.firstDate}" name="firstDate">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Тип устройства :</label>
                <div class="col-sm-6">
                    <#--            <input type="text" class="form-control mt-2" value="${order.orderDevice}" name="orderDevice">-->
                    <div class="input-group">
                        <select class="custom-select" value="${order.orderDevice}" name="orderDevice">
                            <option value="Телефон">Телефон</option>
                            <option value="Планшет">Планшет</option>
                            <option value="Ноутбук">Ноутбук</option>
                            <option value="ПК">ПК</option>
                            <option value="Моноблок">Моноблок</option>
                            <option value="Другое">Другое</option>
                        </select>
                    </div>
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
                <label class="col-sm-2 col-form-label">Неисправность:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control mt-2" value="${order.orderProblem}" name="orderProblem">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Комплект :</label>
                <div class="col-sm-6">
                    <select class="custom-select" value="${order.orderComplect}" name="orderComplect">
                        <option selected>Без ЗУ</option>
                        <option value="С ЗУ">С ЗУ</option>
                        <option value="Без дисплейного модуля">Без дисплейного модуля</option>
                        <option value="Без ЗУ, сумка<">Без ЗУ, сумка</option>
                        <option value="С ЗУ, сумка<">С ЗУ, сумка</option>
                        <option value="Чехол">Чехол</option>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Комментарий :</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control mt-2" value="${order.orderComment}" name="orderComment">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Статус заказа :</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control mt-2 mb-2" value="${order.orderActive}" name="orderActive">
                </div>
            </div>

            <!-- Второй этап заполнения -->

        </div>
        <div class="col">
            <center><h5> Выполненные услуги:</h5></center>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Выполненные услуги :</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control mt-2" value="${order.orderServices!''}" name="orderServices">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Цена :</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control mt-2" value="${order.orderPrice!''}" name="orderPrice">

                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Затраты :</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control mt-2" value="${order.orderExpenses!''}"
                           name="orderExpenses">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Дата выдачи :</label>
                <div class="col-sm-6">
                    <input type="date" class="form-control mt-2" value="${order.secondDate!''}"
                           name="secondDate">
                </div>
            </div>


            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Гарантия :</label>
                <div class="col-sm-6">
                    <div class="input-group">
                        <select class="custom-select mt-2" value="${order.orderGaranty!''}" name="orderGaranty">
                            <option selected>Гарантия</option>
                            <option value="0">Без гарантии</option>
                            <option value="14">14 дней</option>
                            <option value="30">30 дней</option>
                            <option value="60">60 дней</option>
                            <option value="90">90 дней</option>
                        </select>
                    </div>
                </div>
            </div>

        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <center>
            <button class="btn btn-primary" type="submit">Сохранить</button>
        </center>
        </div>
    </form>
</@c.page>