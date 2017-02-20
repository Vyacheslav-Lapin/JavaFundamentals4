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

    <form action="/ControllerForward" method="post">
        <input type="submit" value="forward()"/><br/>
    </form>

    <br/>

    <form action="/ControllerSendRedirect" method="post">
        <input type="submit" value="sendRedirect()"/><br/>
    </form>

    <form action="/SessionController" method="post">
        <input name="paramname" value="" placeholder="paramvalue"/> <br/>
        <input name="paramvalue" value="" placeholder="paramvalue"/> <br/>
        <input type="submit" value="send next HttpRequest"/><br />
    </form>
</body>
</html>
