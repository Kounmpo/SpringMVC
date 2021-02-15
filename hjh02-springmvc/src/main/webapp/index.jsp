<%--
  Created by IntelliJ IDEA.
  User: 15837
  Date: 2021/2/14
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="/hjh02/other">发送一个other的请求</a></p>
<p>
<%--与Controller中方法上的method属性一致 Request method 'GET' not supported--%>
    <form action="/hjh02/show" method="post">
        <input type="submit" value="post请求show.jsp">
    </form>
</p>
<p><a href="/hjh02/show">发送一个show的请求</a></p>
</body>
</html>
