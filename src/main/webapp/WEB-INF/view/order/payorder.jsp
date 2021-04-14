<%--
  Created by IntelliJ IDEA.
  User: yatesxiao
  Date: 2021/4/13
  Time: 9:22 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
    <title>Title</title>
</head>
<body>
<form id="orderDetail" action="${pageContext.request.contextPath}/order/payorder">
    商品名称：${product.productTitle} </br>
    购买数量：${num} </br>
    支付总额: ${payAmount}  </br>

    <input type="hidden" name="productId" value="${product.productId}">
    <input type="hidden" name="userId" value="${user.userId}">
    <input type="hidden" name="merchantId" value="${product.merchantId}">
    <input type="hidden" name="payAmount" value="${payAmount}">
    <input type="hidden" name="transQuantity" value="${num}">

    收货人地址:<input type="text" name="receivingAddress"></br>
    收货人电话:<input type="text" name="receivingPhone"></br>
    收货人名称:<input type="text" name="receivingName"></br>
    <input type="button" value="付款" onclick="submit()">
</form>
</body>
<script>
    function submit(){
        $.ajax({
            data:$("#orderDetail").serialize(),
            type:'post'
        })
    }
</script>
</html>
