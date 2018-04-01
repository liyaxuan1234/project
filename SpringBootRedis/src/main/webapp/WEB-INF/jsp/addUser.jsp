<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/12
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>增加</title>
</head>
<form action="userAdd" method="post">
    姓名：<input type="text" name="name" id="name"><br>
    性别：<input type="text" name="sex" id="sex"><br>
  <input type="submit" value="增加">
</form>
<body>

</body>
</html>
