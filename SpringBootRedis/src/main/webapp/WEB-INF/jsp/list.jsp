<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/12
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%--Idea下生成的JSP版本貌似并不支持el表达式，网上查了一下el表达式只有Servlet 2.4 /JSP 2.0版本下才有用,
如果在别的版本xia使用el表达式只要在jsp文件的开头写上如下的代码:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="openAdd">增加</a></p>
<center>
    <table width="50%" border="1" cellspacing="0" bordercolor="blue">
        <tr>
        <th >编号</th>
        <th >姓名</th>
        <th >性别</th>
        <th width="100">操作</th>
        </tr>
        <c:forEach items="${userList}" var="u">
            <tr>
                <td><c:out value="${u.id}"></c:out></td>
                <td><c:out value="${u.name}"></c:out></td>
                <td><c:out value="${u.sex}"></c:out></td>
                <td>
                    <a href="getById?id=${u.id}">修改 </a>
                    <a href="delete?id=${u.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
