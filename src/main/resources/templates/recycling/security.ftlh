<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>

    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    mail = user.getEmail()
    userId = user.getUsers_id()
    >
<#else>
    <#assign
    name = "Вы не авторизованы"
    isAdmin = false
    >
</#if>