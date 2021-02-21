package com.hui.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hui.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

	/**
	 * 处理方法返回void,响应ajax请求
	 * 手工实现响应ajax请求返回json数据，代码出现重复：java对象转成json对象;通过HttpServletResponse传递json数据
	 * 这部分重复的工作可以交给框架来完成
	 * @param response
	 * @param name
	 * @param age
	 * @return void
	 */
	@RequestMapping(value = "return-void-ajax", method = RequestMethod.POST)
	public void returnVoidAjax(HttpServletResponse response,
							   String name,
							   Integer age) throws IOException {
		System.out.println("name:" + name + " age:" + age);
		// 处理ajax，使用json做数据的格式
		// service调用完成了，使用Student表示处理结果
		Student student = new Student();
		student.setAge(age);
		student.setName(name);
		// 把结果的对象转换成json格式的数据
		String json = "";
		if(student != null){
			ObjectMapper om = new ObjectMapper();
			json = om.writeValueAsString(student);
			System.out.println("Student对象转换成json====" + json);
		}
		// 输出数据，响应ajax请求
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println(json);
		pw.flush();
		pw.close();
	}

	/**
	 * 使用对象接收参数，通过注解驱动返回json字符串
	 * @param student
	 * @return
	 */
	@RequestMapping(value = "return-object-json", method = RequestMethod.POST)
	@ResponseBody
	public Student returnVoidAjax(Student student) {
		return student;
	}

	/**
	 * 处理器方法返回Student,通过框架转为json，响应ajax请求
	 * @param name
	 * @param age
	 * @return Student
	 * @ResponseBody:
	 * 作用：把处理器方法返回的对象转为json后，通过HttpServletResponse输出给浏览器
	 * 和其他注解没有顺序的关系
	 */
	@RequestMapping(value = "student-json-object")
	@ResponseBody
	public Student doStudentJsonObject(String name,
									   Integer age) {
		// 调用Service，获取请求结果数据，Student表示返回的结果数据
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		// 会被框架转为json
		return student;
	}

	/**
	 * 处理器方法返回的是一个List<Student>
	 * @param student
	 * @return
	 */
	@RequestMapping(value = "student-json-List")
	@ResponseBody
	public List<Student> doStudentJsonList(Student student) {
		List<Student> list = new ArrayList();
		Student student1 = new Student();
		student1.setName("James");
		student1.setAge(23);
		Student student2 = new Student();
		student2.setName("Lebron");
		student2.setAge(23);
		list.add(student1);
		list.add(student2);
		list.add(student);
		// 最终返回给浏览器的是一个json数组，直接在浏览器中访问这个地址
		return list;
	}

	/**
	 * 处理器方法返回的是String，String表示的是数据，不是视图
	 * 区分返回值字符串是数据还是视图，是看有没有@ResponseBody这个注解
	 * 有这个注解，返回的String是数据
	 */
	@RequestMapping(value = "string-data")
	@ResponseBody
	public String doStringData(String name, Integer age) {
		return "Hello World!";
	}
}
