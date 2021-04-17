<%--
  Created by IntelliJ IDEA.
  User: yatesxiao
  Date: 2021/4/12
  Time: 7:58 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎商家：${merchant.merchantName} </br>

<a href="${pageContext.request.contextPath}/sign/msignup">注册</a>
<a href="${pageContext.request.contextPath}/sign/msignin">登录</a>
<a href="${pageContext.request.contextPath}/sign/msignoff">登出</a>
<a href="${pageContext.request.contextPath}/order/merchantquery">交易列表</a>
</body>
</html>
