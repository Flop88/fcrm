<#import "parts/common.ftl" as c>

<@c.page>
    <div class="container mt-5">
        <div class="row">
            <center><h5>Статистика по заказам</h5></center><br>
        </div>
        <form>
            <span>Всего заработано - ${money.getSum()!''} руб</span>
        </form>
    </div>
</@c.page>