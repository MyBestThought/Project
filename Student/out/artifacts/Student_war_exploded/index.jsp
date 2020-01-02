<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/12 0012
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--<a href="/syste">开始访问</a>--%>
<%--<jsp:forward page="/WEB-INF/views/login.jsp"></jsp:forward>--%>
  <% response.sendRedirect("/system/login");%>
  </body>

</html>
