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
        <th>购买时间</th>
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
            <td>${item.receivingName}</td>
            <td>${item.receivingAddress}</td>
            <td>${item.receivingPhone}</td>
            <td>
                <c:if test="${item.payState==0}"><a href="${pageContext.request.contextPath}/order/topay?transSerial=${item.transSerial}">支付</a></c:if>
                <c:if test="${item.payState==1}">支付完成</a> <input type="button" value="申请退款" onclick="applyRefund('${item.transSerial}')"> </c:if>
                <c:if test="${item.payState==3}">退款成功</c:if>
                <c:if test="${item.payState==0}"><a href="${pageContext.request.contextPath}/order/cancelorder?transSerial=${item.transSerial}">取消订单</a></c:if>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
<script type="text/javascript">
    function applyRefund(transSerial){
        window.location.href="${pageContext.request.contextPath}/order/applyrefund?transSerial="+transSerial;
    }
</script>
</html>
