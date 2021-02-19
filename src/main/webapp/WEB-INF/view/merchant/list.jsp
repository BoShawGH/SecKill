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
<c:forEach items="${merchantlist}" var="item">
    商家的姓名:${item.merchantName },
    商家的店铺名称:${item.merchantShopname },
    商家账号:${item.merchantAccount },
    商家密码:${item.merchantPassword },
    商家经营范围:${item.merchantScope },
    </c:forEach>
</body>
</html>
