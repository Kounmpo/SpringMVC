package com.hui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "return-value-string1", method = RequestMethod.POST)
	public String returnValueString1(HttpServletRequest request,
									String name,
									Integer age) {
		System.out.println("name:" + name + " age:" + age);
		request.setAttribute("myName",name);
		request.setAttribute("myAge",age);
		// 完整视图路径，项目中不能有视图解析器
		// 出现404文件[/WEB-INF/view/WEB-INF/view/show.jsp.jsp] 未找到
		// 因为返回完整路径会与视图解析器冲突，暂时的解决方法是将视图解析器删除
		return "/WEB-INF/view/show.jsp";
	}

}
