<html lang="en">
<#include "base.ftl">

<#macro title>Main</#macro>
<#macro header>Main page</#macro>

<#macro content>
    <a href="/logout">Logout</a>
    <br>
    <div>    Hello, ${sessionUser}! Login successful!
        <br>
        Session ID = ${sessionId}
        <br>
        Cookie user = ${cookieUser}
    </div>
    <a href="/user">Check users page!</a>
    <a href="/index">Check index page!</a>
</#macro>
</html>