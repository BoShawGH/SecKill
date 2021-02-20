<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${users}" var="item">
    用户姓名:${item.userName}
    用户账号:${item.userAccount}
    用户密码:${item.userPassword}
    用户性别:${item.userGender}
    用户年龄:${item.userAge}
    用户地址:${item.userAddress}
    用户邮箱:${item.userEmail}
</c:forEach>
</body>
</html>
