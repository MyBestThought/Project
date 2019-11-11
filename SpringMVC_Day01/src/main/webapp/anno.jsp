<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/11 0011
  Time: 08:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/anno/testRequestParam?name=tom">点击测试RequestParam</a>
<b></b>
<form method="post" action="/anno/testRequestBody">
    姓名：<input type="text" name="name"><br>
    年龄：<input type="text" name="age"><br>
    工作：<input type="text" name="job"><br>
    <input name="submit" type="submit" value="提交">
</form>
<a href="/anno/testPathVariable/10">点击测试PathVariable</a><br>
<a href="/anno/testRequestHeader">点击测试RequestHeader</a><br>
<a href="/anno/testCookieValue">点击测试CookieValue</a><br>

<form method="post" action="/anno/testModelAttribute">
    姓名：<input type="text" name="uname"><br>
    密码：<input type="text" name="password"><br>
    <input name="submit" type="submit" value="提交">
</form>
</body>
</html>
