<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/12 0012
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h2>传统方式的文件上传</h2>
<form action="/file/uploadFile" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"><br>
    <input type="submit" value="点击上传">
</form>
<h2>SpringMVC的文件上传</h2>
<form action="/file/uploadFileBySpringMVC" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="uploads"><br>
    <input type="submit" value="点击上传">
</form>
</body>
</html>
