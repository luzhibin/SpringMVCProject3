<%--
  Created by IntelliJ IDEA.
  User: 12558
  Date: 06/08/2019
  Time: 22:46mdTemplates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RESULT.JSP</title>
</head>
<body>
    <h1>result.jsp</h1>
    <h2>---${requestScope.name}</h2><br>
    <hr>
    <h2>${goods.name}----------${goods.price}</h2><br>
    <h3>${requestScope.string}</h3>
    <h3>${requestScope.Dog}</h3>
    <hr>
    <h2>Map传值到页面-----${requestScope.key1}------${requestScope.key2}</h2>
</body>
</html>
