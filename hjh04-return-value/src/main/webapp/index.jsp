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
</head>
<body>
    <p>处理器方法返回String</p>
    <p>
        <form action="/hjh04/return-value-string" method="post">
            姓名:<input type="text" name="name"/><br/>
            年龄:<input type="text" name="age"/><br/>
            <input type="submit" value="提交参数"/><br/>
        </form>
    </p>

    <p>处理器方法返回String--视图完整路径</p>
    <p>
    <form action="/hjh04/return-value-string1" method="post">
        姓名:<input type="text" name="name"/><br/>
        年龄:<input type="text" name="age"/><br/>
        <input type="submit" value="提交参数"/><br/>
    </form>
    </p>
    <p>
        <button id="btn">发起ajax请求</button>
    </p>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#btn").click(function () {
                alert("click button");
            });
        });
    </script>
</body>
</html>
