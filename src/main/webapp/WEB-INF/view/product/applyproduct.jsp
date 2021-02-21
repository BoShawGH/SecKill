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
<form id="productInfo" action="${pageContext.request.contextPath}/product/applyproduct">
    商品编号：<input name="productId"></br>
    商品名称：<input name="productTitle"></br>
    商品图片：<input name="productPicture"></br>
    原价格：<input name="originPrice"></br>
    商家号：<input name="merchantId"></br>
    开始时间：<input name="startTimeString"></br>
    结束时间：<input name="endTimeString"></br>
    秒杀价格：<input name="secPrice"></br>
    商品库存：<input name="productCount"></br>
    剩余库存：<input name="stockCount"></br>
    描述：<input name="description"></br>
    <input type="button" value="提交" onclick="submit(this)">
</form>

</body>
<script type="text/javascript">
    // function submit(){
    //     $.ajax({
    //         type:'post',
    //         data:$("#productInfo").serialize(),
    //         success:function(){
    //             console.log(data);
    //         }
    //     });
    // }
    function submit(obj){
        obj.parent.sumbit();
    }
</script>
</html>