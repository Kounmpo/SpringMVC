package com.hui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author huang jiehui
 * @date 2021/2/9 11:07
 * 创建处理器对象，放在springmvc容器中
 * @Controller(value = "helloController1")
 * 如果容器中有重名得Bean,可以通过指定value来解决
 * 一般是不写的
 */
@SuppressWarnings("all")
@Controller
public class HelloController {
	/**
	 * 处理用户提交的请求，springmvc是使用方法来处理的
	 * 方法是自定义的，可以有多种返回值，多种参数，方法2名称自定义
	 * 使用hello方法来处理hello.do的请求
	 * @RequstMapping 请求映射，作用是把一个请求地址和一个方法绑定在一起
	 * 	属性：
	 * 		1.value:string[]类型，用来表示请求的uri地址，value值是唯一的。使用时推荐地址以“/”
	 * 		2.value的值可以是数组，可以将多个请求使用一个方法来处理
	 * 	位置：
	 * 		1.在方法的上面
	 * 		2.在类的上面
	 * 	说明：使用RequestMapping修饰的方法叫做处理器方法或者控制器方法
	 * 		使用该注解修饰的方法可以处理请求，类似servlet的doGet和doPost
	 * @return ModelAndView 表示本次处理的结果
	 *  Model:数据，请求处理完后，要显示给用户的数据
	 *  View:视图，比如jsp、html等
	 */
	@RequestMapping(value = {"/hello.do","/other.do"})
	public ModelAndView hello() {
		//处理hello.do的请求
		ModelAndView mv = new ModelAndView();
		// 添加数据,使用框架在请求得最后把数据放到request作用域中
		// request.setAttribute("msg","Hello World!")
		mv.addObject("msg","Hello World!");
		mv.addObject("func","调用hello方法");
		// 指定视图，指定视图的完整路径
		// 框架对视图执行的forward方法,request.getRequestDispatcher("/show.html").forward(...);
		// mv.setViewName("/WEB-INF/view/show.jsp");

		// 当配置了视图解析器之后可以通过逻辑名称（文件名）指定视图
		// 框架会使用视图解析器的前缀 + 文件名 + 后缀来组成完整路径，就是字符串连接操作
		mv.setViewName("show");
		return mv;
	}

	@RequestMapping(value = "/hello2")
	public ModelAndView hello2() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg","Hello World...");
		mv.addObject("func","调用hello2方法!");
		mv.setViewName("other");
		return mv;
	}
}
