package com.hui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author huang jiehui
 * @date 2021/2/14 18:01
 */
@Controller
@RequestMapping(value = "hjh02")
public class MyController {
	@RequestMapping(value = {"/other"}, method = RequestMethod.GET)
	public ModelAndView other(HttpServletRequest request,
							  HttpServletResponse response,
							  HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg","Hello World!");
		mv.addObject("func","调用other方法");
		mv.addObject("name",request.getParameter("name"));
		mv.setViewName("other");
		return mv;
	}

	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg","Hello World...");
		mv.addObject("func","调用show方法!");
		mv.setViewName("show");
		return mv;
	}
}
