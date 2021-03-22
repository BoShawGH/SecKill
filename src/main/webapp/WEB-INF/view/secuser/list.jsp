<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center;"><a href="${pageContext.request.contextPath}/user/toinsert">新增用户</a> </div>
<table border="2">
    <thead>
    <tr>
        <th>用户姓名</th>
        <th>用户账号</th>
        <th>用户密码</th>
        <th>用户性别</th>
        <th>用户年龄</th>
        <th>用户地址</th>
        <th>用户邮箱</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="item">
    <tr>
        <td>${item.userName}</td>
        <td>${item.userAccount}</td>
        <td>${item.userPassword}</td>
        <td>${item.userGender}</td>
        <td>${item.userAge}</td>
        <td>${item.userAddress}</td>
        <td>${item.userEmail}</td>
        <td><a href="${pageContext.request.contextPath}/user/querybyid?userId=${item.userId}">详情</a>|
            <a href="${pageContext.request.contextPath}/user/toupdate?userId=${item.userId}">编辑</a>|
            <a href="${pageContext.request.contextPath}/user/delete?userId=${item.userId}">删除</a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
