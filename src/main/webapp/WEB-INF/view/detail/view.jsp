<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
</head>
<body>
<form id="detailForm">
    <input name="id" value="${productDetail.id}" type="hidden">
    产品编号：<input name="productId" value="${productDetail.productId}" readonly></br>
    商家编号：<input name="merchantId" value="${productDetail.merchantId}" readonly></br>
    商品名称：<input name="productName" value="${productDetail.productName}" readonly></br>
    商品产地：<input name="productPlace" value="${productDetail.productPlace}" readonly></br>
    商品商标：<input name="brandName" value="${productDetail.brandName}" readonly></br>
    商品重量：<input name="productWeight" value="${productDetail.productWeight}" readonly></br>
    规格与包装：<input name="specification" value="${productDetail.specification}" readonly></br>
    详情图片：<input name="productDetailPicture" value="${productDetail.productDetailPicture}" readonly></br>
</form>
</body>
</html>