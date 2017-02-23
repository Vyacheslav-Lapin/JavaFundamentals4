<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/tags.tld" prefix="mytag"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:useBean id="userbean" type="myapp.tags.JSPSetBean" scope="request"/>

<mytag:jspset set="${userbean}"/>

<br/>

<mytag:bodyjspset num="${userbean.size}">
    ${userbean.element}
</mytag:bodyjspset>

</body>
</html>
