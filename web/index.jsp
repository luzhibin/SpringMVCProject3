<%--
  Created by IntelliJ IDEA.
  User: 12558
  Date: 06/08/2019
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>INDEX.JSP</title>
  </head>
  <body>
    <h1>SpringMVC传值</h1>
    <a href="${pageContext.request.contextPath}/testModelAndView">使用ModelAndView传值</a>
    <hr>
    <a href="${pageContext.request.contextPath}/testModel">使用Model传值，测试testModel</a>
    <hr>
    <a href="${pageContext.request.contextPath}/testMap">使用Map传值到页面，测试testMap</a>
    <hr>
    <a href="${pageContext.request.contextPath}/testSession">SpringMVC-@SessionAttributes注解session</a>
    <hr>
    <a href="${pageContext.request.contextPath}/testSession2">SpringMVC-@SessionAttribute注解</a>
  </body>
  <hr>
  <form action="${pageContext.request.contextPath}/testModelAttribute">
    名称：<input type="text" name="name"><br>
    价格：<input type="text" name="price"><br>
    <input type="submit" value="提交">
  </form>
</html>
