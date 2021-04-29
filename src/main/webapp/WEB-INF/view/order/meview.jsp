<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title>Title</title>
</head>
<body>
欢迎您：${user.userName}
<table>
    <tr>
        <th>流水号</th>
        <th>购买数量</th>
        <th>总额</th>
        <th>订单生成时间</th>
        <th>订单支付时间</th>
        <th>收件人</th>
        <th>收件地址</th>
        <th>联系方式</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${orders}" var="item">
        <tr>
            <td>${item.transSerial}</td>
            <td>${item.transQuantity}</td>
            <td>${item.payAmount}</td>
            <td>${item.createTime}</td>
            <td>
                <c:if test="${item.payState==0}">未支付</c:if>
                <c:if test="${item.payState==1}">${item.payTime}</c:if>
                <c:if test="${item.payState==2}">退款申请中</a></c:if>
                <c:if test="${item.payState==3}">退款成功</c:if>
                <c:if test="${item.payState==4}">退款失败</c:if>
            </td>
            <td>${item.receivingName}</td>
            <td>${item.receivingAddress}</td>
            <td>${item.receivingPhone}</td>
            <td>
                <c:if test="${item.payState==0}"><a href="/order/pay">立即支付</a>｜<a href="${pageContext.request.contextPath}/order/cancelorder?transSerial=${item.transSerial}">取消订单</a></c:if>
                <c:if test="${item.payState==1}"><a href="">申请退款</a></c:if>
                <c:if test="${item.payState==4}"><a href="">申请退款</a></c:if>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
