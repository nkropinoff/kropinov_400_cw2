<html lang="en">
<#include "base.ftl">

<#macro title>Sign Up</#macro>
<#macro header>Sign Up Page</#macro>
<#macro additionalHead>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css">

    <script>
        $(document).on("change", "#login-input", function() {
            console.log("debug: login already exist");

            $.get("/check/login?login=" + $("#login-input").val(), function (response) {
                $("#login-unique-check").text(response)
                if (response) {
                    $("#submit-btn").prop("disabled", true);
                } else {
                    $("#submit-btn").prop("disabled", false);
                }
            })
        })
    </script>
</#macro>



<#macro content>
    <form method="post" action="/sign_up">
        Input your <strong>login</strong> and <strong>password</strong> for registration.
        <br>
        <div class="my-2">
            <em>Login:</em>
            <input type="text" name="login" placeholder="type your login here" id="login-input">
        </div>

        <div>
            <p id="login-unique-check" style="color: red"></p>
        </div>

        <div class="my-2">
            <em>Password:</em>
            <input type="password" name="password">
        </div>
        <div class="my-2">
            <em>Name:</em>
            <input type="text" name="name" placeholder="type your name here">
        </div>
        <div class="my-2">
            <em>Lastname:</em>
            <input type="text" name="lastname" placeholder="type your lastname here">
        </div>
        <br>
        <input type="submit" value="sign up" id="submit-btn">
    </form>
</#macro>
</html>