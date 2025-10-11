<html lang="en">

<head>
    <meta charset="UTF-8">
    <title><@title></@title></title>

    <#if .namespace.additionalHead??>
        <@additionalHead></@additionalHead>
    </#if>
</head>

<body>
<div id="header">
    <h3><@header></@header></h3>
</div>

<div id="content">
    <div class="content">
        <@content></@content>
    </div>
</div>
</body>

</html>