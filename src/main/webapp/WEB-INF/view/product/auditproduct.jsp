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
<form id="productInfo" action="${pageContext.request.contextPath}/product/updatestate">
    <input name="id" value="${product.id}" type="hidden"/>
    <input name="applyDate" value="${product.applyDate}" type="hidden">
    <input name="auditDate" value="${product.auditDate}" type="hidden">
    <input name="merchantId" value="${product.merchantId}" type="hidden">
    <table>
    <thead>
    <tr>
        <th>商品编号</th>
        <th>商品名称</th>
        <th>商品图片</th>
        <th>商家编号</th>
        <th>原价格</th>
        <th>秒杀价格</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>商品数量</th>
        <th>剩余库存</th>
        <th>描述</th>
        <th>审核结果</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><input name="productId" value="${product.productId}" readonly></td>
        <td><input name="productTitle" value="${product.productTitle}" readonly></td>
        <td><input name="productPicture" value="${product.productPicture}" readonly></td>
        <td><input name="merchantId" value="${product.merchantId}" readonly></td>
        <td><input name="originPrice" value="${product.originPrice}" readonly></td>
        <td><input name="secPrice" value="${product.secPrice}" readonly></td>
        <td><input name="startTime" value="${product.startTimeString}" readonly></td>
        <td><input name="endTime" value="${product.endTimeString}" readonly></td>
        <td><input name="productCount" value="${product.productCount}" readonly></td>
        <td><input name="stockCount" value="${product.stockCount}" readonly></td>
        <td><input name="description" value="${product.description}" readonly></td>
        <td>
            <input type="radio" name="state" value="2">审核通过</input></br>
            <input type="radio" name="state" value="3">审核不通过</input>
        </td>
        <td>
            <input type="button" value="提交" onclick="submit()">
        </td>
    </tr>
    </tbody>
    </table>
<%--    商品编号：<input name="productId" value="${product.productId}"></br>--%>
<%--    商品名称：<input name="productTitle" value="${product.productTitle}">--%>
<%--    商品图片：<input name="productPicture" value="${product.productPicture}">--%>
<%--    原价格：<input name="originPrice" value="${product.originPrice}">--%>
<%--    开始时间：<input name="startTime" value="${startTimeString}">--%>
<%--    结束时间：<input name="endTime" value="${endTimeString}">--%>
<%--    秒杀价格：<input name="secPrice" value="${product.secPrice}">--%>
<%--    商品库存：<input name="productCount" value="${product.productCount}">--%>
<%--    剩余库存：<input name="stockCount" value="${product.stockCount}">--%>
<%--    描述：<input name="description" value="${product.description}">--%>
<%--    审核通过:--%>
<%--    <input type="button" value="提交" onclick="submit()">--%>
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