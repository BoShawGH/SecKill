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
<form id="userInfo" action="${pageContext.request.contextPath}/sign/signup">
    用户编号:<input name="userId"></br>
    用户姓名:<input name="userName"></br>
    用户账号:<input name="userAccount"></br>
    用户密码:<input name="userPassword"></br>
    用户性别:<input name="userGender"></br>
    用户年龄:<input name="userAge"></br>
    用户地址:<input name="userAddress"></br>
    用户邮箱:<input name="userEmail"></br>
    <input type="button" value="提交" onclick="submit()">
</form>
</body>
<script type="text/javascript">
    function submit(){
        $.ajax({
            data:$("#userInfo").serialize(),
            type:'post',
            success:function(){
                console.log(data);
            }
        });
    }
</script>
</html>