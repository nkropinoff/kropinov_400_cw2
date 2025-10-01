<html lang="en">
<#include "base.ftl">

<#macro title>Sign Up</#macro>
<#macro header>Sign Up Page</#macro>

<#macro content>
    <form method="post" action="/sign_up">
        Input your <strong>login</strong> and <strong>password</strong> for registration.
        <br>
        <em>Login:</em>
        <input type="text" name="login" placeholder="type your login here">
        <em>Password:</em>
        <input type="password" name="password">
        <br>
        <input type="submit" value="sign up">
    </form>
</#macro>
</html>