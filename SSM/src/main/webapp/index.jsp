<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/14 0014
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/account/searchAll">查找所有</a>

<form action="/account/saveAccount" method="post">
    姓名：<input type="text" name="name"><br>
    金额：<input type="text" name="money"><br>
    <input type="submit" value="SUBMIT">
</form>
</body>
</html>
