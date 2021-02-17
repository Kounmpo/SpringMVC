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
@RequestMapping(value = "hjh04")
public class MyController {
	/**
	 * 处理器方法返回String--表示逻辑视图名称，需要配置视图解析器
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping(value = "return-value-string", method = RequestMethod.POST)
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
