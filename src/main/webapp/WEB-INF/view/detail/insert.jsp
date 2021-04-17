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
<form action="${pageContext.request.contextPath}/detail/insert" id="detailForm">
    产品编号：<input name="productId" value="${productId}" readonly></br>
    商家编号：<input name="merchantId" value="${merchantId}" readonly></br>
    商品名称：<input name="productName" value="${productTitle}"></br>
    商品产地：<input name="productPlace"></br>
    商品商标：<input name="brandName"></br>
    商品重量：<input name="productWeight"></br>
    规格与包装：<input name="specification"></br>
    详情图片：<input name="productDetailPicture"></br>
    <input type="button" value="提交" onclick="submit()">
</form>
</body>
<script type="text/javascript">
    function submit(){
        $.ajax({
            type:'post',
            data:$("#detailForm").serialize(),
            success:function(){
                console.log(data);
            }
        });
    }
</script>
</html>