<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UseBean demo</title>
</head>
<body>

<jsp:useBean id="naming" class="myapp.model.SimpleBean" />

<jsp:setProperty property="*" name="naming"/>

<jsp:getProperty property="name" name="naming"/>
<jsp:getProperty property="surname" name="naming"/>
<jsp:getProperty property="date" name="naming"/>

<jsp:useBean id="pageDate" class="java.util.Date"/>
<jsp:setProperty name="naming" property="date" value="${pageDate}"/>

<jsp:getProperty property="date" name="naming"/>

${pageScope.naming.name}

</body>
</html>
