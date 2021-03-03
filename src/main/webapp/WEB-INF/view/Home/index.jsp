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
成功：${user.userAccount}

<a href="${pageContext.request.contextPath}/sign_up_in/tosignup">注册</a>
<a href="${pageContext.request.contextPath}/sign_up_in/tosignin">登录</a>
<a href="/sign_up_in/exit">退出登录</a>
</body>
</html>