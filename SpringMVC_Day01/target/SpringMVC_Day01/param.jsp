<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/10 0010
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<a href="/param/showName?name=tom">点击超链接，获取用户名</a>--%>
<form method="post" action="/param/showTeacher">
    <h2>教师信息</h2>
    姓名：<input type="text" name="name"><br>
    年龄：<input type="text" name="age"><br>
    工作：<input type="text" name="job"><br>
    <h2>List</h2>
    姓名：<input type="text" name="list[0].name"><br>
    分数：<input type="text" name="list[0].score"><br>
    姓名：<input type="text" name="list[1].name"><br>
    分数：<input type="text" name="list[1].score"><br>
    <h3>Map</h3>
    姓名：<input type="text" name="map[0].name"><br>
    分数：<input type="text" name="map[0].score"><br>
    姓名：<input type="text" name="map[1].name"><br>
    分数：<input type="text" name="map[1].score"><br>
    <input name="submit" type="submit" value="提交">
</form>
</body>
</html>
