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
    <title>修改</title>
</head>
<body>
    <form action="update" method="post">
        姓名：<input type="text" name="name" value="${user.name}"><br>
        性别：男<input type="radio" <c:if test="${user.sex}=='男'"> checked="checked"</c:if> name="sex" value="男">
        女<input type="radio" <c:if test="${user.sex}=='女'"> checked="checked"</c:if> name="sex" value="女"><br>
        <input type="hidden" name="id" value="${user.id}">
        <input type="submit" value="提交">
    </form>
</body>
</html>
