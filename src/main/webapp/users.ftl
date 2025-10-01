<html lang="en">
<#include "base.ftl">

<#macro title>Users</#macro>
<#macro header>Users page</#macro>

<#macro content>
    <a href="/logout">Logout</a>

    <#if users?has_content>
        Таблица рекордов:
        <br>
        Имя Очки
        <br>
        <#list users as u>
            ${u.name} ${u.score}
            <br>
        </#list>
    </#if>

</#macro>
</html>