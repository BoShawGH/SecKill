<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Title</title>
</head>
<body>
欢迎您：${user.userName}
<table>
    <tr>
        <th>流水号</th>
        <th>购买数量</th>
        <th>总额</th>
        <th>购买时间</th>
        <th>收件人</th>
        <th>收件地址</th>
        <th>联系方式</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${orders}" var="item">
        <tr>
            <td>${item.transSerial}</td>
            <td>${item.transQuantity}</td>
            <td>${item.payAmount}</td>
            <td>${item.createTime}</td>
            <td>${item.receivingName}</td>
            <td>${item.receivingAddress}</td>
            <td>${item.receivingPhone}</td>
            <td></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
