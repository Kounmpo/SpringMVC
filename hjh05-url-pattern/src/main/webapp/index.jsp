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
<%--    引入jQuery文件--%>
    <script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
    <form action="/hjh05/url-pattern" method="post">
        姓名:<input type="text" name="name"><br/>
        年龄:<input type="text" name="age"><br/>
        <input type="submit" value="提交参数">
    </form>
    <img src="image/1.jpg" alt="我是一个静态资源,显示异常">
</body>
</html>
