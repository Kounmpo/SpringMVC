<%--
  Created by IntelliJ IDEA.
  User: 15837
  Date: 2021/2/15
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>提交参数给Controller</p>
    <form action="/hjh03/hello" method="post">
        姓名:<input type="text" name="name"/><br/>
        年龄:<input type="text" name="age"/><br/>
        <input type="submit" value="提交参数"/><br/>
    </form>
</body>
</html>
