hjh04-return-value:处理器方法的返回值表示请求的处理结果
    ModelAndView：有数据和视图，对视图执行forward
    String：表示视图，可以是逻辑名称，也可以是完整视图路径
    void：不能表示数据，也不能表示视图
        在处理ajax请求的时候，可以使用void返回值。通过HttpServletResponse传递数据，响应ajax请求
        ajax请求服务端返回的就是数据，和视图无关
    Object：处理器的方法也可以返回Object对象，这个Object对象可以是Integer、String、自定义对象、Map、List等。
    但是返回的对象不是作为逻辑视图出现的，而是作为直接在页面显示的数据出现的
           返回对象，需要使用@ResponeBody注解，将转换后的JSON数据放入到响应体中。
           现在做ajax，主要使用json的数据格式。
           实现步骤：
            1.加入处理json的工具库的依赖，SpringMVC默认使用的是jackson
            2.在SpringMVC配置文件中加入<mvc:annotation-driven>注解驱动
              json = om.writeValueAsString(student);
            3.在处理器方法体上加入@ResponseBody注解
              response.setContentType("application/json;charset=utf-8");
              PrintWriter pw = response.getWriter();
              pw.println(json);
              pw.flush();
              pw.close();
           SpringMVC处理器方法返回Object，可以转化为json输出到浏览器，响应ajax的内部原理
            1.<mvc:annotation-driven>注解驱动
                注解驱动实现的功能是：完成java对象到json、xml、text、二进制等数据格式的转换。
                HttpMessageConverter接口：消息转换器。这个接口定义了java对象转换为json、xml等格式的方法。
                这个接口有很多的实现类，这些类完成了java对象到json、xml、text等数据格式的转换
