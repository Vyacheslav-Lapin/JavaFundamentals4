<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello, World!</h1>

<%--suppress JspAbsolutePathInspection --%>
Go to <a href="/main/">main</a>

<%--suppress CheckEmptyScriptTag --%>
<p/>

<%--suppress JspAbsolutePathInspection --%>
<form action="/ControllerForward" method="post">
    <input type="submit" value="forward()"/><br/>
</form>

<p/>

<%--suppress JspAbsolutePathInspection --%>
<form action="/ControllerSendRedirect" method="post">
    <input type="submit" value="sendRedirect()"/><br/>
</form>

<p/>

<%--suppress JspAbsolutePathInspection --%>
<form action="/SessionController" method="post">
    <input name="paramName" placeholder="paramName"/><br/>
    <input name="paramValue" placeholder="paramValue"/><br/>
    <input type="submit" value="send next HttpRequest"/><br/>
</form>

<p/>

<%--suppress JspAbsolutePathInspection --%>
<form action="/ServletForJspElement" method="post">
    <input type="hidden" name="command" value="naming"/>
    Введите имя:<br/>
    <input name="name" placeholder="name"/>
    <br/> Введите фамилию:<br/>
    <input name="surname" placeholder="surname"/><br/>
    <input type="submit" value="Отправить"/><br/>
</form>

<p/>

<form action="/TagLibController" method="post">
    <input type="submit" value="tap me" /><br />
</form>

</body>
</html>
