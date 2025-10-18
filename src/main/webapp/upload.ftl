<#include "base.ftl">

<#macro title>
    Upload
</#macro>

<#macro header></#macro>

<#macro content>
    <p>Upload file:</p>
    <form action="upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <br>
        <input type="submit" value="upload">
    </form>
</#macro>