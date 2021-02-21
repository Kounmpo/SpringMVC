package com.hui.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huang jiehui
 * @date 2021/2/16 21:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	/**
	 * 属性名与请求参数名必须一致
	 */
	String name;
	Integer age;
}
