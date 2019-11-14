<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/14 0014
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hello
<c:forEach var="account" items="${accounts}">
    ${account.name}
</c:forEach>
</body>
</html>
