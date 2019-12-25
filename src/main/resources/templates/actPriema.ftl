<#import "parts/acts.ftl" as c>
<@c.page>
        <div class="image">
                <img src="https://psv4.userapi.com/c856420/u257411628/docs/d17/a0ac122e1700/actPriema.jpg"> <!--  Временно на серверах ВК-->
                <h2 id="id">${act.id}</h2>
                <p id="firstDate">${act.firstDate}</p>
                <p id="clientName">${act.clientName}</p>
                <p id="clientPhone">${act.clientPhone}</p>
                <p id="orderBrand">${act.orderDevice} ${act.orderBrand} ${act.orderModel}</p>
                <p id="orderComplect">${act.orderComplect}</p>
                <p id="orderVid">Разбит тачскрин</p>

                <h1 id="orderProblem">${act.orderProblem}</h1>


        </div>
</@c.page>