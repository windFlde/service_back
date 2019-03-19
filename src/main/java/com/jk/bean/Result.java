/** 
 * <pre>项目名称:wyh 
 * 文件名称:Result.java 
 * 包名:com.jk.pojo 
 * 创建日期:2018年12月14日下午9:23:39 
 * Copyright (c) 2018, All Rights Reserved.</pre> 
 */  
package com.jk.bean;

import lombok.Data;

/** 
 * <pre>项目名称：wyh    
 * 类名称：Result    
 * 类描述：    
 * 创建人：王亚辉 
 * 创建时间：2018年12月14日 下午9:23:39    
 * 修改人：王亚辉    
 * 修改时间：2018年12月14日 下午9:23:39    
 * 修改备注：       
 * @version </pre>    
 */
@Data
public class Result {
	
		//返回给前台的状态码
		private Integer code;

		private String msg;

		private Object data;

		private boolean state = true;
}
