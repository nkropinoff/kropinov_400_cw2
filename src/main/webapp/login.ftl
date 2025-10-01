<html lang="en">
<#include "base.ftl">

<#macro title>Login</#macro>
<#macro header>Login page</#macro>

<#macro content>
    <h4>Login is working only <strong> from 10.45 to 23.45 </strong> ! </h4>
    <form method="post" action="/login">
        Login:
        <input type="text" name="login" placeholder="type your login here">
        Password:
        <input type="password" name="password">
        <br>
        <input type="submit" value="login">
    </form>
    <br>
    <a href="/sign_up">Firstly here ? Sign up!</a>

</#macro>
</html>