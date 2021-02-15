package com.hui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

}
