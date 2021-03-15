<%--
  Created by IntelliJ IDEA.
  User: yatesxiao
  Date: 2021/3/15
  Time: 9:26 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="">
        <input type="text" name="">
        <table border="1">
            <tr>
                <th>商品名</th>
                <th>商品图片</th>
                <th>秒杀价格</th>
                <th>原价格</th>
                <th>开始时间</th>
                <th>结束时间</th>
                <th>商品数量</th>
                <th>库存</th>
                <th>简介</th>
            </tr>
            <tr>
                <td>${product.productTitle}</td>
                <td>${product.productPicture}</td>
                <td>${product.secPrice}</td>
                <td>${product.originPrice}</td>
                <td>${product.startTime}</td>
                <td>${product.endTime}</td>
                <td>${product.productCount}</td>
                <td>${product.stockCount}</td>
                <td>${product.description}</td>
            </tr>
        </table>

        <table border="1">
            <tr>
                <th>商品产地</th>
                <th>商品名称</th>
                <th>商标</th>
                <th>商品重量</th>
                <th>规格与包装</th>
                <th>商品详情图片</th>
            </tr>
            <tr>
                <td>${productDetail.productPlace}</td>
                <td>${productDetail.productName}</td>
                <td>${productDetail.brandName}</td>
                <td>${productDetail.productWeight}</td>
                <td>${productDetail.specification}</td>
                <td>${productDetail.productDetailPicture}</td>
            </tr>
        </table>
    </form>
</body>
</html>
