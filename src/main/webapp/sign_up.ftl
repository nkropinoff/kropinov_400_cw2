<html lang="en">
<#include "base.ftl">

<#macro title>Sign Up</#macro>
<#macro header>Sign Up Page</#macro>

<#macro content>
    <form method="post" action="/sign_up">
        Input your <strong>login</strong> and <strong>password</strong> for registration.
        <br>
        <div>
            <em>Login:</em>
            <input type="text" name="login" placeholder="type your login here">
        </div>
        <div>
            <em>Password:</em>
            <input type="password" name="password">
        </div>
        <div>
            <em>Name:</em>
            <input type="text" name="name" placeholder="type your name here">
        </div>
        <div>
            <em>Lastname:</em>
            <input type="text" name="lastname" placeholder="type your lastname here">
        </div>
        <br>
        <input type="submit" value="sign up">
    </form>
</#macro>
</html>