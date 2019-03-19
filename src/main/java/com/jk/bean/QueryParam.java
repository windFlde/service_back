/** 
 * <pre>项目名称:wyh 
 * 文件名称:QueryParam.java 
 * 包名:com.jk.pojo 
 * 创建日期:2018年12月14日下午4:43:23 
 * Copyright (c) 2018, All Rights Reserved.</pre> 
 */  
package com.jk.bean;

import lombok.Data;

import java.util.List;

/** 
 * <pre>项目名称：wyh    
 * 类名称：QueryParam    
 * 类描述：    
 * 创建人：王亚辉 
 * 创建时间：2018年12月14日 下午4:43:23    
 * 修改人：王亚辉    
 * 修改时间：2018年12月14日 下午4:43:23    
 * 修改备注：       
 * @version </pre>    
 */
@Data
public class QueryParam {
	
	private Integer userId;
	
	private Integer roleId;
	
	private List<Integer> roid;//接受的角色id
	
	private List<Integer> powerId;//接受的权限id
	
	private List<User> user;//接受批量新增数据
	
	private String phone_no;//发送验证码的手机号
	
	private String verify_code;//用户输入的验证码
}
