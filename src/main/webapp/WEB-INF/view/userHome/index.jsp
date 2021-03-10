<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>query by id</title>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
</head>

<body>
成功：${user.userAccount}
<a href="${pageContext.request.contextPath}/sign_up_in/tosignup">注册</a>
<a href="${pageContext.request.contextPath}/sign_up_in/tosignin">登录</a>
<a href="/sign_up_in/exit">退出登录</a>

<table border="2">
    <thead>
    <tr>
        <th>商品名</th>
        <th>图片地址</th>
        <th>原价格</th>
        <th>秒杀价格</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${products}" var="item">
        <tr>
            <td>${item.productTitle}</td>
            <td>${item.productPicture}</td>
            <td>${item.originPrice}</td>
            <td>${item.secPrice}</td>
            <td>${item.startTime}</td>
            <td>${item.endTime}</td>
            <td><a href="">查看</a> </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>