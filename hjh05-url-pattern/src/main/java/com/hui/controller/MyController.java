package com.hui.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author huang jiehui
 * @date 2021/2/15 14:27
 */
@Controller
@RequestMapping(value = "hjh05")
public class MyController {
	@RequestMapping(value = "/url-pattern")
	public ModelAndView doUrlPattern(String name,
									 Integer age) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name",name);
		mv.addObject("age",age);
		mv.setViewName("show");
		return mv;
	}
}
