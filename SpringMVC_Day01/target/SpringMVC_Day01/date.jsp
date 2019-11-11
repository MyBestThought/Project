<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/11 0011
  Time: 07:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/param/testConverter">
    <h2>教师信息</h2>
    姓名：<input type="text" name="name"><br>
    年龄：<input type="text" name="age"><br>
    工作：<input type="text" name="job"><br>
    生日：<input type="text" name="birthday"><br>
    <input name="submit" type="submit" value="提交">
</form>
</body>
</html>
