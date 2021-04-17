<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>query by id</title>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
</head>
<body>
<form id="productInfo">
    商品编号：<input name="productId" value="${product.productId}" readonly></br>
    商品名称：<input name="productTitle" value="${product.productTitle}" readonly></br>
    商品图片：<input name="productPicture" value="${product.productPicture}" readonly></br>
    原价格：<input name="originPrice" value="${product.originPrice}" readonly></br>
    商家号：<input name="merchantId" value="${product.merchantId}" readonly></br>
    添加日期：<input name="applyDate" value="${product.applyDate}" readonly></br>
    修改日期：<input name="auditDate" value="${product.auditDate}" readonly></br>
    审核状态：<input name="auditState" value="${product.auditState}" readonly></br>
    开始时间：<input name="startTime" value="${product.startTime}" readonly></br>
    结束时间：<input name="endTime" value="${product.endTime}" readonly></br>
    秒杀价格：<input name="secPrice" value="${product.secPrice}" readonly></br>
    商品库存：<input name="productCount" value="${product.productCount}" readonly></br>
    剩余库存：<input name="stockCount" value="${product.stockCount}" readonly></br>
    描述：<input name="description" value="${product.description}" readonly></br>
</form>

</body>
</html>