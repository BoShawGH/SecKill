
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><html>
<head>
    <title>query all</title>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
</head>
<body>
<div style=" text-align: center;"><a href="${pageContext.request.contextPath}/product/toinsert">申请秒杀商品</a></div>
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
            <th>审核状态</th>
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
        <td>${item.stateString}</td>
        <td>
            <a href="${pageContext.request.contextPath}/product/toupdate?productId=${item.productId}">修改</a>||
            <a href="${pageContext.request.contextPath}/product/delete?productId=${item.productId}">删除</a>||
            <a href="${pageContext.request.contextPath}/product/query?productId=${item.productId}">详情</a>||
            <a href="${pageContext.request.contextPath}/product/toaudit?productId=${item.productId}">审核</a>||
            <a href="${pageContext.request.contextPath}/detail/toinsert?productId=${item.productId}">添加商品详情</a>||
<%--            <input type="button" value="添加商品详情" onclick="addDetail(this, ${item.productId})"></input>--%>
            <a href="${pageContext.request.contextPath}/detail/query?productId=${item.productId}">查看商品详情</a>||
        </td>

    </tr>
</c:forEach>
</table>


</body>
<script>
    function addDetail(obj, productId){
        $.ajax({
            async: false,
            data: {"productId":productId},
            dataType:"json",
            contentType:'application/json;charset=utf-8',
            url: '${pageContext.request.contextPath}/detail/toinsert',
            type:'post',
            success:function(result) {
                if(result != "false"){
                    alert("正在跳转...");
                    location.href="${pageContext.request.contextPath}/detail/insert";
                }else{
                    alert("不能重复添加详细信息");
                }
            }
        });
    }
</script>
</html>