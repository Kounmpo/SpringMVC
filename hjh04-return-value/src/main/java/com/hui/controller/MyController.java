package com.hui.controller;

import com.hui.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

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
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "return-value-string", method = RequestMethod.POST)
	public String returnValueString(HttpServletRequest request,
									String name,
									Integer age) {
		System.out.println("name:" + name + " age:" + age);
		// show逻辑视图名称，项目中配置了视图解析器
		// 框架对视图执行forward转发操作
		// 此时show.jsp是没有数据的，可以手动向其添加数据
		request.setAttribute("myName",name);
		request.setAttribute("myAge",age);
		return "show";
	}
}
