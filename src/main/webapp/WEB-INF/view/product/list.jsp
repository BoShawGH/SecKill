
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html>
<head>
    <title>query all</title>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
</head>
<body>
<div style="text-align: center;"><a href="${pageContext.request.contextPath}/product/toapply">申请秒杀商品</a></div>
<table border="2">
    <thead>
        <tr>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>商家编号</th>
            <th>原价格</th>
            <th>秒杀价格</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>剩余库存</th>
            <th></th>
        </tr>
    </thead>
<c:forEach items="${products}" var="item">
    <tr>
        <td>${item.productId}</td>
        <td>${item.productTitle}</td>
        <td>${item.merchantId}</td>
        <td>${item.originPrice}</td>
        <td>${item.secPrice}</td>
        <td>${item.startTime}</td>
        <td>${item.endTime}</td>
        <td>${item.stockCount}</td>
        <td>
            <a href="${pageContext.request.contextPath}/product/toupdate?id=${item.id}">修改</a>||
            <a href="${pageContext.request.contextPath}/product/delete?id=${item.id}">删除</a>||
            <a href="${pageContext.request.contextPath}/product/querybyid?id=${item.id}">详情</a>
        </td>

    </tr>
<%--    <form id="${item.id}">--%>
<%--        商品编号：<input name="productId" value="${item.productId}" readonly></br>--%>
<%--        商品名称：<input name="productTitle" value="${item.productTitle}" readonly></br>--%>
<%--        商品图片：<input name="productPicture" value="${item.productPicture}" readonly></br>--%>
<%--        原价格：<input name="originPrice" value="${item.originPrice}" readonly></br>--%>
<%--        商家号：<input name="merchantId" value="${item.merchantId}" readonly></br>--%>
<%--        添加日期：<input name="applyDate" value="${item.applyDate}" readonly></br>--%>
<%--        修改日期：<input name="auditDate" value="${item.auditDate}" readonly></br>--%>
<%--        审核状态：<input name="auditState" value="${item.auditState}" readonly></br>--%>
<%--        开始时间：<input name="startTime" value="${item.startTime}" readonly></br>--%>
<%--        结束时间：<input name="endTime" value="${item.endTime}" readonly></br>--%>
<%--        秒杀价格：<input name="secPrice" value="${item.secPrice}" readonly></br>--%>
<%--        商品库存：<input name="productCount" value="${item.productCount}" readonly></br>--%>
<%--        剩余库存：<input name="stockCount" value="${item.stockCount}" readonly></br>--%>
<%--        描述：<input name="description" value="${item.description}" readonly></br>--%>
<%--    </form>--%>
</c:forEach>
</table>


</body>
</html>