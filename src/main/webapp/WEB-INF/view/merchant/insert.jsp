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
<form action="${pageContext.request.contextPath}/merchant/insert" id="merchantForm">
    商家编号:<input name="merchantId"></br>
    商家的姓名:<input name="merchantName"></br>
    商家的店铺名称:<input name="merchantShopname"></br>
    商家账号:<input name="merchantAccount"></br>
    商家密码:<input name="merchantPassword"></br>
    商家经营范围:<input name="merchantScope"></br>
    <input type="button" value="提交" onclick="submit()">
</form>
</body>
<script type="text/javascript">
    function submit(){
        $.ajax({
            type:'post',
            data:$("#merchantForm").serialize(),
            success:function(){
                console.log(data);
            }
        });
    }
</script>
</html>