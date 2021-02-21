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
<form id="productInfo" action="${pageContext.request.contextPath}/product/update">
    <input name="id" value="${product.id}" type="hidden"/>
    <input name="applyDate" value="${product.applyDate}" readonly></br>
    <input name="auditDate" value="${product.auditDate}" readonly></br>
    <input name="merchantId" value="${product.merchantId}" readonly></br>
    商品编号：<input name="productId" value="${product.productId}"></br>
    商品名称：<input name="productTitle" value="${product.productTitle}"></br>
    商品图片：<input name="productPicture" value="${product.productPicture}"></br>
    原价格：<input name="originPrice" value="${product.originPrice}"></br>
    开始时间：<input name="startTimeString" value="${product.startTimeString}"></br>
    结束时间：<input name="endTimeString" value="${product.endTimeString}"></br>
    秒杀价格：<input name="secPrice" value="${product.secPrice}"></br>
    商品库存：<input name="productCount" value="${product.productCount}"></br>
    剩余库存：<input name="stockCount" value="${product.stockCount}"></br>
    描述：<input name="description" value="${product.description}"></br>
    <input type="button" value="提交" onclick="submit()">
</form>

</body>
<script type="text/javascript">
    function submit(){
        $.ajax({
            type:'post',
            data:$("#productInfo").serialize()
        });
    }
</script>
</html>