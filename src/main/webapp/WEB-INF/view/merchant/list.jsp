<%--
  Created by IntelliJ IDEA.
  User: yatesxiao
  Date: 2021/2/16
  Time: 9:27 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center;">
    <a href="${pageContext.request.contextPath}/merchant/toinsert">新增商家</a>
</div>
<table border="2">
    <thead>
        <tr>
            <th>商家的姓名</th>
            <th>商家的店铺名称</th>
            <th>商家账号</th>
            <th>商家密码</th>
            <th>商家经营范围</th>
            <th>编辑</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${merchantlist}" var="item">
        <tr>
            <td>${item.merchantName}</td>
            <td>${item.merchantShopname}</td>
            <td>${item.merchantAccount}</td>
            <td>${item.merchantPassword}</td>
            <td>${item.merchantScope}</td>
            <td><a href="${pageContext.request.contextPath}/merchant/querybyid?id=${item.id}">详情</a>|
                <a href="${pageContext.request.contextPath}/merchant/toupdate?id=${item.id}">更新</a>|
                <a href="${pageContext.request.contextPath}/merchant/delete?id=${item.id}">删除</a> </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
