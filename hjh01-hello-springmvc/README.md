第一个springmvc项目
需求:用户在页面发起一个请求，请求交给springmvc控制器对象，并显示请求的处理结果
实现步骤：
1.新建web maven项目
2.加入依赖
  (1)spring-webmvc依赖，间接的把spring的依赖加入到项目中
  (2)jsp，servlet依赖
3.重点：在web.xml中注册springmvc的核心对象DispatcherServlet
  (1)修改web.xml文件的版本号，删除原来的web.xml文件，在project structure中新增web.xml
  (2)DispatcherServlet叫做中央调度器，是一个Servlet，他的父类是继承HttpServlet
  (3)DispatcherServlet也叫做前端控制器(front controller)
  (4)DispatcherServlet负责接受用户提交的请求，调用其他的控制器对象，并把请求处理的结果显示给用户
4.创建一个发送请求的页面，index.jsp
5.创建控制器类
  (1)在类的上面加入Controller注解，创建对象，并放入到springmvc容器中
  (2)在类的方法上加上@RequestMapping注解
6.创建一个作为结果的jsp，显示请求的处理结果
7.创建springmvc的配置文件(与spring的配置文件一样)
  (1)声明主键扫描器，指定@Controller注解所在的包名
  (2)声明视图解析器，帮助处理视图