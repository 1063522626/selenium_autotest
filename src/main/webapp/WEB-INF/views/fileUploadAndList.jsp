<%--
  Created by IntelliJ IDEA.
  User: lubo3
  Date: 2018/2/9
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传和执行</title>
</head>
<body>
<form action="/fileupload" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td><label>文件选择：</label></td>
            <td><input type="file" id="autotestfile" name="autotestfile"></td>
        </tr>
        <tr>
            <td><input type="submit" value="上传文件 "></td>
        </tr>
    </table>
    <div>=====================================================================</div>

</form>

</body>
</html>
