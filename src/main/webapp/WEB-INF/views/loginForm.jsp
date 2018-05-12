<%--
  Created by IntelliJ IDEA.
  User: lubo3
  Date: 2018/2/8
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="/css/loginForm.css">
</head>
<body id="loginbody">
<form action="login" method="post">
<font color="red">${requestScope.message}</font>
    <table id="login">
        <tr>
            <td class="bc"><label>姓名：</label></td>
            <td><input type="text" id="bname" name="bname"></td>
        </tr>
        <tr>
            <td class="bc"><label>密码：</label></td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录 "></td>
        </tr>
    </table>
</form>
</body>
</html>
