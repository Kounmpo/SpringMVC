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
    <p>使用注解驱动返回json字符串</p>
    <p>
    <form action="/hjh04/return-object-json" method="post">
        姓名:<input type="text" name="name"/><br/>
        年龄:<input type="text" name="age"/><br/>
        <input type="submit" value="提交参数"/><br/>
    </form>
    </p>
    <p>
        <button id="btn1">ajax发起请求1</button>
    </p>
    <p>
        <button id="btn2">传送json数组</button>
    </p>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">
        $(function (){
            $("#btn").click(function () {
                // 测试jQuery
                // alert("click button");
                $.ajax({
                    url:"hjh04/return-void-ajax",
                    data:{
                      name:"James",
                      age:23
                    },
                    type:"POST",
                    // 客户端希望得到json格式的数据
                    dataType:"json",
                    success:function(result){
                        // result就是服务器返回的json结果，是服务器传回的处理后的json字符串
                        // 当jquery拿到这个result之后。会将其转化为一个json object 赋值给形参result
                        //alert(result);
                      alert("name:" + result.name + " age:" + result.age);
                    }
                });
            });
        });

        $("#btn1").click(function () {
            $.ajax({
                url: "hjh04/student-json-object",
                data: {
                    name: "James",
                    age:23
                },
                type: "POST",
                success(result){
                    alert("name:" + result.name + " age:" + result.age);
                }
            });
        });
        $("#btn2").click(function (){
            $.ajax({
                url:"hjh04/student-json-List",
                data:{
                  name:"Harden",
                  age:13
                },
                type:"POST",
                success(result){
                    $.each(result,function (i,v) {
                        alert("name:" + v.name + " age:" + v.age);
                    });
                }
            });
        });
    </script>
</body>
</html>
