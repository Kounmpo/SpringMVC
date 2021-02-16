package com.hui.controller;

import com.hui.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author huang jiehui
 * @date 2021/2/15 14:27
 */
@Controller
@RequestMapping(value = "hjh03")
public class MyController {
	/**
	 * 逐个接收请求参数
	 * 	要求：处理器方法的形参名和请求中的形参名必须一致
	 * 		 同名的请求参数赋给同名的形参
	 * 框架接收请求参数
	 * 	1.使用request对象接收参数
	 * 		String name = request.getParameter("name");
	 * 		String age = request.getParameter("age");
	 * 	2.springmvc框架通过DispatcherServlet调用MyController中的hello方法
	 * 	  调用方法时，按名称对应，把接收的参数赋值给形参
	 * 	  hello(name,Integer.valueOf(age))
	 * 	  springmvc框架会提供类型转换的功能，能把String转为int long float double等类型
	 * @return ModelAndView
	 */
	@RequestMapping(value = "hello", method = RequestMethod.POST)
	public ModelAndView hello(String name,
							  Integer age) {
		// 可以在方法中直接使用前端传过来的name与age
		ModelAndView mv = new ModelAndView();
		mv.addObject("myName",name);
		mv.addObject("myAge",age);
		mv.setViewName("show");
		return mv;
	}

	/**
	 * 请求中参数名和形参名不一致
	 * @RequestParam：解决请求中参数名与形参名不一致的问题
	 * 属性：
	 * 		1.value：请求中的参数名称,value等于表单中的"name"属性值
	 * 		2.required：一个boolean值 默认是true
	 * 			true表示请求中必须包含参数
	 * 			false表示请求中的参数可为空
	 * 			测试required为false时，直接复制Controller uri到浏览器地址出现
	 * 			Request method 'GET' not supported
	 * 			浏览器默认发送请求默认时是GET方式，但是在Controller中没有对应的方法来处理这个GET方式的请求
	 * 			解决方法：去掉"method = RequestMethod.POST"，这样Controller就能处理GET和POST两种方式的请求
	 * 位置：在处理器方法的形参定义前
	 * @param name
	 * @param age
	 * @return ModelAndView
	 */
	@RequestMapping(value = "receive-parameter")
	public ModelAndView receiveParameter(@RequestParam(value = "r-name" ,required = false) String name,
							  @RequestParam(value = "r-age", required = false) Integer age) {
		System.out.println("name:" + name + " age:" + age);
		// 可以在方法中直接使用前端传过来的name与age
		ModelAndView mv = new ModelAndView();
		mv.addObject("myName",name);
		mv.addObject("myAge",age);
		mv.setViewName("show");
		return mv;
	}

	/**
	 * 处理器方法形参是java对象，这个对象的属性名和请求中的参数名一致
	 * 框架会创建形参的java对象，给属性赋值。请求中的参数是name，框架会调用setName()方法给对象的name属性赋值
	 * @return
	 */
	@RequestMapping(value = "receive-object")
	public ModelAndView receiveObject(Student student) {
		System.out.println("name:" + student.getName() + " age:" + student.getAge());
		// 可以在方法中直接使用前端传过来的name与age
		ModelAndView mv = new ModelAndView();
		mv.addObject("myName",student.getName());
		mv.addObject("myAge",student.getAge());
		mv.addObject("myStudent",student);
		mv.setViewName("show");
		return mv;
	}
}
